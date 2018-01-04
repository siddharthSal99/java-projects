
public class ThreeDPolygon  {
	private double radius;
	private double angle;
	private int faceSides;
	
	public ThreeDPolygon(double radius, int faceSides){
		this.radius = radius;
		this.angle = 0;
		this.faceSides = faceSides;
	}
	
	public void rotate(double dTheta) {
		// TODO Auto-generated method stub
		if (dTheta > 0) {
			if (this.angle + dTheta < Math.PI * 2) {
				this.angle += dTheta;
			} else {
				this.angle += dTheta - Math.PI * 2;
			}
		}
		else {
			if (this.angle + dTheta > -Math.PI * 2) {
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
	public int getFaceSides(){
		return faceSides;
	}
	
	public static void main(String[] args){
		ThreeDPolygon poly = new ThreeDPolygon(1, 12);
		
		System.out.println(printArray(poly.convertToCartesian()));
	}
}
