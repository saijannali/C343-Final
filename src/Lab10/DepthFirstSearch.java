package lab10;

//template code, C343, 2019
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

class Graph {
	private int totalVertex;
	private LinkedList<LinkedList<Integer>> adjList;
	int[] discover = new int[totalVertex];
	int[] finish = new int[totalVertex];
	int[] visited = new int[totalVertex];
	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		numNode(totalVertex);
		visited = new int[totalVertex];
		discover = new int[totalVertex];
		finish = new int[totalVertex];
		adjList = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < totalVertex; i ++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			int idx1 = in.nextInt() - 1;
			int degree = in.nextInt();
			//System.out.println("mark idx1 = " + idx1 + " degree = " + degree);
			for(int j = 0; j < degree; j ++) {
				int idx2 = in.nextInt() - 1;
				tmp.add(idx2);
			}	
			adjList.add(tmp);
		}
		in.close();
	}
    int numNode(int totalVertex) {
    	return totalVertex;
    }

	void printAdjMatrix() {
		Integer[][] adjMatrix = new Integer[totalVertex][totalVertex];
		System.out.println(adjList);
		
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
	}

	int time = 1;
	
	void DFS(int current) {
		LinkedList<Integer> neighbors =adjList.get(current);
		System.out.println("current Node:" + current);
		
		discover[current-1] = time;
		time++;
		visited[current-1] = 1;
		
		for(int it : neighbors) {
			if (visited[it] != 1)
				DFS(it);
		}
		finish[current-1] = time;
		time++;
	}
	
	void mainDFS() {
		for (int i=0; i < totalVertex; i++) {
			if (visited[i] != 1) {
				DFS(i+1);
			}
		}
	}
	void printDFS() {
		for (int i = 0; i <= totalVertex; i++) {
            System.out.println("Node " + i + " discover "
                               + discover[i] + "finish " + finish[i]); 
		} 
	}

}


//change class name GraphRepresentation to Main() for submission to AIZU
public class DepthFirstSearch {
	public static void main(String argv[]) {
		Graph g = new Graph();
		g.loadAdjList();
		g.printAdjMatrix();
		g.mainDFS();
		g.printDFS();
		
	}
}
