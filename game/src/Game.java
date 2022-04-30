import java.io.BufferedReader; 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Game {
    
    private Location[][] locationArray = new Location[4][4]; //a 2d array to store the data for each location the player can visit
    private Player player = null;
    private boolean gameOver = false; //tracks if the game has ended

    public Game() { //initialises the game by loading locations from file and naming the player class

        this.loadLocations();
        
        Boolean waitName = true;
        while(waitName){ //while waiting for the player to input a valid name
            String playerName = "";

            playerName = JOptionPane.showInputDialog(
                "What is your name:\n");
                
            if (playerName != ""){ //if the player entered something
                this.player = new Player(playerName);
                waitName = false;
            } //otherwise ask for a name again
        }
    }

    private void loadLocations() { //Builds the locationArray with location objects retrieved from the map.scv file
        
        try{
            BufferedReader mapReader = new BufferedReader(new InputStreamReader(new FileInputStream("game/map/map.csv"), "UTF8")); //Specify charset to prevent encoding errors
            String line = "";

            for(int y = 0; y <= 3; y++){ //Starting with the first row 
                for(int x = 0 ; x <= 3; x++){ //Generate each location along the Y axis
                    line = mapReader.readLine();
                    String[] values = line.split(",");
                    this.locationArray[x][y] = new Location(values[0], values[1]);
                    
                }
            }
            mapReader.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"oops, an error occured.");
        }
        finally{
            
        }

    }

    public void nextTurn() { //Is called at the start of each 'turn'

        String input = "";

        input = JOptionPane.showInputDialog(
            "You are at the "
            + this.getPlayerLocName()
            + "\n What would you like to do?\n"
            +"(Type Help for a list of commands)");

        //Processes the user input
        if(input.toLowerCase().contains("help")){
            JOptionPane.showMessageDialog(null,"You can 'look' around. You can try to 'go North/South/East/West'. Or you can 'quit' the game.");
            }
        else if (input.toLowerCase().contains("look")){
            JOptionPane.showMessageDialog(null,"You can look around. You see:\n" + getPlayerLocDesc());
        }
        else if(input.toLowerCase().contains("go")){
                this.movePlayer(input);
            }
        else if(input.toLowerCase().contains("quit")){
            this.gameOver = true;
        }
        else {
            JOptionPane.showMessageDialog(null,"Sorry, I couldn't understand that. Type 'help' if you need a reminder of the commands.");
            }

    }

    private String getPlayerLocName() { //returns the name of the location the player is currently at
        return this.locationArray[this.player.getLocX()][this.player.getLocY()].getName();
    }

    private String getPlayerLocDesc() { //returns the description of the location the player is currently at
        return this.locationArray[this.player.getLocX()][this.player.getLocY()].getDesc();
    }

    private void movePlayer(String direction) { //processes the players input, if they have entered the command 'go'

        if(direction.toLowerCase().contains("north")){

                this.player.moveY(-1);
                JOptionPane.showMessageDialog(null,"You move North to the " + getPlayerLocName());

            }
        else if(direction.toLowerCase().contains("south")){

            this.player.moveY(1);
            JOptionPane.showMessageDialog(null,"You move South to the " + getPlayerLocName());

        }
        else if(direction.toLowerCase().contains("east")){

            this.player.moveX(1);
            JOptionPane.showMessageDialog(null,"You move East to the " + getPlayerLocName());


        }
        else if(direction.toLowerCase().contains("west")){

            this.player.moveX(-1);
            JOptionPane.showMessageDialog(null,"You move West to the " + getPlayerLocName());

        }
        else{
            JOptionPane.showMessageDialog(null,"Sorry, I can't understand what direction you are trying to go.");
        }
    }

    public boolean isGameOver() { //Getter to check if the game has ended
        return this.gameOver;
    }

}
