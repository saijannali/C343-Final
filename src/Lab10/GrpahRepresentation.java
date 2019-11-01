package lab10;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;

class Graph {
	private int totalVertex;
	private LinkedList<LinkedList<Integer>> adjList;
	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();   //4
		adjList = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < totalVertex; i ++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			int idx1 = in.nextInt() - 1;  //2-1=0
			int degree = in.nextInt();//1
			//System.out.println("mark idx1 = " + idx1 + " degree = " + degree);
			for(int j = 0; j < degree; j ++) {
				int idx2 = in.nextInt() - 1; //4-1=3
				tmp.add(idx2);// adds 3
			}	
			adjList.add(tmp);
		}
		in.close();
	}
	
	public void printAdjMatrix() {
		Integer[][] adjMatrix = new Integer[totalVertex][totalVertex];
		System.out.println(adjList);
		adjMatrix[0][0] = (adjList.get(0).get(0));
		System.out.println(Arrays.deepToString(adjMatrix));
		
		//Assign the matrix 0's
		for (int i=0; i<totalVertex;i++) {
			for (int j =0; j < totalVertex; j++) {
				adjMatrix[i][j] = 0;
			}
		}
		// uses index to change 0 to 1
		for (int i=0; i <totalVertex;i++) {
			for (int j=0; j< adjList.get(i).size(); j++) {
				adjMatrix[i][adjList.get(i).get(j)] = 1;
			}
		}
		System.out.println(Arrays.deepToString(adjMatrix));
		
		for(int i =0; i < totalVertex;i++) {
			for (int j =0; j < totalVertex; j++) {
				System.out.print(adjMatrix[i][j]);
				if(j == totalVertex-1) {
					
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		//complete the following
	}
}
//change class name GraphRepresentation to Main() for submission to AIZU
public class GrpahRepresentation {
	
	public static void main(String argv[]) {
		Graph g = new Graph();
		g.loadAdjList();
		g.printAdjMatrix();
	}
}
