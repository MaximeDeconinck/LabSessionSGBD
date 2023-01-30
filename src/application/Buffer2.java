package application;

import java.util.ArrayList;

public class Buffer2 {
  protected ArrayList<String> elements;
  protected final int size = 4;
  private int resourceNotFoundCounter = 0;

  public Buffer2() {
    this.elements = new ArrayList<>(size);
  }

  public boolean hasEmptySpace() {
    return elements.size() < size;
  }

  public String getResource(String resource) {
    if (elements.contains(resource)) {
      return "Element is there.";
    }
    resourceNotFoundCounter++;
    return "Element not found.";
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
}
