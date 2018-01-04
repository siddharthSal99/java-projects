import java.util.Scanner;

/*
 * This class contains utility methods relating to prime numbers.
 */
public class PrimeNumbers {

	/*
	 * 
	 */
	public static boolean isPrime(int n){
		if(n < 2) return false;
		for(int factor = 2; factor < Math.sqrt(n); factor++){
			if(n % factor == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a number to see if it is prime: ");
		int value = in.nextInt();
		
		System.out.println(PrimeNumbers.isPrime(value));
	}
}

