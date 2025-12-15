package model;

import skill.*;

public class Sentinel extends Agent implements AntiFlank, Damage, Unique, Ultimate{
	private String antiFlankSkillName;
	private String damageSkillName;
	private String uniqueSkillName;
	private int antiFlankCooldown;
	
	public Sentinel(String id, String name, String ultimateName, int requiredUltimateOrb, int hp, String baseWeapon,
			Origin origin, Season releasedSeaon, String antiFlankSkillName, String damageSkillName,
			String uniqueSkillName, int antiFlankCooldown) {
		super(id, name, ultimateName, requiredUltimateOrb, hp, baseWeapon, origin, releasedSeaon);
		this.antiFlankSkillName = antiFlankSkillName;
		this.damageSkillName = damageSkillName;
		this.uniqueSkillName = uniqueSkillName;
		this.antiFlankCooldown = antiFlankCooldown;
	}
	
	@Override
	public void useUltimate() {
		// TODO Auto-generated method stub
		System.out.println(name + " Set Ultimate [" + ultimateName + "] !!!");
	}
	@Override
	public void useUniqueSkill() {
		// TODO Auto-generated method stub
		System.out.println(name + " uses unique skill [" + uniqueSkillName + "]");
	}
	@Override
	public void castDamage() {
		// TODO Auto-generated method stub
		System.out.println(name + " uses damage skill [" + damageSkillName + "]");
	}
	@Override
	public void setTrap() {
		// TODO Auto-generated method stub
		System.out.println(name + " places trap [" + antiFlankSkillName + "] (CD: " + antiFlankCooldown + "s)");
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\n" +
	            "------------------------------------------------------------\n" +
	            "| [SENTINEL ABILITIES]                                     |\n" +
	            "| > Trap   : %-45s |\n" +
	            "| > Damage : %-45s |\n" +
	            "| > Unique : %-45s |\n" +
	            "| * Passive: Trap Cooldown %-31s |\n" +
	            "============================================================", 
	            antiFlankSkillName, damageSkillName, uniqueSkillName, antiFlankCooldown + "s");
	}

	@Override
	public void useAllSkills() {
		this.setTrap();
		this.castDamage();
		this.useUniqueSkill();
		this.useUltimate();
	}
	
	
}
