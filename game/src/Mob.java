
public class Mob {

	protected int maxHealth;
	protected int health;
	protected String name;
	
	public void takeDamage(int dmg) {	// This method takes the variable 'dmg' and takes the damage off the health of the mob
		this.health = this.health - dmg;
	}

	public int getHealth() {	// Get health method which returns the health value of the mob
	
		return this.health;
	}

	public String getName(){
		return this.name;
	}
	
}

