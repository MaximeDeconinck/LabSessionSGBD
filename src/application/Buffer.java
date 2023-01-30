package application;

public class Buffer {
	
	String[] tab;
	
	public Buffer() {
		this.tab = new String[4];
	}
	
	public void add(String string) {
		if (!this.hasEmptySpace()) {
			System.out.println("No empty space");
			return;
		}
	}
	
	public boolean isEmtpy() {
		boolean result = true;
		for (int i = 0; i<this.tab.length; i++) {
			if (!(this.tab[i] == null)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean hasEmptySpace() {
		boolean result = false;
		for (int i = 0; i<this.tab.length; i++) {
			if (this.tab[i] == null) {
				result = true;
				break;
			}
		}
		return result;
	}
	
}
