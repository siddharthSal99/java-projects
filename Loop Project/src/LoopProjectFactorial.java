/*
 * This class finds the factorial of an input value. Using the BigInteger class, this class can calculate very large factorial numbers. Since a factorialized number cannot be negative, 
 * all negative numbers are treated as positive. The program will continue to ask you if you would like to enter another number to factorialize, and will terminate after the user 
 * tells the program not to accept any more factorials.
 */
import java.math.BigInteger;
import java.util.Scanner;

public class LoopProjectFactorial {

	/* 
	 * This method prompts the user for a long integer to factorialize. If the input number is negative, it changes the number to its positive counterpart.
	 * it calls the compute factorial method to calculate the factorial, and then prints it. The condition of the while loop is the return value of the anotherFactorial() method.
	 * As long as it is true, the method will repeat and ask for another number to factorialize.
	 * 
	 * parameters: none
	 * returns: none
	 * output: prints the factorial of the input long integer.
	 */

	public static void factorial(){
		Scanner input = new Scanner(System.in);
		do{

			System.out.println("Please enter a non-negative integer to factorialize");
			System.out.println("all negative integers will be treated as their positive counterparts");
			long value = input.nextLong();	

			if (value < 0)
				System.out.println( LoopProjectFactorial.computeFactorial(-value));

			else 
				System.out.println(LoopProjectFactorial.computeFactorial(value));

		}
		while(anotherFactorial());
		input.close();
	}

/*
 * This method calculates the factorial of an input long integer. Using the BigInteger class, it calculates and returns the value of the factorial.
 * 
 * parameters: long value, prompted in the factorial() method.
 * returns: BigInteger factorial result.
 */
	private static BigInteger computeFactorial(long value){
		BigInteger bigValue = new BigInteger("" + value);
		BigInteger result = new BigInteger("1");
		int i = 1;
		if (value == 0)
			return BigInteger.ONE;
		else{
			while (i < value){
				result = new BigInteger( "" + bigValue.multiply(result));
				bigValue = new BigInteger("" + bigValue.subtract(BigInteger.ONE));
				i++;
			}
			return result;
		}
	}
/*
 * This method prompts the user if they would like to enter another factorial. This is used as a condition for the while loop in the factorial() method to repeat the loop.
 * 
 *  parameters: none
 *  returns: boolean, if the user would like to enter another factorial, then the method returns true.
 */
	private static boolean anotherFactorial(){
		Scanner input = new Scanner(System.in);
		String answer;
		while (true){
			System.out.println("would you like to find another factorial? \n please enter y or n" );
			answer = input.nextLine();
			if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")){
				break;
			}
			else{
				System.out.println("invalid response, please enter y or n");
			}
			input.close();
		}
		if (answer.equalsIgnoreCase("y")){
			return true;
		}
		else
			return false;
	}

	public static void main (String [] args){
		LoopProjectFactorial.factorial();

	}
}
