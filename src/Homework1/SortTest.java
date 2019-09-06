package Homework1;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class SortTest {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\vvsai\\Desktop\\Eclipse\\C343sjannali\\src\\Homework1\\output.txt");
		Scanner r = new Scanner(file);
		int setNum = Integer.parseInt(r.nextLine());
		while(r.hasNextLine()) {
			for (int i =0; i < setNum; i ++) {
				int numElement = Integer.parseInt(r.nextLine());
				String[] temp = r.nextLine().split(" ");
				int[] intSet = new int[temp.length];
				for (int j =0; j < intSet.length; j++) {
					intSet[j] = Integer.parseInt(temp[j]);
				}
				long startTime = System.currentTimeMillis();
				SelectionSort(numElement, intSet);
				long endTime = System.currentTimeMillis();
				System.out.print(numElement + " " + (endTime - startTime));
				System.out.println();
			}
		}	
	}
	public static void SelectionSort(int numElement,int arr[]) {
		int n = arr.length; 
		  
        for (int i = 0; i < n-1; i++) 
        { 
            int min = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min]) 
                    min = j; 
            int temp = arr[min]; 
            arr[min] = arr[i]; 
            arr[i] = temp; 
        } 
  
	}
}
