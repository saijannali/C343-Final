package Lab9;

import java.util.*;

public class LongestCommonSequence{
	public static int Length(String[] a, String[] b) {
		int table[][] = new int [a.length+1][b.length+1];
		
		for (int i=0; i < a.length+1;i++) {
			for (int j=0; j<b.length+1; j++) {
				if (i==0 || j==0) {
					table[i][j] =0;
					
				}
				else if(a[i-1].equals(b[j-1])) {
					table[i][j] = table[i-1][j-1]+1;
				}
				else {
					table[i][j] = maxNum(table[i-1][j], table[i][j-1]);
				}
			}
		}
	
		return table[a.length][b.length];
	}
	
	public static int maxNum(int a, int b) {
		if (a>b) return a;
		else return b;
	}
	public static int minNum(int a, int b) {
		if(a<b) return b;
		else return a;
	}
	
	public static void main(String[] args) {
		// storing input as arrays
		Scanner s = new Scanner(System.in);
		int numSets = Integer.parseInt(s.nextLine());
		int answer[] = new int[numSets];
		for(int i=0; i < numSets;i++) {
			String[] a = s.nextLine().split("");
			String[] b = s.nextLine().split("");
			answer[i] = Length(a,b);
		}
		for (int j =0; j<numSets; j++) {
			System.out.println(answer[j]);
		}
	}
}

}
