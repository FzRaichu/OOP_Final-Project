package model;

import skill.*;

public class Smoker extends Agent implements Smoke, Blind, Unique, Ultimate{
	private String smokeSkillName;
	private String blindSkillName;
	private String uniqueSkillName;
	private int maxSmokeCount;
	
	public Smoker(String id, String name, String ultimateName, int requiredUltimateOrb, int hp, String baseWeapon,
			Origin origin, Season releasedSeaon, String smokeSkillName, String blindSkillName, String uniqueSkillName,
			int maxSmokeCount) {
		super(id, name, ultimateName, requiredUltimateOrb, hp, baseWeapon, origin, releasedSeaon);
		this.smokeSkillName = smokeSkillName;
		this.blindSkillName = blindSkillName;
		this.uniqueSkillName = uniqueSkillName;
		this.maxSmokeCount = maxSmokeCount;
	}

	@Override
	public void useUltimate() {
		// TODO Auto-generated method stub
		System.out.println(name + "  Controls Ultimate [" + ultimateName + "] !!!");
	}

	@Override
	public void useUniqueSkill() {
		// TODO Auto-generated method stub
		System.out.println(name + " uses utility [" + uniqueSkillName + "]");
	}

	@Override
	public void castBlind() {
		// TODO Auto-generated method stub
		System.out.println(name + " blinding [" + blindSkillName + "]");
	}

	@Override
	public void castSmoke() {
		// TODO Auto-generated method stub
		System.out.println(name + " deploys smoke [" + smokeSkillName + "] (Max: " + maxSmokeCount + ")");
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\n" +
	            "------------------------------------------------------------\n" +
	            "| [CONTROLLER ABILITIES]                                   |\n" +
	            "| > Smoke  : %-45s |\n" +
	            "| > Blind  : %-45s |\n" +
	            "| > Unique : %-45s |\n" +
	            "| * Passive: Max Smoke Stock: %-29d |\n" +
	            "============================================================", 
	            smokeSkillName, blindSkillName, uniqueSkillName, maxSmokeCount);
	}

	@Override
	public void useAllSkills() {
		this.castSmoke();
		this.castBlind();
		this.useUniqueSkill();
		this.useUltimate();
	}
}	
