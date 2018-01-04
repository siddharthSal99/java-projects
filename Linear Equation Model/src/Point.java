
public class Point {

	/*
	 * fields: double x and double y
	 * 
	 * This class will calculate slope and y-int when given two (x,y) coordinate points
	 */
	
	private double xValue;
	private double yValue;
	
	/*
	 * Constructs a point give and x and y coordinate
	 * 
	 * Parameters: 
	 * double x and double y : the coordinates of the point
	 * 
	 */
	public Point (double x,double y){
		xValue = x;
		yValue = y;
	}
	/*
	 * Calculates slope based on point object and another point, which is acquired as a parameter in the method
	 * 
	 * Parameter: 
	 *  double x1, and double y1 are the coordinates of the second point
	 */
	public double getSlope(double x1, double y1){
		double slope = (xValue - x1) / (yValue - y1);
		return slope;
		
	}
	/*
	 * Calculates y-int based on point object and another point, which is acquired as a parameter in the method
	 * 
	 * Parameter: 
	 *  double x1, and double y1 are the coordinates of the second point
	 */
	public double getYInt(double x1, double y1){
		double slope = (xValue - x1) / (yValue - y1);
		double yInt = y1 - slope * x1;
		return yInt;	
	}
	
	/*
	 * Calculates the slope with three parameters, a point object and x,y coordinates
	 * 
	 * Parameters:
	 * 	double x2, double y2
	 * 
	 * Returns: double slope 
	 * 
	 */
	public double calcSlope(Point p, double x2, double y2){
		double slope = (yValue - y2) / (xValue - x2);
		return slope;
		
	}
	
	
}
