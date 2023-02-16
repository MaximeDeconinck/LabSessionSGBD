package Session1;

import java.util.ArrayList;

public class Clock extends Buffer {
	private ArrayList<Integer> flags;
	private int clock = 0;

	public Clock() {
		super();
		this.flags = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			this.flags.add(0);
		}
	}

	public void rotate() {
		this.clock++;
		if (this.clock == 4) {
			this.clock = 0;
		}
	}

	@Override
	public boolean add(String element) {
		if (elements.contains(element)) {
			flags.set(elements.indexOf(element), 1);
			return true;
		}
		if (!hasEmptySpace()) {
			int indexToReplace = getClockIndex();
			elements.set(indexToReplace, element);
			flags.set(indexToReplace, 1);
		} else {
			int index = findEmptySpace();
			elements.add(index, element);
			flags.set(index, 1);
		}
		return true;
	}

	@Override
	public String getResource(String resource) {
		int index = elements.indexOf(resource);
		if (index != -1) {
			flags.set(index, 1);
			return "Element is there.";
		}
		ressourceNotFoundCounter++;
		return "Element not found.";
	}

	public int getClockIndex() {
		int index;
		while (true) {
			if (this.flags.get(clock) == 1) {
				this.flags.set(clock, 0);
				rotate();
			} else {
				index = clock;
				break;
			}
		}
		return index;
	}

	public void printElements() {
		for (int i = 0; i < size; i++) {
			System.out.println("Element : " + elements.get(i));
		}
	}

	public void printFlags() {
		for (int i = 0; i < size; i++) {
			System.out.println(flags.get(i));
		}
	}
}
