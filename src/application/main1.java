package application;

public class main1 {

	public static void main(String[] args) throws InterruptedException {

		LRU cache = new LRU();

		cache.add("A");
<<<<<<< HEAD
		
=======

>>>>>>> 2735d59a7916519e6c35bcbba0becb7feb9d6a7b
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
		
<<<<<<< HEAD
		
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
=======
		FIFO cache2 = new FIFO();
		
		cache2.add("A");
		cache2.add("B");
		cache2.add("C");
		cache2.add("D");
	
		cache2.add("");

		System.out.println("----------------------------------------------------------");
>>>>>>> 2735d59a7916519e6c35bcbba0becb7feb9d6a7b
		
		Clock cache3 = new Clock();
		
		cache3.add("A");
		cache3.add("B");
		cache3.add("C");
		cache3.add("D");
		
		cache3.printElements();
		cache3.printFlags();
		
		cache3.add("E");
		
		cache3.printElements();
		cache3.printFlags();
	}

}
