import java.util.List;

public class AmbulanceGame {
	
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Ambulance Game App");
        
        String csvFile = "edges1.csv";
        
        MapLoader data = new MapLoader();
        
        List<MapDataInterface> map = data.loadFile(csvFile );
        AmbulanceBackEnd app =  new AmbulanceBackEnd();
        
        for(MapDataInterface node: map) {
        	app.insertLocation(node.getSource());
        	app.insertLocation(node.getDestination());
        }
        
        for(MapDataInterface node: map) {
        	app.insertEdge(node.getSource(),node.getDestination(),node.getPathLength());
        }
        
        AmbulanceFrontEnd ui = new AmbulanceFrontEnd();
        ui.run(app);
    }

}

