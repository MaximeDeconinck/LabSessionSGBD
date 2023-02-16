package Session2;

public class Node {
	
	int size;
	int[] keys;
	Node[] children;
	Node parent;
	boolean isLeaf;
	
	public Node(int m) {
		size = m - 1;
		keys = new int[size];
		children = new Node[m];
		parent = null;
	}
	
	public int getKey(int i) {
        return keys[i];
    }

    public Node getChild(int i) {
        return children[i];
    }
	
}
