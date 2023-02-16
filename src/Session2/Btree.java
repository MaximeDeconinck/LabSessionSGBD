package Session2;

import Session2.Node;

public class Btree {
	
    private int m; // order of the tree
    private Node root; // root of the tree

    public Btree(int order) {
        m = order;
        root = new Node(m);
        root.isLeaf = true;
    }
    
    public Node search(int k) {
        Node current = root;
        while (true) {
            int i;
            for (i = 0; i < current.size; i++) {
                if (current.getKey(i) >= k) {
                    break;
                }
            }
            if (i < current.size && current.getKey(i) == k) {
            	System.out.println("Trouvé");
                return current;
            } else if (current.isLeaf) {
            	System.out.println("Pas trouvé + dans feuille");
                return null;
            } else {
            	System.out.println("On va chercher dans un enfant");
                current = current.getChild(i);
            }
        }
    }
    
    public void insert(int k) {
        Node node = search(k);

        // If the key is already in the tree, return
        if (node != null) {
            return;
        }

        insertInNode(node, k);

        // If root is split, create a new root
        if (root.size == m) {
            Node newRoot = new Node(m);
            newRoot.children[0] = root;
            root.parent = newRoot;
            split(newRoot, 0, root);
            root = newRoot;
        }
    }

    private void insertInNode(Node node, int k) {
        if (node.size < m - 1) {
            // Node has space for new key
            int i;
            for (i = 0; i < node.size; i++) {
                if (node.getKey(i) > k) {
                    break;
                }
            }

            // Shift keys to make space for new key
            for (int j = node.size; j > i; j--) {
                node.keys[j] = node.keys[j - 1];
            }

            // Insert new key
            node.keys[i] = k;
            node.size++;
        } else {
            // Node is full, split node
            int i;
            for (i = 0; i < node.size; i++) {
                if (node.getKey(i) > k) {
                    break;
                }
            }

            // Create new node
            Node newNode = new Node(m);

            // Copy second half of keys to new node
            for (int j = (m - 1) / 2; j < node.size; j++) {
                newNode.keys[j - (m - 1) / 2] = node.keys[j];
            }

            // Move second half of children to new node
            if (!node.isLeaf) {
                for (int j = (m + 1) / 2; j < m; j++) {
                    newNode.children[j - (m + 1) / 2] = node.children[j];
                    if (node.children[j] != null) {
                        node.children[j].parent = newNode;
                    }
                }
            }

            // Update sizes of nodes
            node.size = (m - 1) / 2;
            newNode.size = m - 1 - node.size;

            // Insert new key
            if (i < (m - 1) / 2) {
                insertInNode(node, k);
            } else {
                insertInNode(newNode, k);
            }

            // Update parent node
            if (node.parent == null) {
                Node newParent = new Node(m);
                newParent.children[0] = node;
                node.parent = newParent;
                root = newParent;
            }
            split(node.parent, node.parent.indexOfChild(node), newNode);
        }
    }

    private void split(Node parent, int i, Node node) {
        // Shift keys to make space for new child
        for (int j = parent.size; j > i; j--) {
            parent.children[j + 1] = parent.children[j];
            parent.keys[j] = parent.keys[j - 1];
        }

        // Insert new child and key
        parent.children[i + 1] = node;
        parent.keys[i] = node.keys[0];
        parent.size++;
        node.parent = parent;
    }

    
}