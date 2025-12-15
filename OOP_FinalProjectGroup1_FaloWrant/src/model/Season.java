package model;

public class Season {
	private String episodeName;
	private int actNumber;
	public Season(String episodeName, int actNumber) {
		super();
		this.episodeName = episodeName;
		if(actNumber >= 1 && actNumber <=3) {
			this.actNumber = actNumber;
		} else {
			System.out.println("Act number should be 1 to 3, setting up to default 1");
			this.actNumber = 1;
		}
	}
	
	public String toString() {
		return "Season: " + episodeName + " (Act " + actNumber + ")";
	}
}
