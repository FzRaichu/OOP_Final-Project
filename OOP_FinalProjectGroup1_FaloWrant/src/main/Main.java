package main;

import java.util.ArrayList;
import java.util.Scanner;

import generic.FaloWrantRepository;
import model.*;

public class Main {
	Scanner scan = new Scanner(System.in);
	FaloWrantRepository<Agent> repository = new FaloWrantRepository<Agent>();
	
	void seedData() {
		Origin morocco = new Origin("Morocco");
		Origin korea = new Origin("Korea");
        Season ign1 = new Season("Ignition", 1); 
        
        repository.add(new Sentinel("A01", "Cypher", "Neural Theft", 6, 100, "Vandal", morocco, ign1, "Trapwire", "Cyber Cage", "Spycam", 15));
        repository.add(new Duelist("A02", "Jett", "Blade Storm", 7, 100, "Operator",korea, ign1, "Tailwind", "Cloudburst", "Updraft", 2));
	}
	
	void clearConsole() {
		for(int i = 0; i < 30; i++){
			System.out.println();
		}
	}
	
    private Agent inputAgentData(String id) {
    	try {
    		System.out.print("Name: "); String name = scan.nextLine();
    		System.out.print("Ultimate Name: "); String ultName = scan.nextLine();
    		System.out.print("Ult Orb Cost: "); int orb = scan.nextInt(); scan.nextLine();
    		System.out.print("HP: "); int hp = scan.nextInt(); scan.nextLine();
    		System.out.print("Main Weapon: "); String weapon = scan.nextLine();
    		
    		System.out.print("Origin Country: "); String country = scan.nextLine();
    		System.out.print("Season Episode: "); String ep = scan.nextLine();
    		System.out.print("Season Act (int): "); int act = scan.nextInt(); scan.nextLine();
    		
    		Origin origin = new Origin(country);
    		Season season = new Season(ep, act);
    		
    		while (true) {
    			System.out.println("Select Role: 1.Sentinel | 2.Duelist | 3.Smoker | 4.Initiator");
        		System.out.print(">> Choice: ");
        		int role = scan.nextInt(); scan.nextLine();
        		switch (role) {
        		case 1:
        			System.out.print("Trap Skill Name: "); String trap = scan.nextLine();
        			System.out.print("Damage Skill Name: "); String dmg = scan.nextLine();
        			System.out.print("Unique Skill Name: "); String uniq = scan.nextLine();
        			System.out.print("Trap Cooldown (sec): "); int cd = scan.nextInt(); scan.nextLine();
        			return new Sentinel(id, name, ultName, orb, hp, weapon, origin, season, trap, dmg, uniq, cd);
        			
        		case 2: // Duelist
        			System.out.print("Escape Skill Name: "); String esc = scan.nextLine();
        			System.out.print("Blind Skill Name: "); String bln = scan.nextLine();
        			System.out.print("Smoke Skill Name: "); String smk = scan.nextLine();
        			System.out.print("Reset on Kills (int): "); int kill = scan.nextInt(); scan.nextLine();
        			return new Duelist(id, name, ultName, orb, hp, weapon, origin, season, esc, bln, smk, kill);
        		case 3:
        			System.out.print("Smoke Skill Name: "); String sName = scan.nextLine();
        			System.out.print("Blind Skill Name: "); String bName = scan.nextLine();
        			System.out.print("Unique Skill Name: "); String uName = scan.nextLine();
        			System.out.print("Max Smoke Count: "); int count = scan.nextInt(); scan.nextLine();
        			return new Smoker(id, name, ultName, orb, hp, weapon, origin, season, sName, bName, uName, count);
        			
        		default:
        			System.out.println("!! Invalid Role Choice.");
        			continue;
        		}
    		}
    	} catch (Exception e) {
    		System.out.println("!! Input Error (Check number/text format).");
    		scan.nextLine();
    		return null;
    	}
    }

	
	private void addAgent() {
        System.out.println("\n--- RECRUIT NEW AGENT ---");
        System.out.print("Enter ID: ");
        String id = scan.nextLine();

        if (repository.findById(id) != null) {
            System.out.println("!! Error: ID already exists.");
            System.out.println("Press Enter to Continue...");
            scan.nextLine();
            return;
        }

        Agent newAgent = inputAgentData(id);
        if (newAgent != null) {
            repository.add(newAgent);
            System.out.println("Press Enter to Continue...");
            scan.nextLine();
        }
    }

    private void printAgents(){
        ArrayList<Agent> list = repository.getAll();
        if (list.isEmpty()) {
            System.out.println(">> No Data Available.");
            return;
        }
        
        System.out.println("\n----------------------- AGENT LIST -------------------------");
        for (Agent agent : list) {
            System.out.println(agent);
            System.out.println();
        }
    }

    private void viewAgents() {
    	printAgents();
        System.out.println("Press Enter to Continue...");
        scan.nextLine();
    }

    private void searchAgent() {
        System.out.print("Enter Name to search: ");
        String name = scan.nextLine();
        ArrayList<Agent> results = repository.search(name);
        if (results.isEmpty()) {
            System.out.println(">> No Data Available.");
            System.out.println("Press Enter to Continue...");
            scan.nextLine();
            return;
        }
        
        for (Agent agent : results) {
        	System.out.printf("\n-------------- %s USE SKILL ----------------\n", agent.getName());
            agent.useAllSkills();
            System.out.println();
        }
        System.out.println("Press Enter to Continue...");
        scan.nextLine();
    }

    private void updateAgent() {
    	if(repository.getAll().isEmpty()) {
    		System.out.println(">> No Data Available.");
    		System.out.println("Press Enter to Continue...");
            scan.nextLine();
            return;
    	}
        printAgents();
        System.out.print("Enter ID to update: ");
        String id = scan.nextLine();
        Agent existing = repository.findById(id);

        if (existing == null) {
            System.out.println("!! Agent not found.");
            System.out.println("Press Enter to Continue...");
            scan.nextLine();
            return;
        }

        System.out.println(">> Agent Found: " + existing.getName());
        System.out.println(">> Enter new details:");
        
        Agent updatedAgent = inputAgentData(id);
        
        if (updatedAgent != null) {
            repository.update(id, updatedAgent);
            System.out.println("Press Enter to Continue...");
            scan.nextLine();
        }
    }

    private void deleteAgent() {
    	if(repository.getAll().isEmpty()) {
    		System.out.println(">> No Data Available.");
    		System.out.println("Press Enter to Continue...");
            scan.nextLine();
            return;
    	}
        printAgents();
        System.out.print("Enter ID to delete: ");
        String id = scan.nextLine();
        repository.delete(id);
        System.out.println("Press Enter to Continue...");
        scan.nextLine();
    }

	public Main() {
		// TODO Auto-generated constructor stub
		seedData();
		int choice;
        while (true){
        	clearConsole();
            System.out.println("==========================================");
            System.out.println("   FALOWRANT PROTOCOL - AGENT MANAGER");
            System.out.println("==========================================");
            System.out.println("1. Add Agent");
            System.out.println("2. View All Agents");
            System.out.println("3. Search Agent to use all skills");
            System.out.println("4. Update Agent");
            System.out.println("5. Delete Agent");
            System.out.println("6. Sort Agents (By Name)");
            System.out.println("7. Exit");
            System.out.print(">> ");

            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("!! Invalid Input. Please enter a number.");
                scan.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                	clearConsole();
                	addAgent();
                	break;
                case 2:
                	clearConsole();
                	viewAgents();
                	break;
                case 3:
                	clearConsole();
                	searchAgent();
                	break;
                case 4:
                	clearConsole();
                	updateAgent();
                	break;
                case 5:
                	clearConsole();
                	deleteAgent();
                	break;
                case 6: 
                	clearConsole();
                    repository.sortByName(); 
                    viewAgents(); 
                    break;
                case 7: 
                    System.out.println(">> Exiting Program..."); 
                    return;
                default: 
                    System.out.println("!! Unknown Option.");
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
