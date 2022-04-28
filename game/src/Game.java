import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    
    private Location[][] locationArray = new Location[4][4];
    private Player player = null;
    private boolean gameWon = false;

    public Game() {

        this.loadLocations();
        
        Scanner nameIn = new Scanner(System.in);
        System.out.println("Welcome to the game, what is your name?");
        String playerName = nameIn.nextLine();
        this.player = new Player(playerName);
        nameIn.close();
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
            System.out.println("oops, an error occured.");
            System.out.println(e);
        }
        finally{
            
        }

    }

    public void nextTurn() {

        String input = "";
        Scanner in = new Scanner(System.in);

        System.out.print("You are at the ");
        System.out.println(this.getPlayerLocName());

        System.out.println("What would you like to do? (Type Help for a list of commands)");
        input = in.nextLine();

        if(input.toLowerCase().contains("help")){
            System.out.println("You can 'look' around. Or you can try to 'go North/South/East/West'.");
        }
        else if(input.toLowerCase().contains("go")){
            this.movePlayer(input);
        }
        else {
            System.out.println("Sorry, I couldn't understand that. Type 'help' if you need a reminder of the commands.");
        }
        
        in.close();
    }

    private String getPlayerLocName() {
        return this.locationArray[this.player.getLocX()][this.player.getLocX()].getName();
    }

    private void movePlayer(String direction) {

        try{
            if(direction.toLowerCase().contains("north")){

                this.player.moveY(-1);
                System.out.print("You move North to the ");
                System.out.println(getPlayerLocName());

            }
            else if(direction.toLowerCase().contains("south")){

                this.player.moveY(1);
                System.out.print("You move South to the ");
                System.out.println(getPlayerLocName());

            }
            else if(direction.toLowerCase().contains("east")){

                this.player.moveX(1);
                System.out.print("You move East to the ");
                System.out.println(getPlayerLocName());


            }
            else if(direction.toLowerCase().contains("west")){

                this.player.moveX(-1);
                System.out.print("You move West to the ");
                System.out.println(getPlayerLocName());

            }
            else{
                System.out.println("Sorry, I can't understand what direction you are trying to go.");
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("You cant seem to go that way, try another.");
        }

    }

    public boolean hasGameWon() {
        return this.gameWon;
    }

}
