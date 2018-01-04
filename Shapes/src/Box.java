/*
 * A Box is a type of shape. It has a length and a width, like a rectangle, but is filled in.
 * it can only be drawn on a screen object. Although the size can be greater than the screen, only the part that falls on the screen is visible
 * 
 */
public class Box extends Shape {
	private int length;
	private int width;
	/*
	 * this ctor sets the length, width, and the paint character for the box
	 * 
	 * parameters: int length, int width, char paintChar
	 * returns: none
	 */
	public Box(int length, int width, char bordChar){
		super(bordChar);
		this.length = length;
		this.width = width;

	}
	/*
	 * this default ctor for Box sets the length and width = 0, and the paint char to the default '*'
	 * 
	 * parameters: none
	 * returns: none
	 */
	public Box(){
		super();
		this.length = 0;
		this.width = 0;	
	}
	/*
	 * this ctor sets the length and width of the box and sets the paint char to '0'
	 * parameters: int length, int width
	 * returns: none
	 */
	public Box(int length, int width){
		this(length, width, '0');
	}
	/*
	 * implements the paintOn method of the Shape class, and paints a box on the given screen with the length and width. paints the box at the specified
	 * location with the x, y parameters on the screen
	 * 
	 * parameters: Screen screen, int x coord, int y coord
	 * returns: none
	 */
	@Override
	public void paintOn(Screen screen, int xCoord, int yCoord) {
		for(int i = xCoord; i < xCoord + width; i++){
			for(int j = yCoord; j < yCoord + length; j++){
				screen.paintAt(i, j, getPaintChar());
			}
		}

	}
	/*
	 * implements the paintOn method of the Shape class, and paints a box on the given screen with the length and width.
	 * paints the box at (0,0) on the screen
	 * 
	 * parameters: Screen screen
	 * returns: none
	 */
	@Override
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
		Box box = new Box(7,9);
		box.paintOn(screen);
		box.paintOn(screen, 2, 2);
		screen.draw();
		screen.clearScreen();

		Box box1 = new Box();
		box1.paintOn(screen);
		box1.paintOn(screen, 2, 2);
		screen.draw();
		screen.clearScreen();

		Box box2 = new Box(12,9);
		box2.paintOn(screen);
		box2.paintOn(screen, -4, -8);
		screen.draw();
		screen.clearScreen();

		Box box3 = new Box(7,0);
		box3.paintOn(screen);
		box3.paintOn(screen, 2, 2);
		screen.draw();
	}
}
