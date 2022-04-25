// --== CS400 File Header Information ==--
// Name: Carlos A. Guzman-Cruz
// Email: cguzmancruz@wisc.edu
// Team: AE Blue
// TA: Illay
// Lecturer: Gary
// Notes to Grader: None

import java.util.ArrayList;
import java.util.List;


interface ambulanceBackEndInterface {

  /*
   * A way to add leaves or edges into the map with a specific weight which represents the time to
   * get to that location from source to target.
   */
  public boolean insertEdge(String source, String target, int weight);

  /*
   * Method to insert locations themselves into the map
   */
  public boolean insertLocation(String location);

  /*
   * A way to quickly check if a location is in the map and see if the user input valid location in
   * map
   */
  public boolean containsLocation(String data);

  /*
   * A method to give a list of locations in order to get to the hospital in a fast maner. Used to
   * check user input
   */
  public List<String> shortestPathToHospital(String startLocation, String endLocation);

  /*
   * A way to see how long it will take to get to the hospital, a way to either give clues or
   * urgency to the user
   */
  public int getTimeToHospital(String start, String end);

}


public class AmbulanceBackEnd implements ambulanceBackEndInterface {

  private CS400Graph<String> mapOfGame;

  /**
   * Constructor for creating the map
   */
  public AmbulanceBackEnd() {
    mapOfGame = new CS400Graph<>();
  }

  /**
   * This method will creat an edge with two locations and a weifght with is the time to go between
   * the two locations
   */
  @Override
  public boolean insertEdge(String source, String target, int weight) {
    return mapOfGame.insertEdge(source, target, weight);
  }

  /**
   * This method will add the location of the map
   */
  @Override
  public boolean insertLocation(String location) {
    return mapOfGame.insertVertex(location);
  }

  /**
   * This will check if the location is already in the map
   */
  @Override
  public boolean containsLocation(String data) {
    return mapOfGame.containsVertex(data.toString());
  }

  /**
   * 
   */
  @Override
  public List<String> shortestPathToHospital(String startLocation, String endLocation) {
    List<String> directions = mapOfGame.shortestPath(startLocation, endLocation);
    return directions;
  }

  /**
   * This method will how long the time to the hospital should be in total from the start to the
   * hospital. It is meant to give hints to the user.
   */
  @Override
  public int getTimeToHospital(String start, String end) {
    return mapOfGame.getPathCost(start, end);
  }
}





class AmbulanceBackEndPlaceholder implements ambulanceBackEndInterface {
  private MapDataInterface location;

  @Override
  public boolean insertEdge(String source, String target, int weight) {
    return false;
  }

  @Override
  public boolean insertLocation(String location) {
    return true;
  }

  @Override
  public boolean containsLocation(String data) {
    return true;
  }

  @Override
  public List<String> shortestPathToHospital(String startLocation, String endLocation) {
    List<String> list = new ArrayList<String>();
    list.add(location.toString());
    return list;
  }

  @Override
  public int getTimeToHospital(String start, String end) {
    return 0;
  }


}
