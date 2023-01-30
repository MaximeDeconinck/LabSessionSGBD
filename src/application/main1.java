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

		cache.printElementsWithAccessTime();
	}

}
