/* 
*  Author: Zain Malik 
*  Course: COP3503 
*  Project #: 1 
*  Title  : Number Statistics 
*  Due Date:  10/07/2022
*  
*  Performs Statistical Operations
*/ 
import java.util.Arrays;
import java.util.Scanner; 

/** 
 * Performs Statistical Operations.
 */ 
public class Project1_N01486327{
	
	/** 
	   * Enters number list by user keyboard input.
	* @return The list of numbers in an integer array
	*/ 
	static int[] createList() {
		//input list of integers
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter List of Integers Seperated by Spaces: "); 
		String input = "";
		input = scnr.nextLine();
		
		//String concatenation
		String[] str_array = input.split(" ");
		int[] array = new int[str_array.length];  
		for(int i = 0; i < str_array.length; i++)  {  
		//parse string into int[] array 
			array[i] = Integer.parseInt(str_array[i]);
			}  
		return array;
	}//end method
	
	/** 
	   * Calculates the number statistics operations (i.e. Minimum, Maximum, Count, Etc.)
	* @param array The integer array where data is pulled from.
	* @return Displays the final calculated values.
	*/ 
	static void listStatistics(int[] array) {
		//calculate minimum
		Arrays.sort(array);
		int min = array[0];
		//print minimum value
		System.out.println("Min: " + min);
		
		//calculate maximum
		int i;
		int max = array[0];
		for (i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
		//print maximum value
	   System.out.println("Max: " + max);

	   //calculate count of numbers in array list
	   int count = array.length;
	   //print count of numbers in array list
	   System.out.println("Count: " + count);
	   
	   //calculate range
	   int range = (max - min);
	   //print range value
	   System.out.println("Range: " + range);
	   
	   //calculate median
	   Arrays.sort(array);
	   double median;
	   if (array.length % 2 == 0)
	       median = ((double)array[array.length/2] + (double)array[array.length/2 - 1])/2;
	   else
	       median = (double) array[array.length/2];
	   //print median value 
	   System.out.println("Median: " + median);
	   
	   //calculate mean
	   int sum = 0;
	   for (i = 0; i < array.length; i++)
           sum += array[i];
	   double mean = sum / count;
	   //print mean value
	   System.out.println("Mean: " + mean);
	   
	   //calculate mode
	   int modeElement = 0;
	   int modeCount = 0;
	   int mode = 0;
	   for(int j = 0; j < array.length; j++) {
	       int tempElement = array[j];
		   int tempCount = -1;
		   for(int p = 0; p < array.length; ++p) {
			   if(array[p]==tempElement) {
				   ++tempCount;
			   }
		   }
	   if(tempCount>modeCount) {
			   modeElement = tempElement;
			   modeCount = tempCount; 
			   mode = modeElement;
	     }
	   }
	   //print mode value
	   if(mode != 0) {
	   System.out.println("Mode: " + modeElement);
	   }else {
		   System.out.println("Mode: No Mode");
	   }
	   
	   //calculate variance
	   double sqDiff = 0;
       for (int l = 0; l < array.length; l++)
           sqDiff += (array[l] - mean) *
                     (array[l] - mean);
       double variance = (double)sqDiff / array.length;
       //print variance
       System.out.print("Variance: ");
       System.out.printf("%.2f", variance);
       System.out.println();
       
       //calculate standard deviation
       double deviation = Math.sqrt(variance);
       //print standard deviation
       System.out.print("Standard Deviation: ");
       System.out.printf("%.2f", deviation);
       System.out.println();
	}// end method
	
	/** 
	   * Sorts the integer array list.
	* @param array The integer array where data is pulled from.
	* @return The sorted array list.
	*/ 
	static void sortArray(int[] array) {
		//sort array
		 Arrays.sort(array);
		 //print sorted array list
		 for(int num : array) {
			 System.out.print(num + " ");
		 }
	}// end method
	
	/** 
	   * Calculates the number of odd and even numbers in array list.
	* @param array The integer array where data is pulled from.
	* @return The number of odd and even numbers.
	*/ 
	static void evenOdd(int[] array) {
		//declare variables
		int even = 0;
		int odd = 0;
		
		//calculate number of odd and even numbers
		for(int i = 0; i < array.length; i++) {
			if((array[i] & 1) == 1) {
				odd++;
			}  else {
				even++;
			}
		 }//end loop
		
		//print number off odd and even numbers
		System.out.println("Number of even: " + even);
		System.out.println("Number of odd: " + odd);
	}// end method
	
	/** 
	   * Calculates the number prime numbers in array list.
	* @param array The integer array where data is pulled from.
	* @return The number of prime numbers
	*/ 
	static int primeNumbers(int[] array) {
		//declare variables
		int n = array.length;
        int max_val = Arrays.stream(array).max().getAsInt();
        
        //find all prime numbers >= max_val
        //create boolean: default values in prime[i] are false
        //if i not prime, prime[i] = true
        Boolean[] prime = new Boolean[max_val + 1];
        for (int i = 0; i < max_val + 1; i++)
        {
            prime[i] = true;
        }
 
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= max_val; p++)
        {
            // If prime[p] did not change, it is prime
            if (prime[p] == true)
            {
                //update all multiples of p
                for (int i = p * 2; i <= max_val; i += p)
                {
                    prime[i] = false;
                }
            }
        }
        // Find all primes in array[]
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (prime[array[i]])
            {
                count++;
            }
        }
 
        return count;
	}// end method
	
	/** 
	   * Quits program.  
	* @return Statement stating the program has terminated.
	*/ 
	static void quitMethod() {
		//print statement stating program terminated
		System.out.println("Program Terminated");
		
		//terminate program
		System.exit(0);
		  }// end method
	 
	public static void main(String[] args) {
		//scanner
		Scanner scnr = new Scanner(System.in);
		int[] array = createList();
		
		//choose a selection
		System.out.println("These are your choices: "); 
		System.out.println("1: Display List Statistics");
        System.out.println("2: Display List Ordered");
        System.out.println("3: Number of Odd/Even");
        System.out.println("4: Check for Prime Numbers");
        System.out.println("5: Enter New List");
        System.out.println("6: Quit");
        System.out.print("Please make a selection: ");
        //switch-case for menu
        String choice = scnr.next();
		do {
			switch (choice){
			    case "1":
			    	//Display List Statistics
			    	listStatistics(array);
			        break;
			    case "2":
			    	//Display List Ordered
			    	System.out.print("[");
			    	sortArray(array);
			    	System.out.println("]");
			        break;
			    case "3":
			    	evenOdd(array);
			        break;
			    case "4":
			    	//Number of Odd/Even
			    	System.out.println("Number of prime in list: "+primeNumbers(array));
			        break;
			    case "5":
			    	//Enter New List
			    	array = createList();
			        break;
			    case "6":
			    	//quit program
			    	quitMethod();
			    	
			    case "?":
			            System.out.println("1: Display List Statistics");
			            System.out.println("2: Display List Ordered");
			            System.out.println("3: Number of Odd/Even");
			            System.out.println("4: Check for Prime Numbers");
			            System.out.println("5: Enter New List");
			            System.out.println("6: Quit");
			            break;
			        }  
			System.out.println("These are your choices: "); 
			System.out.println("1: Display List Statistics");
	        System.out.println("2: Display List Ordered");
	        System.out.println("3: Number of Odd/Even");
	        System.out.println("4: Check for Prime Numbers");
	        System.out.println("5: Enter New List");
	        System.out.println("6: Quit");
	        System.out.print("Please make a selection: ");
	        choice = scnr.next();
		}while (choice != "6");
	}// end main method


}// end class