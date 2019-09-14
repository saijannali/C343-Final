package Lab03;
import java.util.Scanner;
import java.util.Stack;

public class ReversePolish {
	  public static void main(String[] arg) {
	        Scanner s = new Scanner(System.in);
	        String input = s.nextLine();
	        String[] array = input.split(" ");
	        int first, second = 0;
	        int answer = 0;
	        Stack<Integer> stack = new Stack<Integer>();
	      
	        for(int i = 0; i < array.length; i++) {
	            try {
	                stack.push(Integer.parseInt(array[i]));
	            }
	            catch(Exception e){
	                if(array[i].equals("*")) {
	                	 first = stack.pop();
		                 second = stack.pop();
		                 answer = stack.push(first * second);		                 	                    
	                }
	                else if(array[i].equals("-")) {
	                    second = stack.pop();
	                    first = stack.pop();
	                    answer = stack.push(first - second);

	                }
	                else if(array[i].equals("+")) {
	                    first = stack.pop();
	                    second = stack.pop();
	                    answer = stack.push(first + second);

	                }
	            }
	           
	        }
	        System.out.println(answer);
	        s.close();
	    }

}
