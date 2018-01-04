/*
 * TextLine is a specific type of Line. It has a length, like all lines, but is only horizontally drawn. A text line is a string that is printed on the screen
 * the private data is the String that one would like to paint
 * it can only be drawn on a screen object. Although the length can be greater than the screen, only the part that is on the screen is visible
 * 
 */
public class TextLine extends HLine {
	private String textLine;
	/*
	 * this ctor accepts a string and sets the length of the line = to the string length. It also sets the String field
	 * parameters: String textline
	 * returns: none
	 */
	public TextLine(String textLine){
		super(textLine.length());
		this.textLine = textLine;
	}
	/*
	 * this default ctor sets the String to empty and the line length to the default 0
	 */
	public TextLine(){
		super();
		this.textLine = "";
	}
	/*
	 * implements the paintOn() abstract method from Shape which draws a TextLine based on the length. It sets the paint character to each of the chars that make up the string 
	 * It starts drawing the TextLine at the specified location and draws right
	 * 
	 * parameters: Screen screen, int x coordinate, int y coordinate
	 * returns: none
	 */
	public void paintOn(Screen screen, int xCoord, int yCoord) {
		for(int i = xCoord, j = 0; i < (xCoord + getLength()); i++, j++){
			screen.paintAt(i, yCoord,textLine.charAt(j));
		}
	}
	/*
	 * implements the paintOn() abstract method from Shape which draws a TextLine based on the length. It sets the paint character to each of the chars that make up the string 
	 * It starts drawing the TextLine at (0.0) and draws right
	 * 
	 * parameters: Screen screen
	 * returns: none
	 */
	public void paintOn(Screen screen) {
		paintOn(screen,0,0);
	}
	/*
	 * main() tests a few cases of the object, as well as some of its methods. Most of the testing was done using the ShapeMenu and user input.
	 *  * parameters: String[] args
	 * returns: void
	 */
	public static void main(String[] args){
		Screen screen = new Screen(20,10);
		TextLine tLine = new TextLine("Hello World");
		tLine.paintOn(screen);
		tLine.paintOn(screen, -2, 9);
		screen.draw();
		screen.clearScreen();

		TextLine tLine2 = new TextLine("--- HAN SHOT FIRST ---");
		tLine2.paintOn(screen);
		tLine2.paintOn(screen, 5, 5);
		screen.draw();
		screen.clearScreen();


		TextLine tLine3 = new TextLine("");
		tLine3.paintOn(screen);
		tLine3.paintOn(screen, 8, 8);
		screen.draw();
		screen.clearScreen();


		TextLine tLine4 = new TextLine();
		tLine4.paintOn(screen);
		tLine4.paintOn(screen, 9, 9);
		screen.draw();
	}
}