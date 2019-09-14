package Lab03;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class RoundRobing {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String[] firstLine = input.split(" ");
		int numElements = Integer.parseInt(firstLine[0]);
		int maxProcess = Integer.parseInt(firstLine[1]);
		
		// adding the elements to two queue's
		Queue<Integer> q = new LinkedList<>();
		Queue<String> p = new LinkedList<>();
		for (int i=0; i < numElements; i++) {
			String tempInput = s.nextLine();
			String[] currentLine = tempInput.split(" ");
			String currentP = currentLine[0];
			int currentValue = Integer.parseInt(currentLine[1]);
			p.add(currentP);
			q.add(currentValue);
		}
		System.out.println(q);
		System.out.println(p);
		
		int ts = 0;
		while(p.size() > 0) {
			// value is more than maxProcess
			if ((maxProcess - q.peek()) < 0) {
				ts = ts + maxProcess;
				q.add(q.remove()-maxProcess);
				p.add(p.remove());
			}
			//if value is smaller than maxProcess
			else{
				ts = ts + q.remove();
				System.out.println(p.remove() + " " + ts);
				
			}
		}
		
	}
}
