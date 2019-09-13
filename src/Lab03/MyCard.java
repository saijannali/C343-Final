package Card;
import java.util.Random;
import java.util.Arrays;
public class MyCard implements Card {
	
	public String[] initialize() {
		String deck[] = new String[52];
		int count =0;
		for (int i=0; i < 4; i++) {
			for(int j=1; j<14;j++) {
				if (i== 0) {
					deck[count] = ""+j+"S";
					//count = count +1;
				}
				else if (i==1) {
					deck[count] = ""+j+"C";
					//count = count + 1;
				}
				else if (i==2) {
					deck[count] = ""+j+"H";
					//count = count + 1;
				}
				else if(i==3)
					deck[count] = ""+j+"D";
					//count = count + 1;
				count = count +1;
			}
		
		}
		
		System.out.println(Arrays.toString(deck));
		return deck;
	}

	public String drawCard(String deck[]) {
		System.out.println("First Index:" + deck[0]);
		Random rand = new Random();
		int randomIndex = rand.nextInt(52);
		return deck[randomIndex];
	}
	
	public static void main(String[] args) {
		MyCard myDeck = new MyCard();
		String[] newDeck = myDeck.initialize();
		System.out.println(myDeck.drawCard(newDeck)); 
	}
}
