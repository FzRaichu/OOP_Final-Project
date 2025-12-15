package model;

public class AgentStats {
	private int health;
	private String baseWeapon;
	public AgentStats(int health, String baseWeapon) {
		super();
		this.health = health;
		this.baseWeapon = baseWeapon;
	}
	
	public int getHealth() {
		return health;
	}

	public String getBaseWeapon() {
		return baseWeapon;
	}

}
