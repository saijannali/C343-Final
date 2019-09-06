package Homework1;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Simulator {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int setInput = s.nextInt();
		s.nextLine();
		String elements = s.nextLine();
		String[] numElements = elements.split(" ");
		makeSets(setInput,numElements);
	}
	
	public static void makeSets (int set, String[] numElements) {
		int[] elements = new int[numElements.length];
		for(int d =0;d<numElements.length;d++) {
			elements[d] = Integer.parseInt(numElements[d]);
		}
		Random rand = new Random();
		//ArrayList<Integer> data = new ArrayList<Integer>(set);
		System.out.println(set);
		for(int i =0; i <set; i++) {
			System.out.println(elements[i]);
			for(int j =0; j <elements[i]; j++) {
				System.out.print(rand.nextInt(2000) + " ");
			}
			System.out.println();
		}
		
	}
	
}
