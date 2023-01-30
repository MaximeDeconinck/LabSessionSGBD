package application;

public class main1 {

	public static void main(String[] args) throws InterruptedException {

		LRU cache = new LRU();

		cache.add("A");
		
		cache.add("B");

		cache.add("C");

		cache.add("D");
		
		
		System.out.println(cache.getResource("A")); // renvoie "Element is there."

		System.out.println(cache.getResource("E")); // renvoie "Element not found."

		cache.add("E");

		System.out.println(cache.getResource("B")); // renvoie "Element not found."
		System.out.println(cache.getResource("E")); // renvoie "Element is there."

		cache.add("K");
	
		
		System.out.println("----------------------------------------------------------");
		
		
		FIFO fifo = new FIFO();
	    fifo.add("A");
	    fifo.add("B");
	    fifo.add("C");
	    fifo.add("D");
        
	    
	    fifo.add("E");
	    
	    System.out.println("Elements in the FIFO buffer: ");
	    fifo.printElementsWithAccessTime();
        
		
	    fifo.add("E");
	    System.out.println("----------------------------------------------------------");
	    
	    fifo.printElementsWithAccessTime();
		
	}

}
