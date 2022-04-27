import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    
    public Location[][] locationArray = new Location[4][4];
    public Player player = null;
    private boolean gameWon = false;

    public Game() {

        this.loadLocations();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the game, what is your name?");
        String playerName = in.nextLine();
        this.player = new Player(playerName);
        in.close();
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
