
/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * Line.java
 * 
 * Represents a line with a set length. Implements the Rotatable 
 * interface for use in the Display class to be shown as
 * rotating.
 */
public class Line implements Rotatable{
	// datafields
	private int length;
	private double angle;

	/*
	 * Constructs new line with initial angle of 0 
	 * 
	 * Parameters: 
	 * int length = length of line as integer
	 */
	public Line(int length) {
		this.setLength(length);
		this.setAngle(0);
	}

	// Returns a String representation of the line
	public String toString() {
		String str = "Line length: " + length + "\nAngle:  " + angle;
		return str;
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


	// Returns an x-coordinate based on the current angle of the line
	public double convertToXCoord() {
		return length * Math.cos(angle);
	}

	// Returns an y-coordinate based on the current angle of the line
	public double convertToYCoord() {
		return length * Math.sin(angle);
	}

	// Getters and Setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public static void main(String[] args) {
		Line a = new Line(3);
		System.out.println(a.toString());
		System.out.println("xCoord: " + a.convertToXCoord());
		System.out.println("yCoord: " + a.convertToYCoord());
		for (int i = 0; i < 10; i++) {
			a.rotate(Math.PI /3.141592653589);
			System.out.println(a.toString());
			System.out.println("xCoord: " + a.convertToXCoord());
			System.out.println("yCoord: " + a.convertToYCoord() + "\n");
		}
	}
}
