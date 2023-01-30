package application;

import java.util.ArrayList;

public class Clock extends Buffer2 {
	private ArrayList<Integer> flags;
	private int clock = 0;

	public Clock() {
		super();
		this.flags = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			this.flags.set(i, 0);
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
		if (!hasEmptySpace()) {
			int indexToReplace = getClockIndex();
			elements.set(indexToReplace, element);
			flags.set(indexToReplace, 1);
		} else {
			elements.add(element);
			flags.set(flags.indexOf(element), 1);
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
		return "Element not found.";
	}
	
	public int getClockIndex() {
		int index;
		while (true) {
			if (this.flags.get(clock) == 1) {
				this.flags.set(clock, 0);
				clock++;
			} else {
				index = clock;
				break;
			}
		}
		return index;
	}
}
