
public class Polygon {
	// Data fields
	private double radius;
	private double angle;
	private int numSides;
	
	/*
	 * Constructs a Polygon object based on a radius and a number of sides
	 * 
	 * Parameters:
	 * 
	 */
	public Polygon(double radius2, int numSides, double angle){
		this.radius = radius2;
		this.numSides = numSides;
		this.angle = angle;
	}
	
	
	public String toString(){
		return "Polygon with radius " + this.radius + ", angle " + this.angle + ", and " + this.numSides + " sides.";
	}
	
	public void rotate(double dTheta){
		if(dTheta > 0){
			if(this.angle + dTheta < Math.PI * 2){
				this.angle += dTheta;
			} else {
				this.angle += dTheta - Math.PI * 2;
			}
		} else {
			if(this.angle + dTheta > -Math.PI * 2){
				this.angle += dTheta;
			} else {
				this.angle += dTheta + Math.PI * 2;
			}
		}
	}
	
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
		
		Polygon dodecagon = new Polygon(1, 12,0);
		System.out.println(printArray(dodecagon.convertToCartesian()));
	}


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
