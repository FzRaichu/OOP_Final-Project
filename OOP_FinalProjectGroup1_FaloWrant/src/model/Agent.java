package model;

public abstract class Agent implements Comparable<Agent>{
	protected String id;
	protected String name;
	protected String ultimateName;
	protected int requiredUltimateOrb;
	
	protected AgentStats stats; // Composition
	protected Origin origin; // Aggregation
	protected Season releasedSeaon; // Association
	
	public Agent(String id, String name, String ultimateName, int requiredUltimateOrb, int hp, String baseWeapon, Origin origin,
			Season releasedSeaon) {
		super();
		this.id = id;
		this.name = name;
		this.ultimateName = ultimateName;
		this.requiredUltimateOrb = requiredUltimateOrb;
		this.stats = new AgentStats(hp, baseWeapon);
		this.origin = origin;
		this.releasedSeaon = releasedSeaon;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public abstract void useAllSkills();
	
	public int compareTo(Agent other) {
		return this.name.compareToIgnoreCase(other.name);
	}
	
	public String toString() {
		String header = String.format(
		        "============================================================\n" +
		        "| %-20s | Role: %-15s | ID: %-5s |\n" +
		        "------------------------------------------------------------\n" +
		        "| Origin : %-17s | %-27s |\n" +
		        "| Status : HP %-3d / %-8s | Ult Cost: %-17d |\n" +
		        "| ULT    : %-47s |",
		        name.toUpperCase(), this.getClass().getSimpleName(), id,
		        origin.toString(), releasedSeaon.toString(),
		        stats.getHealth(), stats.getBaseWeapon(), requiredUltimateOrb,
		        ultimateName
		    );
		    return header;
	}
	
}
