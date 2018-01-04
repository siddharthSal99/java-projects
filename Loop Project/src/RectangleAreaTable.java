/*
 * This Class prints out a table of values. One column for the length of the rectangle, one column for the width, and one column for the calculated area.
 * The class prompts you for a minimum and maximum length and width. should they be put out of order, (ie the min and max width are switched), then the class will automatically switch
 * them to the right order. the values printed range from the minimum dimension to the maximum dimension, calculating the area of the range of values.
 *  All negative values will be treated as positives. This Class only works for integer values for side lengths.
 */
import java.util.Scanner;

public class RectangleAreaTable {
	private static Scanner input = new Scanner(System.in);

/*
 * This method uses helper methods to gain input for the min/max length and width from the user. It then takes those values and makes sure that the min and max of the respective
 * dimensions of the rectangle are not out of order. If the minimum of a dimension is greater than the maximum, then this method switches the two, making the old max, the new min, and 
 * vice versa. It then calls the printRectangle() method to display the table of rectangle width, length and area on the output.
 * 
 * Parameters: none
 * Return values: none
 * Output: prints table of values on the console
 */
	public static void rectangleTable(){
		Scanner input = new Scanner(System.in);
		int lengthMin = checkMinLength();
		int lengthMax = checkMaxLength();
		int widthMin = checkMinWidth();
		int widthMax = checkMaxWidth();
		
		input.close();
		if (widthMax <= widthMin){
			int a = widthMax;
			int b = widthMin;
			widthMin = a;
			widthMax = b;
		}

		if (lengthMax <= lengthMin){
			int a = lengthMax;
			int b = lengthMin;
			lengthMin = a;
			lengthMax = b;
		}

		RectangleAreaTable.printRectangleTable(lengthMin, lengthMax, widthMin, widthMax);

	}
	
/*
 * This method prompts the user for a minimum integer length for the length of the rectangle. If the input value is negative, the method changes it to positive.
 * 
 * parameters: none
 * return: int, minimum length of rectangle
 */
	private static int checkMinLength(){
		System.out.println("Please enter a minimum integer length for the rectangle");
		int lengthMin = input.nextInt();
		if (lengthMin < 0)
			return -lengthMin;
		return lengthMin;
	}
	/*
	 * This method prompts the user for a maximum integer length for the length of the rectangle. If the input value is negative, the method changes it to positive.
	 * 
	 * parameters: none
	 * return: int, maximum length of rectangle
	 */
	private static int checkMaxLength(){
		System.out.println("Please enter a maximum integer length for the rectangle");
		int lengthMax = input.nextInt();
		if (lengthMax < 0)
			return -lengthMax;
		return lengthMax;
	}
	/*
	 * This method prompts the user for a minimum integer length for the width of the rectangle. If the input value is negative, the method changes it to positive.
	 * 
	 * parameters: none
	 * return: int, minimum width of rectangle
	 */
	private static int checkMinWidth(){
		System.out.println("Please enter a minimum integer width for the rectangle");
		int widthMin = input.nextInt();
		if (widthMin < 0)
			return -widthMin;
		return widthMin;
	}
	/*
	 * This method prompts the user for a maximum integer length for the width of the rectangle. If the input value is negative, the method changes it to positive.
	 * 
	 * parameters: none
	 * return: int, maximum width of rectangle
	 */
	private static int checkMaxWidth(){
		System.out.println("Please enter a maximum integer width for the rectangle");
		int widthMax = input.nextInt();
		if (widthMax < 0)
			return -widthMax;
		return widthMax;
	}
/*
 * This method takes in the integer dimensions that were input by the user and prints the range of values from the smallest to the largest dimension.
 * It also prints the calculated area next to the respective length and width
 * 
 * parameters: int, minimum length, max length, minimum width, max width
 * returns: none
 * output: prints table of areas
 */
	private static void printRectangleTable(int lengthMin, int lengthMax, int widthMin, int widthMax){
		System.out.println("width  length  area");
		for(int i = 0; i <= Math.abs(Math.abs(widthMax)-Math.abs(widthMin)); i++ ){
			
			for(int j = 0; j <= Math.abs(Math.abs(lengthMax)-Math.abs(lengthMin)); j++ ){
				
				int tableWidth = Math.abs(widthMin) + i; 
				int tableLength = Math.abs(lengthMin) + j; 
				int tableArea = tableWidth * tableLength;
				System.out.print(tableWidth + "\t" + tableLength + "\t" + tableArea);
				System.out.println();
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args){
		RectangleAreaTable.rectangleTable();
	}
}

