/*
 * Objects of this class represent mixed numbers in the form a_p/q where p/q is a fraction object
 * The fraction must be expressed as a ratio of integers, not decimals, and should not have a 
 * zero in the denominator.
 * 
 * A mixed number can be constructed in four ways:
 * 1) with three integers, representing whole number, numerator and denominator, respectively
 * 2) with two integers, a numerator and denominator
 * 3) with a fraction object converted to a mixed number
 * 4) with a one integer, which represents a whole number
 * 
 * Note: the only negative sign that has any meaning is the one attached to the whole number. All other negative signs are ignored. For example: 
 * new MixedNumber(-5,-2,3), new MixedNumber(-5,2,3), new MixedNumber(-5,-2,-3), and new MixedNumber(-5,2,-3) all represent the same mixed number. 
 * Beware! Creating a mixed number such as new MixedNumber(0,-1,10) is creating the fraction 1/10, not -1/10.
 * 
 */
public class MixedNumber {

	//data fields
	private Fraction fraction;
	private int wholeNumber;

	/*
	 * this constructor creates a MixedNumber object by converting an improper fraction to a mixed number
	 * Parameters:
	 * 
	 * Fraction improper is an improper fraction
	 */

	public MixedNumber(Fraction fraction){
		if(fraction.getDenominator() != 0){
			if (fraction.getNumerator()/fraction.getDenominator() == 0){
				this.wholeNumber = 0;
				this.fraction = fraction;
			}
			else if (fraction.getNumerator() >= 0 && fraction.getDenominator() > 0){
				this.wholeNumber = fraction.getNumerator() / fraction.getDenominator();
				this.fraction = new Fraction(fraction.getNumerator() % fraction.getDenominator(),fraction.getDenominator());
			}
			else if (fraction.getNumerator() < 0 && fraction.getDenominator() > 0){
				this.wholeNumber = fraction.getNumerator() / fraction.getDenominator();
				this.fraction = new Fraction(-1 * fraction.getNumerator() % fraction.getDenominator(),fraction.getDenominator());
			}
			else if (fraction.getNumerator() >= 0 && fraction.getDenominator() < 0){
				this.wholeNumber = fraction.getNumerator() / fraction.getDenominator();
				this.fraction = new Fraction(fraction.getNumerator() % fraction.getDenominator(),-1 * fraction.getDenominator());
			}
			else{
				this.wholeNumber = fraction.getNumerator() / fraction.getDenominator();
				this.fraction = new Fraction(-1 * fraction.getNumerator() % fraction.getDenominator(),-1 * fraction.getDenominator());
			}
		}
		else{
			this.fraction = fraction;
		}
	}






	/*
	 * this constructor creates a MixedNumber object by converting an an integer whole number, integer numerator, 
	 * integer denominator to a mixed number
	 * Parameters:
	 * 
	 * int wholeNumber, int numer, int denom
	 */
	public MixedNumber(int wholeNumber, int numer, int denom){
		if (numer  < 0){
			this.wholeNumber = wholeNumber;
			this.fraction = new Fraction (-numer,denom);
		}
		else if (denom < 0){
			this.wholeNumber = wholeNumber;
			this.fraction = new Fraction (numer,-denom);
		}
		else if (numer < 0 && denom < 0){
			this.wholeNumber = wholeNumber;
			this.fraction = new Fraction (-numer,-denom);
		}
		else{
			this.wholeNumber = wholeNumber;
			this.fraction = new Fraction (numer,denom);
		}
	}




	/*
	 * this constructor creates a MixedNumber object by converting an an a numerator and a denominator to a mixed number
	 * The mixed number may also be just a fraction, if the numerator < denominator
	 * Parameters:
	 * 
	 * int numer, int denom
	 */
	public MixedNumber (int numer, int denom){
		this.wholeNumber = numer / denom;
		this.fraction = new Fraction(numer % denom , denom);
	}





	/*
	 * this constructor creates a MixedNumber object by converting an a whole number to mixed number where the fraction is 0/1 or 0
	 * Parameters:
	 * 
	 * int numer, int denom
	 */
	public MixedNumber(int wholeNumber){
		this.wholeNumber = wholeNumber;
		this.fraction = new Fraction(0,1);
	}





	/*
	 * This ctor sets a default constructor as 0_0/1, which is basically 0
	 * 
	 * Parameters: none
	 */
	public MixedNumber(){
		this.wholeNumber = 0;
		this.fraction = new Fraction(0,1);
	}






	// getters and setters
	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	public int getWholeNumber() {
		return wholeNumber;
	}

	public void setWholeNumber(int wholeNumber) {
		this.wholeNumber = wholeNumber;
	}




	// methods 

	/*
	 * This method uses two MixedNumber objects, one is implicit, that invokes the method, and the other is explicit
	 * This method converts the two mixed numbers to fractions, uses the fraction.add() method to add them, and then converts the result back into a mixed
	 * number using the constructor that accepts a fraction
	 * 
	 * Parameters:
	 * implicit: MixedNumber this, explicit: MixedNumber mixed 2
	 * 
	 */
	public MixedNumber add(MixedNumber mixed2){

		MixedNumber newMixed = new MixedNumber(this.toFraction().add(mixed2.toFraction()));
		return newMixed;
	}





	/*
	 * This method uses two MixedNumber objects, one is implicit, that invokes the method, and the other is explicit
	 * This method converts the two mixed numbers to fractions, uses the fraction.subtract() method to subtract them, and then converts the result back into a mixed
	 * number using the constructor that accepts a fraction
	 * 
	 * Parameters:
	 * implicit: MixedNumber this, explicit: MixedNumber mixed 2
	 * 
	 */
	public MixedNumber subtract(MixedNumber mixed2){

		MixedNumber newMixed = new MixedNumber(this.toFraction().subtract(mixed2.toFraction()));
		return newMixed;
	}





	/*
	 * This method uses two MixedNumber objects, one is implicit, that invokes the method, and the other is explicit
	 * This method converts the two mixed numbers to fractions, uses the fraction.multiply() method to multiply them, and then converts the result back into a mixed
	 * number using the constructor that accepts a fraction
	 * 
	 * Parameters:
	 * implicit: MixedNumber this, explicit: MixedNumber mixed 2
	 * 
	 */
	public MixedNumber multiply(MixedNumber mixed2){

		MixedNumber newMixed = new MixedNumber(this.toFraction().multiply(mixed2.toFraction()));
		return newMixed;
	}





	/*
	 * This method uses two MixedNumber objects, one is implicit, that invokes the method, and the other is explicit
	 * This method converts the two mixed numbers to fractions, uses the fraction.divide() method to divide them, and then converts the result back into a mixed
	 * number using the constructor that accepts a fraction
	 * 
	 * Parameters:
	 * implicit: MixedNumber this, explicit: MixedNumber mixed 2
	 * 
	 */
	public MixedNumber divide(MixedNumber mixed2){

		MixedNumber newMixed = new MixedNumber(this.toFraction().divide(mixed2.toFraction()));
		return newMixed;
	}





	/*
	 * This method converts the mixed number object that invokes this method to a fraction, then creates a new fraction which is the reciprocal of the previous fraction.
	 * 
	 * Parameters:
	 * implicit MixedNumber this (invokes the method)
	 */
	public MixedNumber reciprocal(){
		return new MixedNumber(this.toFraction().reciprocal());

	}




	/*
	 * this method is probably the most useful method in this class because all it does is use the mixed number that invokes it, and converts that
	 * to a fraction object. This allows me to use all of the fraction methods to do all the calculations, and all I have to do is construct a mixed number from the result
	 * 
	 * Parameters:
	 * implicit MixedNumber this (invokes the method)
	 */
	public Fraction toFraction(){
		int c;
		int d;
		if (this.getWholeNumber() > 0 && this.getFraction().getNumerator() >= 0 && this.getFraction().getDenominator() >= 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() + this.getFraction().getNumerator();
			d = this.getFraction().getDenominator();
			return new Fraction(c,d);
		}
		else if (this.getWholeNumber() > 0 && this.getFraction().getNumerator() < 0 && this.getFraction().getDenominator() >= 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() + -1 * this.getFraction().getNumerator();
			d = this.getFraction().getDenominator();
			return new Fraction(c,d);
		}
		else if (this.getWholeNumber() > 0 && this.getFraction().getNumerator() >= 0 && this.getFraction().getDenominator() < 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() * -1 + this.getFraction().getNumerator();
			d = -1 * this.getFraction().getDenominator();
			return new Fraction(c,d);
		}
		else if (this.getWholeNumber() > 0 && this.getFraction().getNumerator() < 0 && this.getFraction().getDenominator() < 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() * -1 + -1 * this.getFraction().getNumerator();
			d = -1 * this.getFraction().getDenominator();	
			return new Fraction(c,d);
		}
		else if (this.getWholeNumber() < 0 && this.getFraction().getNumerator() >= 0 && this.getFraction().getDenominator() >= 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() * -1 + this.getFraction().getNumerator();
			d = this.getFraction().getDenominator();	
			return new Fraction(-c,d);
		}
		else if (this.getWholeNumber() < 0 && this.getFraction().getNumerator() < 0 && this.getFraction().getDenominator() >= 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() + -1 * this.getFraction().getNumerator();
			d = this.getFraction().getDenominator();	
			return new Fraction(-c,d);
		}
		else if (this.getWholeNumber() < 0 && this.getFraction().getNumerator() >= 0 && this.getFraction().getDenominator() < 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() * -1 + -1 * this.getFraction().getNumerator();
			d = -1 * this.getFraction().getDenominator();
			return new Fraction(-c,d);
		}
		else if (this.getWholeNumber() == 0 && this.getFraction().getNumerator() >= 0 && this.getFraction().getDenominator() < 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() - this.getFraction().getNumerator();
			d = this.getFraction().getDenominator();
			return new Fraction(c,d);
		}
		else if (this.getWholeNumber() == 0 && this.getFraction().getNumerator() < 0 && this.getFraction().getDenominator() >= 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() + this.getFraction().getNumerator();
			d = this.getFraction().getDenominator();
			return new Fraction(c,d);
		}
		else if (this.getWholeNumber() == 0 && this.getFraction().getNumerator() >= 0 && this.getFraction().getDenominator() >= 0){
			c = this.getWholeNumber() * this.getFraction().getDenominator() + this.getFraction().getNumerator();
			d = this.getFraction().getDenominator();
			return new Fraction(c,d);
		}
		else{
			c = this.getWholeNumber() * this.getFraction().getDenominator() + -1 * this.getFraction().getNumerator();
			d = -1 * this.getFraction().getDenominator();
			return new Fraction(-c,d);
		}

	}





	/*
	 * This method converts the mixed number object that invokes this method to a fraction, then uses the fraction toDecimal() method to convert
	 * to a decimal
	 * 
	 * Parameters:
	 * implicit MixedNumber this (invokes the method)
	 */
	public double toDecimal(){
		return this.toFraction().toDecimal();

	}
	/*
	 * This method has multiple functions: it reduces the mixed number to lowest terms, makes sure the negative sign only appears in one location, removes the whole number 
	 * and fraction if any or both are equal to 0
	 * It assembles a string object from the whole number and fraction portions of the Mixed numbers.
	 */
	public String toString(){
		String str = "";

		if (fraction.getNumerator() * fraction.getDenominator() < 0 && fraction.getDenominator() < 0 ){
			Fraction frac = new Fraction (-1 * fraction.getNumerator(), -1 * fraction.getDenominator());
			str = "" + wholeNumber + "_" + frac.multiply(new Fraction(-1,1));
		}
		else if (fraction.getNumerator() * fraction.getDenominator() < 0 && fraction.getNumerator() < 0 ){
			Fraction frac = new Fraction (-1 * fraction.getNumerator(), -1 * fraction.getDenominator());
			str = "" + wholeNumber + "_" + frac.multiply(new Fraction(-1,1));
		}
		else if (fraction.getNumerator() == 0){
			str = "" + wholeNumber;
		}
		else {
			str = "" + wholeNumber + "_" + fraction;
		}
		if(this.getWholeNumber() == 0){
			str = "" + this.getFraction();
		}
		if(this.toFraction().getNumerator() == 0){
			str = "" + 0;
		}
		if (this.getFraction().getDenominator() == 0){
			return " Undefined ";
		}
		return str;

	}




}