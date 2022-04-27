import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
            BufferedReader mapReader = new BufferedReader(new InputStreamReader(new FileInputStream("game/map/map.csv"), "UTF8")); //Specify charset to prevent encoding errors
            String line = "";

            for(int y = 0; y <= 3; y++){
                for(int x = 0 ; x <= 3; x++){
                    line = mapReader.readLine();
                    System.out.println(line);
                    String[] values = line.split(",");
                    this.locationArray[x][y] = new Location(values[0], values[1]);
                    
                }
            }
            mapReader.close();
        }
        catch(IOException e){
            System.out.println("oops, an error occured.");
            System.out.println(e);
        }
        finally{
            
        }


    }

}
