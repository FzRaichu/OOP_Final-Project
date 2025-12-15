package model;

import skill.*;

public class Initiator extends Agent implements GatherInfo, Damage, Unique, Ultimate{
	private String gatherInfoSkillName;
	private String damageSkillName;
	private String uniqueSkillName;
	private int gatherInfoCooldown;
	
	public Initiator(String id, String name, String ultimateName, int requiredUltimateOrb, int hp, String baseWeapon,
			Origin origin, Season releasedSeaon, String gatherInfoSkillName, String damageSkillName,
			String uniqueSkillName, int gatherInfoCooldown) {
		super(id, name, ultimateName, requiredUltimateOrb, hp, baseWeapon, origin, releasedSeaon);
		this.gatherInfoSkillName = gatherInfoSkillName;
		this.damageSkillName = damageSkillName;
		this.uniqueSkillName = uniqueSkillName;
		this.gatherInfoCooldown = gatherInfoCooldown;
	}

	@Override
	public void useUltimate() {
		// TODO Auto-generated method stub
		System.out.println(name + "  INITIATE UULT [" + ultimateName + "] !!!");
	}

	@Override
	public void useUniqueSkill() {
		// TODO Auto-generated method stub
		System.out.println(name + " uses support [" + uniqueSkillName + "]");
	}

	@Override
	public void castDamage() {
		// TODO Auto-generated method stub
		System.out.println(name + " throws damage skill [" + damageSkillName + "]");
	}

	@Override
	public void scanArea() {
		// TODO Auto-generated method stub
		System.out.println(name + " reveals info [" + damageSkillName + "] + (CD: " + gatherInfoCooldown + "s)");
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\n" +
	            "------------------------------------------------------------\n" +
	            "| [INITIATOR ABILITIES]                                    |\n" +
	            "| > Info   : %-45s |\n" +
	            "| > Damage : %-45s |\n" +
	            "| > Unique : %-45s |\n" +
	            "| * Passive: Reveal Cooldown %-29s |\n" +
	            "============================================================", 
	            gatherInfoSkillName, damageSkillName, uniqueSkillName, gatherInfoCooldown + "s");
	}

	@Override
	public void useAllSkills() {
		this.scanArea();
		this.castDamage();
		this.useUniqueSkill();
		this.useUltimate();
	}
}
