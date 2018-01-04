/*
 * A Frame is a type of shape. It has a length and a width, like a rectangle, but is not filled in.
 * it can only be drawn on a screen object. Although the size can be greater than the screen, only the part that falls on the screen is visible
 * length and width of the frame should be positive integers.
 * 
 */
public class Frame extends Shape {
	private int length;
	private int width;
	/*
	 * this ctor sets the length, width, and the paint character for the frame
	 * 
	 * parameters: int length, int width, char paintChar
	 * returns: none
	 */
	public Frame(int length, int width, char paintChar){
		super(paintChar);
		this.length = length;
		this.width = width;

	}
	/*
	 * this default ctor sets the length and width = 0, and the paint char to the default '*'
	 * 
	 * parameters: none
	 * returns: none
	 */
	public Frame(){
		super();
		this.length = 0;
		this.width = 0;	
	}
	/*
	 * this ctor sets the length and width of the frame and sets the paint char to '@'
	 * parameters: int length, int width
	 * returns: none
	 */
	public Frame(int length, int width){
		this(length, width, '@');
	}

	/*
	 * implements the paintOn method of the Shape class, and paints a frame on the given screen with the length and width. paints the frame at the specified
	 * location with the x, y parameters on the screen
	 * 
	 * parameters: Screen screen, int x coord, int y coord
	 * returns: none
	 */
	public void paintOn(Screen screen, int xCoord, int yCoord) {
		for(int i = 0; i < width; i++){
			screen.paintAt(xCoord + i, yCoord,getPaintChar());
			screen.paintAt(xCoord + i, yCoord + length -1 , getPaintChar());
		}
		for(int i = 0; i < length; i++){
			screen.paintAt(xCoord, yCoord + i,getPaintChar());
			screen.paintAt(xCoord + width - 1 , yCoord + i,getPaintChar());
		}


	}

	/*
	 * implements the paintOn method of the Shape class, and paints a frame on the given screen with the length and width.paints the frame at (0,0) on the screen
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
		Frame frame = new Frame(7,9);
		frame.paintOn(screen);
		frame.paintOn(screen, 2, 2);
		screen.draw();
		screen.clearScreen();

		Frame frame1 = new Frame();
		frame1.paintOn(screen);
		frame1.paintOn(screen, 2, 2);
		screen.draw();
		screen.clearScreen();

		Frame frame2 = new Frame(12,9);
		frame2.paintOn(screen);
		frame2.paintOn(screen, -4, -8);
		screen.draw();
		screen.clearScreen();

		Frame frame3 = new Frame(7,1);
		frame3.paintOn(screen);
		frame3.paintOn(screen, 2, 2);
		screen.draw();
	}

}
