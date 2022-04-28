public class Player extends Mob {

	private int[] location = null;
	
	public Player(String pName) {

        location = new int[] {1,2}; //Sets the player to the start location
        this.name = pName;
		
	}
	
	public void heal(int healVal) {
		health += healVal;
	}
	
	public void moveX(int moveNum) {
		this.location[0] += moveNum;
	}
	public void moveY(int moveNum) {
		this.location[0] += moveNum;
	}
	
	public int getLocX() {
		return this.location[0];
	}

    public int getLocY() {
		return this.location[1];
	}
	
}