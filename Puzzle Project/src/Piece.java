
public class Piece {

	//Array of sides maintains the orientation of the Side types with repect to each other and holds the four sides that makes the puzzle Piece
	private Side[] sides = new Side[4];
	//the orientation stores how many 90 degree turns from the assigned value the Piece is at.
	private int orientation;
/*
 * This constructor creates a Piece by assigning the four sides of the piece different Side types from the enum list.
 * Parameters: Side top, Side right, Side bottom, Side left are the four side types which will be assigned to the direction as given by their name.
 * Returns: none
 */
	public Piece(Side top, Side right, Side bottom, Side left) {
		sides[0] = top;
		sides[1] = right;
		sides[2] = bottom;
		sides[3] = left;

	}

	public void rotateClockwise() {
		Side temp = sides[sides.length - 1];

		for(int i = sides.length - 1; i > 0; i--) {
			sides[i] = sides[i - 1];
		}
		sides[0] = temp;
		orientation = (orientation + 1) % 4;
	}

	public void rotateCounterClockwise(){		
		Side temp = sides[0];
		for(int i = 0; i < sides.length - 1 ; i++ ){
			sides[i] = sides[i + 1];
		}
		sides[sides.length - 1] = temp;
		orientation = (orientation + 3) % 4;
	}
	public Side getSide(Direction direction) {
		return sides[direction.getValue()];
	}

	public int getOrientation() {
		return orientation;
	}

	public String toString () {
		for(Side b: sides) 
			System.out.println(b + " ");
			System.out.println("Orientation = " + orientation);
		
		return "";
	}


	public static void main(String[] args) {
		
		Piece a = new Piece(Side.CLUB_IN, Side.CLUB_OUT, Side.HEART_IN, Side.HEART_OUT);
		System.out.println(a);
		System.out.println("The top is" + a.getSide(Direction.TOP));
		System.out.println("The bottom is" + a.getSide(Direction.BOTTOM));
		System.out.println("The right is" + a.getSide(Direction.RIGHT));
		System.out.println("The left is" + a.getSide(Direction.LEFT));
//		a.rotateCounterClockwise();
//		a.rotateCounterClockwise();
		
		System.out.println(a);
		System.out.println("The top is" + a.getSide(Direction.TOP));
		System.out.println("The bottom is" + a.getSide(Direction.BOTTOM));
		System.out.println("The right is" + a.getSide(Direction.RIGHT));
		System.out.println("The left is" + a.getSide(Direction.LEFT));

	}

}
