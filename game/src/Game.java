import java.io.BufferedReader; 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Game {
    
    private Location[][] locationArray = new Location[4][4];
    private Player player = null;
    private boolean gameOver = false;

    public Game() {

        this.loadLocations();
        
        Boolean waitName = true;
        while(waitName){
            String playerName = "";

            playerName = JOptionPane.showInputDialog(
                "What is your name:\n");
                
            if (playerName != ""){
                this.player = new Player(playerName);
                waitName = false;
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

    public void nextTurn() {

        String input = "";

        input = JOptionPane.showInputDialog(
            "You are at the "
            + this.getPlayerLocName()
            + "\n What would you like to do?\n"
            +"(Type Help for a list of commands)");

            
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

    private String getPlayerLocName() {
        return this.locationArray[this.player.getLocX()][this.player.getLocY()].getName();
    }

    private String getPlayerLocDesc() {
        return this.locationArray[this.player.getLocX()][this.player.getLocY()].getDesc();
    }

    private void movePlayer(String direction) {

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

    public boolean isGameOver() {
        return this.gameOver;
    }

}
