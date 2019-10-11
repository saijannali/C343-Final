package Lab07;
import java.lang.Comparable;

public class Pokemon implements Comparable<Pokemon> {
	
	public String name;
	public int power;
	
	public Pokemon(String name, int power) {
		this.name = name;
		this.power = power;
	}
	public int compareTo (Pokemon other) {
		if (this.power > other.power) {return 1;}
		else if(this.power < other.power) {return -1;}
		else return 0;
	}
	
	public String toString() {
		return this.name + ":" + this.power;
	}
}

