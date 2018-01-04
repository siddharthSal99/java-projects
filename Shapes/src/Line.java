/*
 * this class serves as a base class for different types of lines such as HLines, VLines, and TextLines
 * it extends the shape class, therefore it needs a paint character and the other private data is the length
 * 
 */
public abstract class Line extends Shape {
	private int length;
	/*
	 * this ctor takes a length and paint char for the line
	 * 
	 * parameters: char paint character, int length
	 * returns: none
	 */
	public Line(char paintChar, int length){
		super(paintChar);
		this.length = length;
	}
	/*
	 * default constructor sets the paint char to '*' and the length to 0
	 * parameters: none
	 * returns: none
	 */
	public Line(){
		super();
		length = 0;
	}
	/*
	 * constructor accepts only a line length and sets the default paint char to asterisk
	 * parameters: int length
	 * returns: none
	 */
	public Line(int length){
		super();
		this.length = length;
	}
	/*
	 * getter for the length of the line
	 * parameters: none
	 * returns: int length
	 */
	public int getLength() {
		return length;
	}
	/*
	 * setter for the line length
	 * parameters: int length
	 * returns: none
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
}
