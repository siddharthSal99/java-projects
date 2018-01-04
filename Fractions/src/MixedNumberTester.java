
public class MixedNumberTester {

	public static void main(String[] args) {
		Fraction testFrac = new Fraction(-33, 10);
		MixedNumber mixed1 = new MixedNumber(5,3,4);
		MixedNumber mixed2 = new MixedNumber(testFrac);
		MixedNumber mixed3 = new MixedNumber(1,-1,2);
		MixedNumber mixed4 = new MixedNumber(4,1,-4);
		MixedNumber mixed5 = new MixedNumber(7,5);
		MixedNumber mixed6 = new MixedNumber(-2,3);
		MixedNumber mixed7 = new MixedNumber(-6,5);
		MixedNumber mixed8 = new MixedNumber(7,-10);
		MixedNumber mixed9 = new MixedNumber(-10);
		MixedNumber mixed10 = new MixedNumber();

		// testing the add() method
		
		System.out.println("the sum of 5_3/4 and -3_3/10 is " + mixed1.add(mixed2));
		System.out.println("the sum of 5_3/4 and 1_-1/2 is " + mixed1.add(mixed3));
		System.out.println("the sum of 5_3/4 and 4_1/-4 is " + mixed1.add(mixed4));
		System.out.println("the sum of 5_3/4 and 7/5 is " + mixed1.add(mixed5));
		System.out.println("the sum of 5_3/4 and --2/3 is " + mixed1.add(mixed6));
		System.out.println("the sum of 5_3/4 and -6/5 is " + mixed1.add(mixed7));
		System.out.println("the sum of 5_3/4 and 7/-10 is " + mixed1.add(mixed8));
		System.out.println("the sum of 5_3/4 and -10 is " + mixed1.add(mixed9));
		System.out.println("the sum of 5_3/4 and 0 is " + mixed1.add(mixed10));
		System.out.println("the sum of -3_3/10 and 1_-1/2 is " + mixed2.add(mixed3));
		System.out.println("the sum of -3_3/10 and 4_1/-4 is " + mixed2.add(mixed4));
		System.out.println("the sum of -3_3/10 and 7/5 is " + mixed2.add(mixed5));
		System.out.println("the sum of -3_3/10 and -2/3 is " + mixed2.add(mixed6));
		System.out.println("the sum of -3_3/10 and -6/5 is " + mixed2.add(mixed7));
		System.out.println("the sum of -3_3/10 and 7/-10 is " + mixed2.add(mixed8));
		System.out.println("the sum of -3_3/10 and -10 is " + mixed2.add(mixed9));
		System.out.println("the sum of -3_3/10 and 0 is " + mixed2.add(mixed10));
		System.out.println();

		// testing the subtract() method
		System.out.println("the difference of 5_3/4 and -3_3/10 is " + mixed1.subtract(mixed2));
		System.out.println("the difference of 5_3/4 and 1_-1/2 is " + mixed1.subtract(mixed3));
		System.out.println("the difference of 5_3/4 and 4_1/-4 is " + mixed1.subtract(mixed4));
		System.out.println("the difference of 5_3/4 and 7/5 is " + mixed1.subtract(mixed5));
		System.out.println("the difference of 5_3/4 and -2/3 is " + mixed1.subtract(mixed6));
		System.out.println("the difference of 5_3/4 and -6/5 is " + mixed1.subtract(mixed7));
		System.out.println("the difference of 5_3/4 and 7/-10 is " + mixed1.subtract(mixed8));
		System.out.println("the difference of 5_3/4 and -10 is " + mixed1.subtract(mixed9));
		System.out.println("the difference of 5_3/4 and 0 is " + mixed1.subtract(mixed10));
		System.out.println("the difference of -3_3/10 and 1_-1/2 is " + mixed2.subtract(mixed3));
		System.out.println("the difference of -3_3/10 and 4_1/-4 is " + mixed2.subtract(mixed4));
		System.out.println("the difference of -3_3/10 and 7/5 is " + mixed2.subtract(mixed5));
		System.out.println("the difference of -3_3/10 and -2/3 is " + mixed2.subtract(mixed6));
		System.out.println("the difference of -3_3/10 and -6/5 is " + mixed2.subtract(mixed7));
		System.out.println("the difference of -3_3/10 and 7/-10 is " + mixed2.subtract(mixed8));
		System.out.println("the difference of -3_3/10 and -10 is " + mixed2.subtract(mixed9));
		System.out.println("the difference of -3_3/10 and 0 is " + mixed2.subtract(mixed10));
		System.out.println();

		// testing the multiply() method
		System.out.println("the product of 5_3/4 and -3_3/10 is " + mixed1.multiply(mixed2));
		System.out.println("the product of 5_3/4 and 1_-1/2 is " + mixed1.multiply(mixed3) );
		System.out.println("the product of 5_3/4 and 4_1/-4 is " + mixed1.multiply(mixed4));
		System.out.println("the product of 5_3/4 and 7/5 is " + mixed1.multiply(mixed5));
		System.out.println("the product of 5_3/4 and -2/3 is " + mixed1.multiply(mixed6));
		System.out.println("the product of 5_3/4 and -6/5 is " + mixed1.multiply(mixed7));
		System.out.println("the product of 5_3/4 and 7/-10 is " + mixed1.multiply(mixed8));
		System.out.println("the product of 5_3/4 and -10 is " + mixed1.multiply(mixed9));
		System.out.println("the product of 5_3/4 and 0 is " + mixed1.multiply(mixed10));
		System.out.println("the product of -3_3/10 and 1_-1/2 is " + mixed2.multiply(mixed3));
		System.out.println("the product of -3_3/10 and 4_1/-4 is " + mixed2.multiply(mixed4));
		System.out.println("the product of -3_3/10 and 7/5 is " + mixed2.multiply(mixed5));
		System.out.println("the product of -3_3/10 and -2/3 is " + mixed2.multiply(mixed6));
		System.out.println("the product of -3_3/10 and -6/5 is " + mixed2.multiply(mixed7));
		System.out.println("the product of -3_3/10 and 7/-10 is " + mixed2.multiply(mixed8));
		System.out.println("the product of -3_3/10 and -10 is " + mixed2.multiply(mixed9));
		System.out.println("the product of -3_3/10 and 0 is " + mixed2.multiply(mixed10));
		System.out.println();

		// testing the divide() method
		System.out.println("the quotient of 5_3/4 and -3_3/10 is " + mixed1.divide(mixed2));
		System.out.println("the quotient of 5_3/4 and 1_-1/2 is " + mixed1.divide(mixed3));
		System.out.println("the quotient of 5_3/4 and 4_1/-4 is " + mixed1.divide(mixed4));
		System.out.println("the quotient of 5_3/4 and 7/5 is " + mixed1.divide(mixed5));
		System.out.println("the quotient of 5_3/4 and -2/3 is " + mixed1.divide(mixed6));
		System.out.println("the quotient of 5_3/4 and -6/5 is " + mixed1.divide(mixed7));
		System.out.println("the quotient of 5_3/4 and 7/-10 is " + mixed1.divide(mixed8));
		System.out.println("the quotient of 5_3/4 and -10 is " + mixed1.divide(mixed9));
		System.out.println("the quotient of 5_3/4 and 0 is " + mixed1.divide(mixed10));
		System.out.println("the quotient of -3_3/10 and 1_-1/2 is " + mixed2.divide(mixed3));
		System.out.println("the quotient of -3_3/10 and 4_1/-4 is " + mixed2.divide(mixed4));
		System.out.println("the quotient of -3_3/10 and 7/5 is " + mixed2.divide(mixed5));
		System.out.println("the quotient of -3_3/10 and -2/3 is " + mixed2.divide(mixed6));
		System.out.println("the quotient of -3_3/10 and -6/5 is " + mixed2.divide(mixed7));
		System.out.println("the quotient of -3_3/10 and 7/-10 is " + mixed2.divide(mixed8));
		System.out.println("the quotient of -3_3/10 and -10 is " + mixed2.divide(mixed9));
		System.out.println("the quotient of -3_3/10 and 0 is " + mixed2.divide(mixed10));
		System.out.println();
		
		// testing the toDecimal() method
		System.out.println(mixed1.toDecimal());
		System.out.println(mixed2.toDecimal());
		System.out.println(mixed3.toDecimal());
		System.out.println(mixed4.toDecimal());
		System.out.println(mixed5.toDecimal());
		System.out.println(mixed6.toDecimal());
		System.out.println(mixed7.toDecimal());
		System.out.println(mixed8.toDecimal());
		System.out.println(mixed9.toDecimal());
		System.out.println(mixed10.toDecimal());
		System.out.println();
		
		// testing the reciprocal() method
		System.out.println(mixed1.reciprocal());
		System.out.println(mixed2.reciprocal());
		System.out.println(mixed3.reciprocal());
		System.out.println(mixed4.reciprocal());
		System.out.println(mixed5.reciprocal());
		System.out.println(mixed6.reciprocal());
		System.out.println(mixed7.reciprocal());
		System.out.println(mixed8.reciprocal());
		System.out.println(mixed9.reciprocal());
		System.out.println(mixed10.reciprocal());
		System.out.println();
		


	}

}
