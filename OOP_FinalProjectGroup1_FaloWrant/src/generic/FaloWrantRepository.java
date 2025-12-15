package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import model.*;

public class FaloWrantRepository <T extends Agent>{
	private ArrayList<T> agents = new ArrayList<>();
    
	// Fitur Create / Add
    public void add(T agent) { 
        agents.add(agent); 
        System.out.println(">> Success: Agent recruited to Protocol!");
    }
    
    // Fitur Read
    public ArrayList<T> getAll() {
    	return agents; 
    }
    
    // Fitur Cari ID untuk delete & update
    public T findById(String id) { 
        return agents.stream().filter(a -> a.getId().equalsIgnoreCase(id)).findFirst().orElse(null); 
    }
    
    // Fitur Delete
    public void delete(String id) { 
        boolean removed = agents.removeIf(a -> a.getId().equalsIgnoreCase(id)); 
        System.out.println(removed ? ">> Success: Agent removed." : ">> Error: Agent ID not found.");
    }

    // Fitur Search
    public ArrayList<T> search(String keyword) {
        return agents.stream().filter(a -> a.getName().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    // Fitur Update
    public void update(String id, T newAgentData) {
        for (int i = 0; i < agents.size(); i++) {
            if (agents.get(i).getId().equalsIgnoreCase(id)) {
                agents.set(i, newAgentData);
                System.out.println(">> Success: Agent data updated.");
                return;
            }
        }
        System.out.println(">> Error: Agent not found.");
    }

    // Fitur Sort
    public void sortByName() { 
        Collections.sort(agents); 
        System.out.println(">> Success: Database sorted by Name.");
    }
}
