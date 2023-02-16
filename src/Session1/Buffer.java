package Session1;

import java.util.ArrayList;

public class Buffer {
	protected ArrayList<String> elements;
	protected final int size = 4;
	protected int ressourceNotFoundCounter = 0;

	public Buffer() {
		this.elements = new ArrayList<>(size);
	}

	public boolean hasEmptySpace() {
		return elements.size() < size;
	}

	public String getResource(String resource) {
		if (elements.contains(resource)) {
			return "Element is there.";
		}
		ressourceNotFoundCounter++;
		return "Element not found.";
	}
	
	public int getNotFound() {
		return ressourceNotFoundCounter;
	}
	
	public int findEmptySpace() {
		for (int i = 0; i < size; i++) {
			if (i >= elements.size() || elements.get(i) == null) {
				return i;
			}
		}
		return -1;
	}

	public boolean add(String element) throws InterruptedException {
		if (!hasEmptySpace()) {
			return false;
		}
		int index = findEmptySpace();
		elements.add(index, element);
		return true;
	}
	
	public void printElements() {
		for (int i = 0; i < size; i++) {
			System.out.println("Element : " + elements.get(i));
		}
	}
}
