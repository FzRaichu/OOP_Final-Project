package model;

import skill.*;

public class Duelist extends Agent implements Escape, Blind, Smoke, Ultimate{
	private String escapeSkillName;
	private String blindSkillName;
	private String smokeSkillName;
	private int escapeResetKills;
	
	public Duelist(String id, String name, String ultimateName, int requiredUltimateOrb, int hp, String baseWeapon,
			Origin origin, Season releasedSeaon, String escapeSkillName, String blindSkillName, String smokeSkillName,
			int escapeResetKills) {
		super(id, name, ultimateName, requiredUltimateOrb, hp, baseWeapon, origin, releasedSeaon);
		this.escapeSkillName = escapeSkillName;
		this.blindSkillName = blindSkillName;
		this.smokeSkillName = smokeSkillName;
		this.escapeResetKills = escapeResetKills;
	}
	
	@Override
	public void useUltimate() {
		// TODO Auto-generated method stub
		System.out.println(name + " UNLEASHES ULT [" + ultimateName + "] !!!");
	}
	@Override
	public void castSmoke() {
		// TODO Auto-generated method stub
		System.out.println(name + " casts smoke [" + smokeSkillName + "]");
	}
	@Override
	public void castBlind() {
		// TODO Auto-generated method stub
		System.out.println(name + " throws flash [" + blindSkillName + "]");
	}
	@Override
	public void performEscape() {
		// TODO Auto-generated method stub
		System.out.println(name + " uses movement [" + escapeSkillName + "] (Resets on " + escapeResetKills + " kills)");
	}
	@Override
	public String toString() {
		return super.toString() + String.format("\n" +
	            "------------------------------------------------------------\n" +
	            "| [DUELIST ABILITIES]                                      |\n" +
	            "| > Escape : %-45s |\n" +
	            "| > Blind  : %-45s |\n" +
	            "| > Smoke  : %-45s |\n" +
	            "| * Passive: Escape Reset on %-1s Kills                       |\n" +
	            "============================================================", 
	            escapeSkillName, blindSkillName, smokeSkillName, escapeResetKills);
	}

	@Override
	public void useAllSkills() {
		this.performEscape();
		this.castBlind();
		this.castSmoke();
		this.useUltimate();
	}
	
	
}
