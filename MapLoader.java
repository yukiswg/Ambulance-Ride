// --== CS400 Project Three File Header ==--
// Name: Rudresh Upadhyaya
// Email: upadhyaya4@wisc.edu
// Team: Blue
// Group: AE
// TA: Ilay Raz
// Lecturer: Gary Dahl
// Notes to Grader: None
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

interface MapLoaderInterface {

  public List<MapDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;

  public List<MapDataInterface> loadAllFilesInDirectory(String directoryPath)
      throws FileNotFoundException;
}


public class MapLoader implements MapLoaderInterface {

  public List<MapDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
    // If the csvfilepath is an empty string
    if (csvFilePath == "") {
      // FileNotFoundException is thrown
      throw new FileNotFoundException("Your csv File path is wrong");
    }
    // If the csvfilepath is an null
    if (csvFilePath == null) {
      // FileNotFoundException is thrown
      throw new FileNotFoundException("Your csv File path is null");
    }
    // csvFile path put into loadFile
    File loadFile = new File(csvFilePath);
    // If the load File does not exist
    if (!loadFile.exists()) {
      // FileNotFoundException is thrown
      throw new FileNotFoundException();
    }

    // A new array is created
    List<MapDataInterface> arr = new ArrayList<>();
    // loadFile loaded into the Scanner
    try (Scanner scnr = new Scanner(loadFile)) {
      // While the scanner reads something
      while (scnr.hasNextLine()) {
        // A new temp array is created and values from line are split and stored in it separated by
        // commas
        String[] temp = scnr.nextLine().split(",");
        MapDataInterface connectEdge = new MapData(temp[0], temp[1], Integer.parseInt(temp[2]));
        // The edge is added to array
        arr.add(connectEdge);
      }
    }
    // Array is returned
    return arr;
  }

  public List<MapDataInterface> loadAllFilesInDirectory(String directoryPath)
      throws FileNotFoundException {
    // Directory path stored in FilesInOne
    File FilesInOne = new File(directoryPath);
    // .listFiles() tells us all the files present in FilesInOne
    File[] allFiles = FilesInOne.listFiles();
    // If all files is null
    if (allFiles == null) {
      // An exception is thrown and message is printed
      throw new FileNotFoundException("Wrong input! Try again");
    }
    // A new array list created
    List<MapDataInterface> arr = new ArrayList<>();
    // For file in allFiles
    for (File file : allFiles) {
      // .isFile() tells us wether a file or not
      if (file.isFile()) {
        // .getAbsolute path returns the absolute pathname of the given file object
        arr.addAll(loadFile(file.getAbsolutePath()));
      }
    }
    // Array is returned
    return arr;
  }
}


class MapLoaderPlaceHolder implements MapLoaderInterface {

  @Override
  public List<MapDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
    MapDataInterface firstVar = new MapDataPlaceholderA();
    MapDataInterface secondVar = new MapDataPlaceholderB();
    ArrayList<MapDataInterface> newArr = new ArrayList<>();
    newArr.add(firstVar);
    newArr.add(secondVar);
    return newArr;
  }

  @Override
  public List<MapDataInterface> loadAllFilesInDirectory(String directoryPath)
      throws FileNotFoundException {
    MapDataInterface firstVar = new MapDataPlaceholderA();
    MapDataInterface secondVar = new MapDataPlaceholderB();
    MapDataInterface thirdVar = new MapDataPlaceholderB();
    ArrayList<MapDataInterface> newArr = new ArrayList<>();
    newArr.add(firstVar);
    newArr.add(secondVar);
    newArr.add(thirdVar);
    return newArr;
  }
}
