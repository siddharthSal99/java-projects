import java.util.Scanner;

/*
 * This class contains utility methods relating to prime numbers.
 */
public class TestPrograms {

	/*
	 * 
	 */
	public static boolean isPrime(int n){
		if(n < 0) n = -n;
		if(n < 2) return false;
		for(int factor = 2; factor < n; factor++){
			if(n % factor == 0)
				return false;
		}
		return true;
	}
	
	/*
	 * 
	 */
	public static void primeFactorization(int toFactor){
		int factor = 2;
		while(toFactor > 1){
			if(toFactor % factor == 0){
				toFactor /= factor;
				System.out.println(factor);
			}
			else{
				factor++;
			}
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int value;
		System.out.print("Enter a number to see if it is prime: ");
		value = in.nextInt();
		
		System.out.println(TestPrograms.isPrime(value));
		
		
		System.out.print("Enter a positive integer to find the prime factorization: ");
		value = in.nextInt();
		TestPrograms.primeFactorization(value);
		
		
		
		System.out.println("please enter a number to factorialize");
		long a = in.nextLong();
		long b = a;
		int i = 1;
		long c = 1;
		while ( i <= b){
			c = c * i;
			
			i++;
		}
		System.out.println(c);
		System.out.println(1.2 % 1);
		
		
		
	}
}



