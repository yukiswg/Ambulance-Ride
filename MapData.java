// --== CS400 Project Three File Header ==--
// Name: Rudresh Upadhyaya
// Email: upadhyaya4@wisc.edu
// Team: Blue
// Group: AE
// TA: Ilay Raz
// Lecturer: Gary Dahl
// Notes to Grader: None
interface MapDataInterface {
  public String getSource();

  public String getDestination();

  public int getPathLength();
}


public class MapData implements MapDataInterface {
  private String source;
  private String destination;
  private int weightOfEdge;

  public MapData(String start, String end, int weight) {
    this.source = start;
    this.destination = end;
    this.weightOfEdge = weight;
  }

  @Override
  public String getSource() {
    return this.source;
  }

  @Override
  public String getDestination() {
    return this.destination;
  }

  @Override
  public int getPathLength() {
    return this.weightOfEdge;
  }
}


class MapDataPlaceholderA implements MapDataInterface {

  @Override
  public String getSource() {
    return "Address1";
  }

  @Override
  public String getDestination() {
    return "Address2";
  }

  @Override
  public int getPathLength() {
    return 2;
  }
}


class MapDataPlaceholderB implements MapDataInterface {

  @Override
  public String getSource() {
    return "Address3";
  }

  @Override
  public String getDestination() {
    return "Address4";
  }

  @Override
  public int getPathLength() {
    return 4;
  }

}
