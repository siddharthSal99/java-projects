
public class LinearEquationTester {

	public static void main(String[] args) {

		LinearEquation line = new LinearEquation(1, 3);
		
		System.out.println(line.toString());
		
		LinearEquation line2 = new LinearEquation(1, 1, 2, 3);
		System.out.println(line2); // implicitly calls toString()
		
		System.out.println("If x = 4.6, then y = " + line.getY(4.6));
		System.out.println("If y = 4.6, then x = " + line.getX(9.9));
		/*
		 * After this I was experimenting creating a new class that constructs objects of type "Point"
		 * 
		 * The Point object takes in two parameters: double x and double y
		 * 
		 * Using the methods getYInt(double x1,double y1) and getSlope(double x1,double y1), 
		 * I can calculate the slope and y int of the point 
		 * 
		 * The to methods need to take in another point (x1,y1) to calculate slope and y-int
		 * 
		 */
		Point p = new Point (5,6);
		
		double b = p.getYInt(9,8);
		double m = p.getSlope(9,8);
		System.out.println("The equation of a line through point p and (9,8) is y = "+ m +" * x + " + b);
		
		System.out.println(p.calcSlope(p, 3.0, 9.0));
		
		System.out.println();
		System.out.println();
		LinearEquation line3 = new LinearEquation(5, 3);
		LinearEquation line4 = new LinearEquation(2, 8);
		
		System.out.println("The composition of lines y = 5 * x + 3 and y = 2 * x + 8 is " + line3.composition(line4));
	}

}
