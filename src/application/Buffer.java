package application;

import java.util.ArrayList;

public class Buffer {
  private ArrayList<String> elements;
  private final int size = 4;

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
}
