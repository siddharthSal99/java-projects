/*
 * This class accomplishes two tasks: it can calculate the area of a regular polygon given the circumscribed circle radius, and calculate the area of the polygon given the 
 * side length of the polygon. It prints the table of radius and area, as well as side length and area.
 * 
 */
public class LoopExamplesHonors {
	/*
	 * This method calculates the area of a regular polygon inscribed in a circle with a given radius.
	 * All negatives will be treated as positive. 
	 * parameters: double radius, double number of sides
	 * returns: double area of polygon
	 */
	public static double radiusArea(double radius, double numSides){

			double area = 0.5 * radius * radius * numSides * Math.sin(2*Math.PI / numSides);
			return area;
	}
	/*
	 * This method prints the area of a regular polygon inscribed in a circle with a side length.
	 * All negatives will be treated as positive. 
	 * parameters: double side length, double number of sides
	 * returns: double area of polygon
	 */
	public static double sideLengthArea(double sideLength, double numSides){

			double area = 0.25 * sideLength * sideLength * numSides / (Math.tan(Math.PI / numSides));
			return area;
	}
	/*
	 * This method prints the table of values given the number of sides. It formats the two parameters into a table. 
	 * 
	 * Parameters: double side length
	 * return: none
	 * output: prints a table of values of the number of sides of the polygon and its respective area with a certain range of number of sides.
	 */
	public static void printSideLengthAreaTable(double sideLength){
		System.out.println("Areas of regular polygons with side length " + sideLength + "\n" );
		System.out.printf("%s | %10s | %n", "Number of Sides", "Area");
		int maxSides = 10;
		for (int numSides = 3 ; numSides <= maxSides ; numSides++){
		System.out.printf("%15d | %f | %n", numSides, sideLengthArea(sideLength,numSides));
		}
	}
	/*
	 * This method prints the table of values given the radius. It formats the two parameters into a table. 
	 * 
	 * Parameters: double radius of circumscribed circle.
	 * return: none
	 * output: prints a table of values of the number of sides of the polygon and its respective area with a certain range of number of sides.
	 */
	public static void printRadiusAreaTable(double radius){
		int maxSides = 10;
		System.out.println("Areas of regular polygons inscribed in a circle with radius " + radius + "\n" );
		System.out.printf("%s | %10s | %n", "Number of Sides", "Area");
		for (int numSides = 3 ; numSides <= maxSides ; numSides++){
		System.out.printf("%15d | %f | %n", numSides, radiusArea(radius,numSides));
		}
	}
	public static void main (String [] args){
		printRadiusAreaTable(5);
		printSideLengthAreaTable(7);
	}
}
/*
 * OUTPUT:
Areas of regular polygons inscribed in a circle with radius 5.0

Number of Sides |       Area | 
              3 | 32.475953 | 
              4 | 50.000000 | 
              5 | 59.441032 | 
              6 | 64.951905 | 
              7 | 68.410255 | 
              8 | 70.710678 | 
              9 | 72.313606 | 
             10 | 73.473157 | 
Areas of regular polygons with side length 7.0

Number of Sides |       Area | 
              3 | 21.217622 | 
              4 | 49.000000 | 
              5 | 84.303393 | 
              6 | 127.305734 | 
              7 | 178.061710 | 
              8 | 236.592929 | 
              9 | 302.909385 | 
             10 | 377.016233 | 

 */ 
