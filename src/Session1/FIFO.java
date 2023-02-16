package Session1;

import java.util.ArrayList;

public class FIFO extends Buffer {
	private ArrayList<Long> entryTime;

	public FIFO() {
		super();
		this.entryTime = new ArrayList<>(size);
	}

	@Override
	public boolean add(String element) throws InterruptedException {
		if (elements.contains(element)) {
			return true;
		}
		if (!hasEmptySpace()) {
			int indexToReplace = getFIFOIndex();
			elements.set(indexToReplace, element);
			entryTime.set(indexToReplace, System.currentTimeMillis());
		} else {
			elements.add(element);
			entryTime.add(System.currentTimeMillis());
		}
		Thread.sleep(200);
		return true;
	}

	private int getFIFOIndex() {
		long oldestEntryTime = Long.MAX_VALUE;
		int oldestIndex = -1;
		for (int i = 0; i < elements.size(); i++) {
			if (entryTime.get(i) < oldestEntryTime) {
				oldestEntryTime = entryTime.get(i);
				oldestIndex = i;
			}
		}
		return oldestIndex;
	}

	public void printElementsWithAccessTime() {
		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i) + " | " + entryTime.get(i));
		}
	}
}
