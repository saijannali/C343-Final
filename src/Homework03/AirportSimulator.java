package Homework03;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

//Homework3

public class AirportSimulator {
	public static int randRequest() {
		Random rand = new Random();
		int request = rand.nextInt(2) + 1;
		return request;
	}

	public static void main(String[] args) {
		Queue<Integer> takeoffs = new LinkedList<>();
		Queue<Integer> landings = new LinkedList<>();
		
		
		
		int clock = 0;
		int numLandings =0;
		int numTakeoffs =0;
		int sumTimeTO = 0;
		int sumTimeLA =0;
		while (clock < 120) {
			//requests 
			for (int i=0; i < 120; i = i + 5) {
				int currRequest = randRequest();
				
				if (currRequest == 1) { // takeoffs
					takeoffs.add(clock);
					System.out.println("TakeOff request:" + clock + "min");
					
				}
				else{ 					// landings
					landings.add(clock);
					System.out.println("Landing request:" + clock + "min");
				}
				clock = clock + 5;
				if (i % 15 == 0 && (takeoffs.size() + landings.size() > 0)) {
						if(landings.size() != 0) {
							sumTimeLA += clock - landings.remove();
							numLandings += 1;
							
						}
						if(landings.size() != 0) {
							sumTimeLA += clock - landings.remove();
							numLandings +=1;
						}
						if (takeoffs.size() != 0){
							sumTimeTO += clock - takeoffs.remove();
							numTakeoffs +=1;
						}
						if (takeoffs.size() != 0){
							sumTimeTO += clock - takeoffs.remove();
							numTakeoffs +=1;
						}
				}
			}
		}
		
		System.out.println("Num of TakeOffs: " + numTakeoffs);
		System.out.println("Num of Landings: " + numLandings);
		
	
		System.out.println("Average number of time spent in Landing queue: " + (sumTimeLA/numLandings) + " min");
		System.out.println("Average number of time spent in TakeOff queue: " + (sumTimeTO/numTakeoffs)+ " min");

	}

}
