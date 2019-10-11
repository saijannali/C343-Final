package Lab07;
import java.util.Collections;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		PriorityQueue<Pokemon> q = new PriorityQueue<Pokemon>();
		q.add(new Pokemon("a",500));
		q.add(new Pokemon("b",300));
		q.add(new Pokemon("c",100));
		q.add(new Pokemon("d",400));
		q.add(new Pokemon("e",200));
		
		//print elements
		System.out.println("q elements:");
		Iterator i = q.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("Removing");
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		
		
	}
}
