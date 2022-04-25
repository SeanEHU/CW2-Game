import java.io.FileReader;

public class Game {
    
    public Location[4][4] locationArray = null;
    public Player player = null;
    private boolean gameWon = false;

    public Game() {

        this.locationArray = loadLocations();
        this.player = new Player;

    }

    private Location[] loadLocations() {
        
        FileReader mapReader = new FileReader('.src/map.json');
        BufferedReader bufferedReader = new BufferedReader(mapReader);

        for(y = 0, i <= 3, i++){
            for( = 0, i <= 3, i++){
                line = bufferedReader.readLine();
                obj = new JSONParser().parse(line);
                json.add(obj);
                Location[x][y] = new Location(obj.get("name"), obj.get("desc"))
            }
        }


    }

}
