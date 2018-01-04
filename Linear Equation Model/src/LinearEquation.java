
public class LinearEquation {

	// data fields
	private double slope;
	private double yIntercept;
	
	/*
	 * Constructs a LinearEquation based on a slope and y-intercept
	 * 
	 * Parameters:
	 *   double m = the slope of the line
	 *   double b = the y-intercept of the line
	 */
	public LinearEquation(double m, double b){
		slope = m;
		yIntercept = b;
	}
	
	/*
	 * 
	 */
	public LinearEquation(double x1, double y1, double x2, double y2){
		slope = (y2 - y1) / (x2 - x1);
		yIntercept = y1 - slope * x1;
	}
	
	
	/*
	 * Creates a String representation of a LinearEquation object
	 * 
	 * Returns: a String in the form y = mx + b
	 */
	public String toString(){
		String str = "y = ";
		str = str + slope;
		str += "x + " + yIntercept;
		
		return str;
		
		// return "y = " + slope + "x + " + yIntercept;
	}
	
	/*
	 * Calculates a y-value based on a given x-value
	 * 
	 * Parameters:
	 *   double x = the x-coordinate of a point
	 * 
	 * Returns:
	 *   double value representing the y-coordinate of that point
	 */
	public double getY(double x){
		double y = slope * x + yIntercept;
		return y;
	}
	/*
	 * Calculates a x-value based on a given y-value
	 * 
	 * Parameters:
	 *   double y = the y-coordinate of a point
	 * 
	 * Returns:
	 *   double value representing the y-coordinate of that point
	 */
	public double getX(double y){
		double x = (y - yIntercept)/slope; 
		return x;
	}
	/*
	 * 
	 * 
	 */
	public LinearEquation inverse(){
		double invSlope = 1 / slope;
		double invYInt = -yIntercept / slope;
		LinearEquation inv = new LinearEquation(invSlope, invYInt);
		return inv;
	}
	
	/*
	 * 
	 */
	public LinearEquation composition(LinearEquation inner){
		double compSlope = slope * inner.slope;
		double compYInt = slope * inner.yIntercept + yIntercept;
		LinearEquation comp = new LinearEquation(compSlope, compYInt);
		return comp;
	}

}
