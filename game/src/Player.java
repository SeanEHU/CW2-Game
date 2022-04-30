import javax.swing.JOptionPane;

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
		if(this.location[0] + moveNum >= 0 && this.location[0] + moveNum < 4){
			this.location[0] += moveNum;
		}
		else{
			JOptionPane.showMessageDialog(null, "You cant seem to go that way, try another.");
		}
	}
	public void moveY(int moveNum) {
		if(this.location[1] + moveNum >= 0 && this.location[1] + moveNum < 4){
			this.location[1] += moveNum;
		}
		else{
			JOptionPane.showMessageDialog(null, "You cant seem to go that way, try another.");
		}

		
	}
	
	public int getLocX() {
		return this.location[0];
	}
    public int getLocY() {
		return this.location[1];
	}
	
}