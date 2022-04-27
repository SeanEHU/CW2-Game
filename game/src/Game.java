import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    
    public Location[][] locationArray = new Location[4][4];
    //public Player player = null;
    private boolean gameWon = false;

    public Game() {

        this.loadLocations();
        //this.player = new Player;

        for(int y = 0; y <= 3; y++){
            for(int x = 0 ; x <= 3; x++){
                
                System.out.println(this.locationArray[x][y].getName());
                System.out.println(this.locationArray[x][y].getDesc());
                
            }
        }

    }

    private void loadLocations() {
        
        try{
            FileReader mapReader = new FileReader("./src/map.csv");
            BufferedReader bufferedReader = new BufferedReader(mapReader);
            String line = "";

            for(int y = 0; y <= 3; y++){
                for(int x = 0 ; x <= 3; x++){
                    line = bufferedReader.readLine();
                    System.out.println(line);
                    String[] values = line.split(",");
                    this.locationArray[x][y] = new Location(values[0], values[1]);

                    bufferedReader.close();
                }
            }
        }
        catch(IOException e){
        }
        finally{}


    }

}
