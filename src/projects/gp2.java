import java.util.Scanner;

public class GroupProjectData {
	
	// Takes in a single line of strings separated by the / character and runs the first four each against all of the strings
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		String[] strArray = s.next().split("/");
				
		for (int i = 0; i < 5; i++) {
			
			String s1 = strArray[i];
			System.out.println("Trials: s" + i);
			
			for (int j = 0; j < strArray.length; j++) {
			
				String s2 = strArray[j];
			
				if (s1.equals(s2)) { continue; }
			
				int deltaLen = Math.abs(s1.length() - s2.length());
				int ed = med(s1, s2);
			
				System.out.print("s" + i + " & s" + j + ": ");
				System.out.print(deltaLen);
				System.out.print(" " + lcs(s1, s2));
				System.out.print(" " + ed);
				System.out.println(" " + (ed - deltaLen));
						
			}
		}
		
		
		s.close();
	}
	
	//Longest Common Substring Function
	public static int lcs(String s1, String s2) {	
		int rows = s1.length() +  1;
		int cols = s2.length() + 1;
		int max = 0;
		//int[] maxSpot = new int[2];
		int[][] t = new int[rows][cols];
		
		for (int r = 1; r < rows; r++) {
			for (int c = 1; c < cols; c++) {
				t[r][c] = max(t[r-1][c], t[r][c-1]);
				char a = s1.charAt(r - 1);
				char b = s2.charAt(c - 1);
				
				if (Character.compare(a, b) == 0) { t[r][c] = t[r - 1][c - 1] + 1; }			
				
				//max = max(max, t[r][c]);
			} 
		}
	
		return t[rows - 1][cols - 1];	
	
	}
	
	// Minimum Edit Distance Function
	public static int med(String s1, String s2) {
		
		int rows = s1.length() + 1;
		int cols = s2.length() + 1;

		int[][] t = new int[rows][cols];
		
		for (int i = 1; i < cols; i++) { t[0][i] = i; }
		for (int i = 1; i < rows; i++) { t[i][0] = i; }
		
		for (int r = 1; r < rows; r++) {
			
			for (int c = 1; c < cols; c++) {
				
				if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
					t[r][c] = t[r-1][c-1];					
				} else {
					t[r][c] = compareSpots(t, r, c);
				}
				
			}
			
			
			
		}
		
		return t[rows - 1][cols - 1];
	
	}	
	
	// helper function for finding max and min
	public static int max(int a, int b) { return (a >= b) ? a : b;	}
	
	public static int min(int a, int b) { return (a <= b) ? a : b; }
	
	public static int min(int a, int b, int c) { return min(min(a, b), c); }
	
	// compares spots for edit distance
	public static int compareSpots(int[][] t, int r, int c) {
		
		int x = t[r - 1][c - 1];
		int y = t[r][c - 1];
		int z = t[r - 1][c];
		return min(x, y, z) + 1;
	
	}	
}
