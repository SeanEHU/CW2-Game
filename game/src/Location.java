public class Location {

    private String name = "Null"; //name shown to a player when entering a new loction
    private String desc = "Null"; //description shown to a player when they 'look'
    private int[] nav = new int[4]; //array to store the locations to more the player to when moving 

    public Location(String lName, String lDesc) {

        this.name = lName;
        this.desc = lDesc;

    }

    public String getName() {

        return this.name;

    }

    public String getDesc() {

        return String.format("You are in %s. You look around and see %s", this.name, this.desc);

    }

    public int move(int dir) {

        return this.nav[dir];

    }
}