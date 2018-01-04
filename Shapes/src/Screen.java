/*
 * $iddharth $alunkhe
 * The screen class is used as a display for different shapes that can be drawn on it. It has a length and a width because it is rectangular. The border character is not 
 * a part of the screen itself, but defines the white space inside as the drawn screen. The coordinates of the screen starts at (0,0) as the top-left corner.
 * The private data of the Screen class are a width, height, border character, and a int[][] that represents the values of the screen.
 * the width and height need to be positive integers or it will not work.
 */
public class Screen {
	private int width;
	private int height;
	private char bordChar = '*';
	private char[][] screen;

	/*
	 * This constructor accepts two arguments and creates a 2D array based on the length and width. It populates the values of the screen with spaces.
	 * width and height should be positive integers
	 * 
	 * parameters: int width, int length
	 * returns: none
	 */
	public Screen(int width, int height){
		// i is height , j is width
		this.width = width;
		this.height = height;
		this.screen = new char[height][width];
		for(int i = 0; i < height; i++ ){
			for (int j = 0; j < width; j++){
				screen[i][j] = ' ';
			}
		}
	}
	/*
	 * The toString() method represents the screen as a string so that it can be drawn on the console.
	 * 
	 * parameters: none
	 * returns: String str
	 */
	public String toString(){
		String str = "";
		for(int i = -1; i < height + 1; i++){
			for(int j = -1; j < width + 1; j++){
				if(i == -1 || i == height || j == -1 || j == width )
					str += bordChar + " ";
				else
					str += screen[i][j] + " ";
			}
			str += "\n";
		}
		return str;
	}
	/*
	 * This method sets all the values of the screen array to space
	 * 
	 * parameters: none
	 * returns: none
	 */
	public void clearScreen(){
		for(int i = 0; i < height; i++ ){
			for (int j = 0; j < width; j++){
				screen[i][j] = ' ';
			}
		}
	}
	/*
	 * this method draws a pixel at a given location. The pixel is a defined paint character.
	 * it checks if the location is on the screen or not, and only paints it if it is.
	 * 
	 * parameters: int x coordinate, int y coordinate, char paint character
	 * returns: none 
	 */
	public void paintAt(int x, int y, char paintChar){
		if(this.isValid(x , y ))
			screen[y ][x ] = paintChar;
	}

	/*
	 * this method tests if a location exists on the screen array.
	 * 
	 * parameters: int x coordinate, int y coord
	 * returns: boolean, if it exists then true.
	 */
	public boolean isValid(int x, int y){
		return (screen.length > y && screen[0].length > x && x >= 0 && y >= 0) ;

	}
	/*
	 * this method specifically calls the toString() to display the screen
	 * 
	 * parameters: none
	 * returns: none
	 * output: prints the screen on the console
	 */
	public void draw(){
		System.out.println(this.toString());
	}
	/*
	 * main() tests a few cases of the object, as well as some of its methods. Most of the testing was done using the ShapeMenu and user input.
	 *  * parameters: String[] args
	 * returns: void
	 */
	public static void main (String[] args){
		Screen screen = new Screen(20,10);
		screen.draw();
		System.out.println(screen.isValid(12, 30));
		screen.paintAt(10, 10,'+');
		screen.paintAt(9, 9,'+');
		screen.paintAt(8, 8,'+');
		screen.paintAt(7, 7,'+');
		screen.paintAt(6, 6,'+');
		screen.draw();
		screen.clearScreen();
		screen.draw();

		Screen screen2 = new Screen(15,25);
		screen2.draw();
		System.out.println(screen2.isValid(12, 30));
		screen2.paintAt(10, 15,'+');
		screen2.paintAt(9, 20,'+');
		screen2.paintAt(88, 88,'+');
		screen2.paintAt(3, -7,'+');
		screen2.paintAt(-6, 6,'+');
		screen2.draw();
		screen2.clearScreen();
		screen2.draw();

	}

}	

