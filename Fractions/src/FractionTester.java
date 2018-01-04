
public class FractionTester {

	public static void main(String[] args) {

		Fraction frac1 = new Fraction(4,5);
		Fraction frac2 = new Fraction(-4,3);
		Fraction frac3 = new Fraction(9,-16);
		Fraction frac4 = new Fraction(-12,-17);
		Fraction frac5 = new Fraction(5);
		Fraction frac6 = new Fraction();
		
		// testing the add() method
	
		System.out.println("the sum of 4/5 and -4/3 is "+ frac1.add(frac2));
		System.out.println("the sum of 4/5 and 9/-16 is "+ frac1.add(frac3));
		System.out.println("the sum of 4/5 and -12/-17 is "+ frac1.add(frac4));
		System.out.println("the sum of 4/5 and 5 is "+ frac1.add(frac5));
		System.out.println("the sum of 4/5 and 0 is "+ frac1.add(frac6));
		System.out.println("the sum of -4/3 and 9/-16 is "+ frac2.add(frac3));
		System.out.println("the sum of -4/3 and -12/-17 is "+ frac2.add(frac4));
		System.out.println("the sum of -4/3 and 5 is "+ frac2.add(frac5));
		System.out.println("the sum of -4/3 and 0 is "+ frac2.add(frac6));
		System.out.println("the sum of 9/-16 and -12/-17 is "+ frac3.add(frac4));
		System.out.println("the sum of 9/-16 and 5 is "+ frac3.add(frac5));
		System.out.println("the sum of 9/-16 and 0 is "+ frac3.add(frac6));
		System.out.println("the sum of -12/-17 and 5 is "+ frac4.add(frac5));
		System.out.println("the sum of -12/-17 and 0 is "+ frac4.add(frac6));
		System.out.println("the sum of 5 and 0 is "+ frac5.add(frac6));
		System.out.println();
		
		// testing the subtract() method
		
		System.out.println("the difference of 4/5 and -4/3 is "+ frac1.subtract(frac2));
		System.out.println("the difference of 4/5 and 9/-16 is "+ frac1.subtract(frac3));
		System.out.println("the difference of 4/5 and -12/-17 is "+ frac1.subtract(frac4));
		System.out.println("the difference of 4/5 and 5 is "+ frac1.subtract(frac5));
		System.out.println("the difference of 4/5 and 0 is "+ frac1.subtract(frac6));
		System.out.println("the difference of -4/3 and 9/-16 is "+ frac2.subtract(frac3));
		System.out.println("the difference of -4/3 and -12/-17 is "+ frac2.subtract(frac4));
		System.out.println("the difference of -4/3 and 5 is "+ frac2.subtract(frac5));
		System.out.println("the difference of -4/3 and 0 is "+ frac2.subtract(frac6));
		System.out.println("the difference of 9/-16 and -12/-17 is "+ frac3.subtract(frac4));
		System.out.println("the difference of 9/-16 and 5 is "+ frac3.subtract(frac5));
		System.out.println("the difference of 9/-16 and 0 is "+ frac3.subtract(frac6));
		System.out.println("the difference of -12/-17 and 5 is "+ frac4.subtract(frac5));
		System.out.println("the difference of -12/-17 and 0 is "+ frac4.subtract(frac6));
		System.out.println("the difference of 5 and 0 is "+ frac5.subtract(frac6));
		System.out.println();
		
		// testing the multiply() method
		
		System.out.println("the product of 4/5 and -4/3 is "+ frac1.multiply(frac2));
		System.out.println("the product of 4/5 and 9/-16 is "+ frac1.multiply(frac3));
		System.out.println("the product of 4/5 and -12/-17 is "+ frac1.multiply(frac4));
		System.out.println("the product of 4/5 and 5 is "+ frac1.multiply(frac5));
		System.out.println("the product of 4/5 and 0 is "+ frac1.multiply(frac6));
		System.out.println("the product of -4/3 and 9/-16 is "+ frac2.multiply(frac3));
		System.out.println("the product of -4/3 and -12/-17 is "+ frac2.multiply(frac4));
		System.out.println("the product of -4/3 and 5 is "+ frac2.multiply(frac5));
		System.out.println("the product of -4/3 and 0 is "+ frac2.multiply(frac6));
		System.out.println("the product of 9/-16 and -12/-17 is "+ frac3.multiply(frac4));
		System.out.println("the product of 9/-16 and 5 is "+ frac3.multiply(frac5));
		System.out.println("the product of 9/-16 and 0 is "+ frac3.multiply(frac6));
		System.out.println("the product of -12/-17 and 5 is "+ frac4.multiply(frac5));
		System.out.println("the product of -12/-17 and 0 is "+ frac4.multiply(frac6));
		System.out.println("the product of 5 and 0 is "+ frac5.multiply(frac6));
		System.out.println();
		
		// testing the divide() method
		
		System.out.println("the quotient of 4/5 and -4/3 is "+ frac1.divide(frac2));
		System.out.println("the quotient of 4/5 and 9/-16 is "+ frac1.divide(frac3));
		System.out.println("the quotient of 4/5 and -12/-17 is "+ frac1.divide(frac4));
		System.out.println("the quotient of 4/5 and 5 is "+ frac1.divide(frac5));
		System.out.println("the quotient of 4/5 and 0 is "+ frac1.divide(frac6));
		System.out.println("the quotient of -4/3 and 9/-16 is "+ frac2.divide(frac3));
		System.out.println("the quotient of -4/3 and -12/-17 is "+ frac2.divide(frac4));
		System.out.println("the quotient of -4/3 and 5 is "+ frac2.divide(frac5));
		System.out.println("the quotient of -4/3 and 0 is "+ frac2.divide(frac6));
		System.out.println("the quotient of 9/-16 and -12/-17 is "+ frac3.divide(frac4));
		System.out.println("the quotient of 9/-16 and 5 is "+ frac3.divide(frac5));
		System.out.println("the quotient of 9/-16 and 0 is "+ frac3.divide(frac6));
		System.out.println("the quotient of -12/-17 and 5 is "+ frac4.divide(frac5));
		System.out.println("the quotient of -12/-17 and 0 is "+ frac4.divide(frac6));
		System.out.println("the quotient of 5 and 0 is "+ frac5.divide(frac6));
		System.out.println();
		
		// testing the reciprocal() method
		
		System.out.println("the reciprocal of 4/5 is " + frac1.reciprocal() );
		System.out.println("the reciprocal of -4/3 is " + frac2.reciprocal() );
		System.out.println("the reciprocal of 9/-16 is " + frac3.reciprocal() );
		System.out.println("the reciprocal of -12/-17 is " + frac4.reciprocal() );
		System.out.println("the reciprocal of 5 is " + frac5.reciprocal() );
		System.out.println("the reciprocal of 0 is " + frac6.reciprocal() );
		System.out.println();
		
		// testing the toDecimal() method
		
		System.out.println("the decimal equivalent of 4/5 is " + frac1.toDecimal() );
		System.out.println("the decimal equivalent of -4/3 is " + frac2.toDecimal() );
		System.out.println("the decimal equivalent of 9/-16 is " + frac3.toDecimal() );
		System.out.println("the decimal equivalent of -12/-17 is " + frac4.toDecimal() );
		System.out.println("the decimal equivalent of 5 is " + frac5.toDecimal() );
		System.out.println("the decimal equivalent of 0 is " + frac6.toDecimal() );
	
	
	}

}
