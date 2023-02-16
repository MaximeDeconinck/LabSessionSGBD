package Session2;

import Session2.Node;
import java.util.Arrays;
import java.util.List;
import Session2.Btree;

public class Main {
	
	public static void main(String[] args) {
		
		Btree tree = new Btree(5);
		List<Integer> list = Arrays.asList(10, 15, 30, 27, 35, 40, 45, 37, 20, 50, 55, 46, 71, 66, 74, 85, 90, 79, 78, 95, 25, 81, 68, 60, 65);
		
		/*
		for (Integer i : list) {
			tree.insert(i);
		}
		*/
		
		System.out.println(tree.search(1));
	}

}
