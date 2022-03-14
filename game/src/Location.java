public class Location {

    private String name = "Null"; //name shown to a player when entering a new loction
    private String desc = "Null"; //description shown to a player when they 'look'
    private int[] nav = new int[4]; //array to store the locations to more the player to when moving 

    public Location(String lName, String lDesc, int[] lnav) {

        this.name = lName;
        this.desc = lDesc;
        this.nav = lnav;

    }

    public String getName() {

        return this.name;

    }

    public String getDesc() {

        return String.format("You are in %s. You look around and see %s", this.name, this.desc);

    }

    public void canGo() {

        System.out.println("You can go: ");

        for (int i = 0; i < this.nav.length; i++) {

            String[] compass = {"North", "East", "South", "West"};

            if (this.nav[i] != -1) {
                System.out.println(compass[i]);
            }

        }
    }

    public int move(int dir) {

        return this.nav[dir];

    }
}