
public class PolygonArea {
/*
 * This method prints the area of a regular polygon inscribed in a circle with a given radius.
 * All negatives will be treated as positive. 
 * parameters: double radius
 * returns: none
 * output: prints a table of values between two side numbers that are specified by the user of the code.
 */
	public static void radiusArea(double radius){
		System.out.println("Areas of regular polygons inscribed in a circle with radius " + radius + "\n" );
		System.out.printf("%s | %9s | %n", "Number of Sides", "Area");

		for (int numSides = 10; numSides <= 15; numSides++){
			double area = 0.5 * radius * radius * numSides * Math.sin(2*Math.PI / numSides);

			System.out.printf("%15d | %f | %n", numSides, area);
		}
		System.out.println();
	}
	/*
	 * This method prints the area of a regular polygon inscribed in a circle with a side length.
	 * All negatives will be treated as positive. 
	 * parameters: double side length
	 * returns: none
	 * output: prints a table of values between two side numbers that are specified by the user of the code.
	 */
	public static void sideLengthArea(double sideLength){
		System.out.println("Areas of regular polygons with side length " + sideLength + "\n" );
		System.out.printf("%s | %10s | %n", "Number of Sides", "Area");

		for (int numSides = 10; numSides <= 15; numSides++ ){
			double area = 0.25 * sideLength * sideLength * numSides / (Math.tan(Math.PI / numSides));

			System.out.printf("%15d | %10f | %n", numSides, area);
		}
	}
//	public static int bigInt(int a, int b, int c){
//		if (a > b && a > c)
//			return a;
//		if (b > c)
//			return b;
//		return c;
//	}
//	 
	public static void main (String []args){
		//System.out.println(bigInt(0, 5, 6));
	}
}