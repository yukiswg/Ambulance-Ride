// --== CS400 File Header Information ==--
// Name: Jiahao Zheng
// Email: jzheng233@wisc.edu
// Team: AE Blue
// TA: Ilay
// Lecturer: Gary Dahl
import java.io.FileNotFoundException;
import java.awt.Font;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is front end interface
 * 
 * @author Jiahao Zheng
 *
 */
interface AmbulanceFrontEndInterface {
  public void run(ambulanceBackEndInterface engine);

}


/**
 * This class is for front end run() method
 * 
 * @author Jiahao Zheng
 *
 */
public class AmbulanceFrontEnd implements AmbulanceFrontEndInterface {

  /**
   * this method is to run front end code
   */
  @Override
  public void run(ambulanceBackEndInterface engine) {
    boolean quit = false;
    Scanner scnr = new Scanner(System.in);

    // welcome print
    System.out.println("    0/" + "\n" + "   /|" + "\n" + "   /" + " \\");
    System.out.println("Hello my friend!");
    System.out.println("Welcome you to Ambulance Shortest Path Game!!!!!");
    System.out.println("In this game, you will need to find shortest path so that the ambulance "
        + "can take the patients reach the hospital as soon as possible! "
        + "You will need to type the correct path, if you type correct character, you can "
        + "continue type next character. BUT if you don't make it, you have to restart from "
        + "begining! Try your best to save your patients!\n");
    System.out.println("There are command characters for this game: ");
    System.out.println("\tType 's' to Start the Game!");
    System.out.println("\tType 'q' to Quit the Game!");

    while (!quit) {
      char userInput = scnr.next().charAt(0);
      // User start the game
      if (Character.toLowerCase(userInput) == 's') {
        boolean result = matchString(engine, scnr);
        if(!result) {
          System.out.println();
          System.out.println("Opps! You are in a wrong path! Please try again!");
          System.out.println();
          System.out.println("\tType 's' to Start Again");
          System.out.println("\tType 'q' to Quit the Game!");
        }else {
          System.out.println("");
          System.out.println("Congratulations! You save your patients!");
          System.out.println("\tType 's' to Start Again");
          System.out.println("\tType 'q' to Quit the Game!");
        }
      }
      
      // User quit the game
      else if(Character.toLowerCase(userInput) == 'q') {
        quit = true;
        System.out.println("Thank you for playing, we need your support for future games");
      }else {
        System.out.println("Please re-enter a valid command");
        System.out.println("\tType 's' to Start Again");
        System.out.println("\tType 'q' to Quit the Game!");
      }
    }
  }

  /**
   * A helper method that match the users input with the shortest path
   * 
   * @param engine backend object
   * @param scnr user input
   * @return ture if it's the path
   */
  private boolean matchString(ambulanceBackEndInterface engine, Scanner scnr) {
    System.out.println("Here is a map in the following format (start, end, time)");
    System.out.println("a,m,1\n" + "a,l,2\n" + "a,k,3\n" + "a,j,4\n" + "a,c,3\n" + "a,e,8\n"
        + "b,a,1\n" + "b,i,5\n" + "b,f,2\n" + "c,m,2\n" + "c,e,2\n" + "d,k,9\n" + "d,f,1\n"
        + "e,g,1\n" + "f,g,1\n" + "f,i,2\n" + "g,h,1\n" + "g,a,4\n" + "h,i,5\n" + "h,b,1\n"
        + "i,b,5\n" + "j,m,3");
    boolean check = true;
    System.out.println("Please enter Start point!");
    String start = scnr.next();
    System.out.println("Please enter End point!");
    String end = scnr.next();

    List<String> list = new ArrayList<>();

    if (engine.containsLocation(start) == true && engine.containsLocation(end) == true) {
      try {
        list = engine.shortestPathToHospital(start, end);
      } catch (Exception e) {
        System.out.print("\n");
        System.out.println("Can not get a path between two points, please enter new points");
        System.out.print("\n");
        matchString(engine, scnr);
      }
    }

    if (engine.containsLocation(start) != true || engine.containsLocation(end) != true) {
      System.out.print("\n");
      System.out.println("Please enter exists points");
      System.out.print("\n");
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.println("Please enter the valie character get correct shortest path");
      if (list.get(i).toLowerCase().equals(scnr.next().toLowerCase())) {
        System.out.println("That's correct choice!");
        continue;
      } else {
        check = false;
        return check;
      }
    }
    return check;
  }

  public static void main(String[] args) throws FileNotFoundException {
    ambulanceBackEndInterface front_end_application;
    List<MapDataInterface> stuff = new ArrayList<>();
    AmbulanceFrontEndInterface frontEnd = null;
    MapLoader load = new MapLoader();
    stuff = load.loadFile("./edges.txt");

    front_end_application = new AmbulanceBackEnd();

    for (MapDataInterface node : stuff) {

      front_end_application.insertLocation(node.getSource());
      front_end_application.insertLocation(node.getDestination());
    }

    for (MapDataInterface node : stuff) {
      front_end_application.insertEdge(node.getSource(), node.getDestination(),
          node.getPathLength());
      frontEnd = new AmbulanceFrontEnd();
    }

    frontEnd.run(front_end_application);
  }

}



class AmbulanceFrontEndPlaceholder implements AmbulanceFrontEndInterface {
  public void run(ambulanceBackEndInterface engine) {
    System.out.println("This front end has not been implemented yet.");
  }
}
