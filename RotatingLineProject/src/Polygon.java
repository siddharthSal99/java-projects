/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * Polygon.java
 * 
 * Represents a 2-dimensional regular polygon with a certain
 * number of sides. Implements the Rotatable 
 * interface for use in the Display class to be shown as
 * rotating.
 */
public class Polygon implements Rotatable{
	// Data fields
	private double radius;
	private double angle;
	private int numSides;

	/*
	 * Constructs a Polygon object based on a radius and a number of sides
	 * 
	 * Parameters:
	 * double radius = radius of the Polygon
	 * int numSides = number of sides of the Polygon
	 * double angle = current angle of the Polygon
	 */
	public Polygon(double radius, int numSides, double angle){
		this.radius = radius;
		this.numSides = numSides;
		this.angle = angle;
	}

	// Returns a String representation of the Polygon
	public String toString(){
		return "Polygon with radius " + this.radius + ", angle " + this.angle + ", and " + this.numSides + " sides.";
	}

	
	/*
	 * Increments the angle by a certain amount
	 * 
	 * Parameters:
	 * double dTheta = change in angle in radians
	 */
	public void rotate(double dTheta){
		this.angle += dTheta;
		if(Math.abs(angle) > Math.PI * 2)
			angle %= Math.PI * 2;
	}


	/*
	 * Returns a String representation of a 2D double array
	 * Used for testing of convertToCartesian() method
	 * 
	 * Parameters:
	 * double[][] array = array to represent
	 */
	private static String printArray(double[][] array){
		String str = "";
		for(int col = 0; col < array.length; col++){
			str += "[";
			for(int row = 0; row < 2; row++){
				if(row == 1) str += array[col][row] + "]";
				else str += array[col][row] + " ";
			}
			str += "\n";
		}

		return str;
	}

	/*
	 * Returns a 2D double array of coordinates of each vertex
	 */
	public double[][] convertToCartesian(){
		double angleSlice = (Math.PI * 2) / numSides;

		double[][] coords = new double[this.numSides][2];
		for(int i = 0; i < numSides; i++){
			coords[i][0] = this.radius * Math.cos(this.angle + i * angleSlice);
			coords[i][1] = this.radius * Math.sin(this.angle + i * angleSlice);
		}

		return coords;
	}

	public static void main(String[] args){
		double[][] a = {{1, 2}, {3, 4}, {5, 6}};

		System.out.println(printArray(a));

		System.out.println();
		Polygon dodecagon = new Polygon(1, 12, 0);
		System.out.println(printArray(dodecagon.convertToCartesian()));
	}

	// Getters and setters
	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setNumSides(int numSides){
		this.numSides = numSides;
	}


	public double getAngle() {
		return angle;
	}


	public int getNumSides() {
		return numSides;
	}
}
