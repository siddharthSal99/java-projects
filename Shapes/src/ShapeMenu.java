/*
 * This is the display class that prompts the user for the size of the screen, the shape they wish to draw, and the dimensions of the shape
 * It prints everything in the console.
 * If the user wishes to paint a shape starting from a location not ont he screen, only the part that is on the screen will be displayed
 * Scanner is private data
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class ShapeMenu {
	private static Scanner input = new Scanner(System.in);
/*
 * this method promts the user for an integer value. the value can be negative. It throws an exception if the input is not an integer.
 * 
 * parameters: none
 * returns: int
 */
	public static int promptInt(){
		int num;
		while(true){
			try{
				System.out.println("please enter an integer");
				num = input.nextInt();
				break;
				
			}
			catch(InputMismatchException e){
				System.out.println("invalid input");
				input.nextLine();
			}
		}
		input.nextLine();
		return num;
	}
	/*
	 * this method promts the user for an integer value. the value cannot be negative. It throws an exception if the input is not an integer, or if the value is negative
	 * 
	 * parameters: none
	 * returns: int
	 */
	public static int promptIntNoNegatives(){
		int num;
		while(true){
			try{
				System.out.println("please enter a positive integer");
				num = input.nextInt();
				if(num >= 0)
				break;
				System.out.println("invalid input");
			}
			catch(InputMismatchException e){
				System.out.println("invalid input");
				input.nextLine();
			}
		}
		input.nextLine();
		return num;
	}
/*
 * This method draws the shapes on the screen. it prompts the user for which shape they wish to draw and the dimensions of that shape.
 * it calls the promptInt() and promptIntNoNegatives() methods to gain input from the user.
 * 
 * parameters: Screen screen
 * returns: none
 */
	public static void drawShapes(Screen screen){
		
		int shapeInput = 0;
		while(true){
			try{
				System.out.println("Choose a shape to draw");
				System.out.println("Enter the number next to the shape you wish to draw \n");
				System.out.println("You can draw a: \n Horizontal Line (1) \n Vertical Line (2) \n TextLine (3) \n Frame (4) \n Box (5)" );
				shapeInput = input.nextInt();
				if(shapeInput <= 5 && shapeInput >= 1)
				break;
				System.out.println("invalid input");
			}
			catch(InputMismatchException e){
				System.out.println("Not A Valid input");
				input.nextLine();
			}
			input.nextLine();
		}
		if (shapeInput == 1){
			System.out.println("Enter a line length");
			int length = promptIntNoNegatives();
			HLine hLine = new HLine(length);

			System.out.println("Enter an x coordinate to draw the shape at");
			int xCoord = promptInt();
			System.out.println("Enter a y coordinate to draw the shape at");
			int yCoord = promptInt();

			hLine.paintOn(screen,xCoord,yCoord);
		}

		else if (shapeInput == 2){
			System.out.println("Enter a line length");
			int length = promptIntNoNegatives();
			VLine vLine = new VLine(length);

			System.out.println("Enter an x coordinate to draw the shape at");
			int xCoord = promptInt();
			System.out.println("Enter a y coordinate to draw the shape at");
			int yCoord = promptInt();

			vLine.paintOn(screen,xCoord,yCoord);
		}
		else if (shapeInput == 3){
			String str;
			input.nextLine();
			while(true){
				try{
					System.out.println("Enter a String to print");
					str = input.nextLine();
					break;
				}
				catch(InputMismatchException e){
					System.out.println("invalid input");
					input.nextLine();
				}
			}

			TextLine txtLn = new TextLine(str);

			System.out.println("Enter an x coordinate to draw the shape at");
			int xCoord = promptInt();
			System.out.println("Enter a y coordinate to draw the shape at");
			int yCoord = promptInt();
			txtLn.paintOn(screen,xCoord,yCoord);
		}
		else if (shapeInput == 4){
			System.out.println("Enter a frame height");
			int h = promptIntNoNegatives();
			System.out.println("Enter a frame width");
			int w = promptIntNoNegatives();
			Frame frm = new Frame(h,w);

			System.out.println("Enter an x coordinate to draw the shape at");
			int xCoord = promptInt();
			System.out.println("Enter a y coordinate to draw the shape at");
			int yCoord = promptInt();
			frm.paintOn(screen,xCoord,yCoord);
		}
		
		 else if (shapeInput == 5){
		 	System.out.println("Enter a box height");
			int h = promptIntNoNegatives();
			System.out.println("Enter a box width");
			int w = promptIntNoNegatives();
			Box box = new Box(h,w);

			System.out.println("Enter an x coordinate to draw the shape at");
			int xCoord = promptInt();
			System.out.println("Enter a y coordinate to draw the shape at");
			int yCoord = promptInt();
			box.paintOn(screen,xCoord,yCoord);
		 }
		screen.draw();
	}
/*
 * the program itself is run from here. The menu is diplayed on the console through main()
 * 
 * parameters: String[] args
 * returns: void
 */
	public static void main(String[] args){
		System.out.println("Enter a screen width");
		int width = promptIntNoNegatives();
		System.out.println("Enter a screen height");
		int height = promptIntNoNegatives();


		Screen screen = new Screen(width, height);
		boolean drawAgain = true;
		do{
			drawShapes(screen);
			String response;
			while(true){
					System.out.println("would you like to draw another shape? \n Enter y or n");
					response = input.nextLine();
					if(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n"))
						break;
					System.out.println("invalid response");
				
			}
			if(response.equalsIgnoreCase("n"))
				drawAgain = false;
		}while(drawAgain);

	}
}