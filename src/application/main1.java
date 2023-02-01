package application;

import java.util.Arrays;
import java.util.List;

public class main1 {

	public static void main(String[] args) throws InterruptedException {

	
		List<String> elements = Arrays.asList("A", "B", "C", "D", "E", "A", "B", "C", "D", "E");
		System.out.println("scenario: "+ elements);
		runScenario(elements);
		
	}
	
	static void runScenario(List<String> elements) throws InterruptedException {
		
	    Clock clock = new Clock();
	    LRU lru = new LRU();
	    FIFO fifo = new FIFO();
	    
	    for (int i = 0; i < elements.size(); i++) {
	        String element = elements.get(i);
	        
	        
	        if (i >= 3) {
	            fifo.getResource(element);
	            lru.getResource(element);
	            clock.getResource(element);
	        }
	        
	        clock.add(element);
	        lru.add(element);
	        fifo.add(element);
	      
	    }

	    	    
	    System.out.println("clock resultat : " +clock.getNotFound());
	    System.out.println("lru resultat : " +lru.getNotFound());
	    System.out.println("fifo resultat : " +fifo.getNotFound());
	}



	
	
}
