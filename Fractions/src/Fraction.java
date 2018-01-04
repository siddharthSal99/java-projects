	/*
	 * Objects of this class represent fractions in the form p/q where p and q are integers
	 * The fraction must be expressed as a ratio of integers, not decimals, and cannot have a 
	 * zero in the denominator.
	 * 
	 * A fraction can be constructed by using two integer values, a numerator and denominator,
	 * respectively. Should a user of the class provide a 0 as the denominator, they should
	 * expect unpredictable results. 
	 */
public class Fraction {
	// data fields
	private int numerator;
	private int denominator;
	
	//constructors
	
	/*
	 * Constructs a fraction based on a numerator and denominator
	 * 
	 *  Parameters:
	 *  double numerator is the numerator of the fraction
	 *  double denominator is the denominator of the fraction
	 * 
	 */
	public Fraction(int numerator, int denominator){
		this.numerator =  numerator;
		this.denominator = denominator;
	}
	/*
	 * Constructs a fraction based on a whole number
	 * 
	 *  Parameters:
	 *  int whole number results in a fraction with a numerator of the whole number and a denominator of 1
	 * 
	 */
	public Fraction(int wholeNumber){
		this.numerator = wholeNumber;
		this.denominator = 1;
	}
	/*
	 * Constructs a default fraction 
	 * 
	 *  Parameters:
	 *  No parameters, initalizes values of numerator and denominator to 0 and 1 respectively.
	 * 
	 */
	public Fraction(){
		this.numerator = 0;
		this.denominator = 1;
	}

	//methods
	
	/*
	 * This method takes two fraction objects, an implicit and an explicit fraction. This method adds the two fractions together. The method creates a new Fraction C which sets the numerator equal to
	 * the new numerator and the denominator equal to the common denominator.
	 * 
	 * Parameters:
	 * implicit Fraction this and explicit Fraction B
	 */
	public Fraction add(Fraction B){
		Fraction C = new Fraction(1,1);
		C.setNumerator(this.getNumerator() * B.getDenominator() + this.getDenominator() * B.getNumerator()); 
		C.setDenominator(this.getDenominator() * B.getDenominator());
		return C;
	}
	
	/*
	 * This method takes two fraction objects, an implicit and an explicit fraction.This method subtracts the two fractions. The method creates a new Fraction C 
	 * which sets the numerator equal to the new numerator and the denominator equal to the common denominator. If the method is invoked as A.subtract(B), 
	 * the subtraction will occur as A-B.
	 * 
	 * Parameters:
	 * implicit Fraction this and explicit Fraction B
	 */
	public Fraction subtract(Fraction B){
		Fraction C = new Fraction(1,1);
			C.setNumerator(this.getNumerator() * B.getDenominator() - this.getDenominator() * B.getNumerator()); 
			C.setDenominator(this.getDenominator() * B.getDenominator());
			return C;
	}
	/*
	 * This method takes two fraction objects, an implicit and an explicit fraction.This method multiplies the two fractions. The method creates a new Fraction C 
	 * which sets the numerator equal to the new numerator and the denominator equal to the common denominator.
	 * Parameters:
	 * implicit Fraction this and explicit Fraction B
	 */
	public Fraction multiply(Fraction B){
		Fraction C = new Fraction(1,1);
		C.setNumerator(this.getNumerator() * B.getNumerator()); 
		C.setDenominator(this.getDenominator() * B.getDenominator());
		return C;
	}
	/*
	 * This method takes two fraction objects, an implicit and an explicit fraction.This method divides the two fractions. The method creates a new Fraction C which sets 
	 * the numerator equal to the new numerator and the denominator equal to the common denominator. If the method is invoked as A.divide(B), the division occurs as A/B.
	 * 
	 * Parameters:
	 * implicit Fraction this and explicit Fraction B
	 */
	public Fraction divide(Fraction B){
		Fraction C = new Fraction(1,1);
		C.setNumerator(this.getNumerator() * B.getDenominator()); 
		C.setDenominator(this.getDenominator() * B.getNumerator());
		return C;
	}
	
	/*
	 * This method takes the numerator and denominator of the implicit fraction that invokes this method and creates a new fraction with those values reversed
	 * 
	 * Parameters:
	 * implicit Fraction this
	 * 
	 */
	public Fraction reciprocal(){
	Fraction C =  new Fraction(this.getDenominator(), this.getNumerator());
	return C;
			
	}
	
	/*
	 * This method takes the numerator and denominator of the implicit fraction that invokes this method and divides the two values using type casting to a double
	 * 
	 * Parameters:
	 * implicit Fraction this
	 */
	public double toDecimal(){
		double d = (double) this.getNumerator() / this.getDenominator();
		return d;
	}

	/*
	 * This method uses the Fraction object that invokes it and constructs a string in the form A/B with 
	 * the numerator and denominator of the implicit fraction
	 * 
	 * Parameters: implicit fraction this
	 */
	public String toString(){
		// find the larger of the numerator and denominator
		int n = numerator, d = denominator, largest;
		if (numerator < 0) {
			n = -numerator;
		}
		if (n > d) {
			largest = n;
		}
		else {
			largest = d;
		}
		int gcd = 0;
		for (int i = largest; i >= 2; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcd = i;
				break;
			}
		}
		if (gcd != 0){
			this.numerator /= gcd;
			this.denominator /= gcd;
		}

		else {
			this.numerator/= 1;
			this.denominator /= 1;
		}

		if (numerator * denominator < 0 && denominator < 0){
			this.numerator = -numerator;
			this.denominator = -denominator;
		}
		if (numerator * denominator >= 0 && denominator < 0){
			this.numerator = -numerator;
			this.denominator = -denominator;
		}
		if (numerator == 0){
			return "" + 0;
		}

		String str = numerator + "/" + denominator;
		if (denominator == 1){
			return "" + numerator;
		}
		else if (denominator == 0){
			return " Undefined ";
		}
		else{
			return str;
		}


	}		
		

	
	//getters and setters
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
}
