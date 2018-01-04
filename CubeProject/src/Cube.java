
public class Cube {
	/*
	 * Parameters:
	 * double sideLength
	 * 
	 * 
	 * This Class will calculate surface area, volume, and perimeter
	 * of a cube with a given side length
	 */
	private double sideLength;


	public Cube(double s){
		sideLength = s;
	}
	
	
	
	/*
	 * Methods: calculate surface area, volume, perimeter
	 */
	public String surfaceArea(){
		double surfAr = 6 * this.sideLength * this.sideLength;
		return "The Surface Area is " +surfAr;
	}
	
	public String perimeter(){
		double peri = 12 * sideLength;
		return "The Perimeter is " + peri;
	}
	
	public String volume(){
		double vol = sideLength * sideLength * sideLength;
		return "The volume is " + vol;
	}
	
	

}