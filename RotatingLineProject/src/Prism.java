/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * Prism.java
 * 
 * Represents a 3-dimensional regular prism with a certain
 * number of face sides. Implements the Rotatable 
 * interface for use in the Display class to be shown as
 * rotating.
 */
public class Prism implements Rotatable {
	private double radius;
	private double angle;
	private int faceSides;
	
	public Prism(double radius, int faceSides){
		this.radius = radius;
		this.angle = 0;
		this.faceSides = faceSides;
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
		Polygon poly1 = new Polygon(radius, faceSides,angle);
		Polygon poly2 = new Polygon(radius, faceSides,angle);
		
		double[][] result = new double[this.faceSides * 2][2]; 
		double[][] poly1Cartesian = poly1.convertToCartesian();
		double[][] poly2Cartesian = poly2.convertToCartesian();
		
		for(int i = 0; i < poly2Cartesian.length; i++){
			for(int j = 0; j < 2; j++){
				poly2Cartesian[i][j] += 50;
			}
		}
		
		int i = 0;
		for(; i < poly1Cartesian.length; i++){
			result[i] = poly1Cartesian[i];
		}
		for(double[] a: poly2Cartesian){
			result[i] = a;
			i++;
		}
		
		return result;
		
	}
	
	// Getters and setters
	public int getFaceSides(){
		return faceSides;
	}
	public void setFaceSides(int numSides){
		this.faceSides = numSides;
	}
	
	public static void main(String[] args){
		Prism poly = new Prism(1, 12);
		
		System.out.println(printArray(poly.convertToCartesian()));
	}
}
