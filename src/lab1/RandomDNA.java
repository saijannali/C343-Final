package lab1;
import java.util.Random;
import java.util.Scanner;


public class RandomDNA {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int a = in.nextInt();
	String s = "";
	int t = 0;
	Random rnd = new Random();
	for (int i =0; i <a;i++) {
		t = rnd.nextInt(4);
		if (t == 0) {
			s += "A";
		}
		if (t == 1) {
			s += "T";
		}
		if (t == 2) {
			s += "C";
		}
		if (t == 3) {
			s += "G";
		}
	}
	System.out.print(s);
	
	}
}
