
public class Mob {

	int maxHealth;
	int health;
	String name;
	
	public static void main(String[] args) {
		
	}
	
	public void takeDamage(int dmg) {	// This method takes the variable 'dmg' and takes the damage off the health of the mob
		health = health - dmg;
	}

	public int getHealth() {	// Get health method which returns the health value of the mob
	
		return health;
	}
}
 