package application;

import java.util.ArrayList;

public class LRU extends Buffer2 {
  private ArrayList<Long> accessTime;

  public LRU() {
    super();
    this.accessTime = new ArrayList<>(size);
  }

  @Override
  public boolean add(String element) throws InterruptedException {
    if (!hasEmptySpace()) {
      int indexToReplace = getLRUIndex();
      elements.set(indexToReplace, element);
      accessTime.set(indexToReplace, System.currentTimeMillis());
     
    } else {
      elements.add(element);
      accessTime.add(System.currentTimeMillis());
      
    }
    
    return true;
  }

  @Override
  public String getResource(String resource) {
    int index = elements.indexOf(resource);
    if (index != -1) {
      accessTime.set(index, System.currentTimeMillis());
      return "Element is there.";
    }
    return "Element not found.";
  }

  private int getLRUIndex() {
    long oldestAccessTime = Long.MAX_VALUE;
    int oldestIndex = -1;
    for (int i = 0; i < elements.size(); i++) {
      if (accessTime.get(i) < oldestAccessTime) {
        oldestAccessTime = accessTime.get(i);
        oldestIndex = i;
      }
    }
    return oldestIndex;
  }
  
  public void printElementsWithAccessTime() {
	    for (int i = 0; i < elements.size(); i++) {
	      System.out.println("Element : " + elements.get(i) + " Access Time : " + accessTime.get(i));
	    }
	}
  
  
}
