package Lab9;

import java.util.*;
import java.lang.Comparable;
import java.util.Collections;
public class GreedyActivity{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numActivities = Integer.parseInt(s.nextLine());
		PriorityQueue<Activities> q = new PriorityQueue<Activities>();
		//ArrayList<Activities> a = new ArrayList<Activities>();
		for (int i=0; i < numActivities; i++) {
			q.add(new Activities(s.next(),Double.parseDouble(s.next()),Double.parseDouble(s.next())));
		}
		Activities sc = null;
		while (!q.isEmpty()) {
			Activities current = q.poll();
			if (sc ==null) {
				System.out.println(current);
				sc=current;
			}
			else if(sc.finish < current.start) {
				System.out.println(current);
				sc=current;
			}
		}
	
	}
	
}
class Activities implements Comparable<Activities>{
	
	public String name;
	public double start;
	public double finish;
	
	public int compareTo(Activities other) {
		if(this.finish > other.finish) {return 1;}
		else if(this.finish < other.finish ) {return -1;}
		else return 0;
	}
	public Activities(String name, double start, double finish) {
		this.name = name;
		this.start = start;
		this.finish = finish;
	}
	public String toString() {
		return this.name + " " + this.start + " " + this.finish;
	}
}