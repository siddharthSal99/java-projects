/*
 * $iddharth $alunkhe
 * This class defines a GameBoard object. This is designed as a general class which can be used for multiple games with different size boards.
 * The board is made of a 2 dimensional array. Each index is given an int value that can correspond to a game piece. A value of zero means that the index is not occupied.
 * All boards constructed will be rectangular
 */
public class GameBoard {
	private int[][] boardArray;
	
	/*
	 * this constructor constructs the gameboard array from a given number of rows and columns
	 * All boards constructed will be rectangular
	 * Parameters: int number of rows, int number of columns
	 * 
	 */
	public GameBoard(int numRows, int numCols){
		this.boardArray = new int[numRows][numCols];
	}
	/*
	 * this constructor constructs a square gameboard array from a given side length, 
	 * Parameters: int sideLength
	 * 
	 */
	public GameBoard(int sideLength){
		this(sideLength, sideLength);
	}
	
	/*
	 * this constructor constructs the gameboard array from a given preset 2D array
	 * Parameters: int[][] board
	 * 
	 */
	public GameBoard(int[][] board){
		boardArray = new int[board.length][board[0].length];
	    for(int i = 0; i< board.length; i++){
	        for (int j = 0; j < board[i].length; j++){
	            boardArray[i][j] = board[i][j];
	        }
	    }
	    
	}
	/*
	 * setter for a piece at a certain location
	 * Parameters: int rowNum, int colNum, int pieceVal
	 * Returns: int old value of the cell
	 */
	public int setPiece(int rowNum, int colNum, int pieceVal){
		int oldVal = boardArray[rowNum][colNum];
		boardArray[rowNum][colNum] = pieceVal;
		return oldVal;
	}
	/*
	 * getter for the value of a piece at a location on the board
	 * parameters: int row number, int col number
	 * returns: int pieceValue
	 */
	public int getPiece(int rowNum, int colNum){
		int pieceVal = boardArray[rowNum][colNum];
		return pieceVal;
	} 
	/*
	 * removes the piece at a specified location by setting the location = 0
	 * parameters: int row number, int col number
	 * returns: int piece value
	 */
	public int removePiece(int rowNum, int colNum){
		int pieceVal = setPiece(rowNum,colNum,0);
		return pieceVal;
	}
	/*
	 * getter for the number of rows of the board
	 * parameters: none
	 * returns: int (length of the board array)
	 */
	public int getRows(){
		return boardArray.length;
	}
	/*
	 * getter for the number of columns on the board
	 * parameters: none
	 * returns: int (length of the first subarray in the board array)
	 */
	public int getCols(){
		return boardArray[0].length;
	}
	/*
	 * tests if a location on the board is within the board array specified
	 * parameters: int row number, int col number
	 * returns: boolean (true if on the board, false if not)
	 */
	public boolean isValid(int rowNum, int colNum){
		return (boardArray.length > rowNum && boardArray[0].length > colNum && colNum >= 0 && rowNum >= 0 );
		
	}
	/*
	 * tests if a spot on the board has another piece there
	 * parameters: int row number, int col number
	 * returns: boolean (true if occupied, false if not)
	 */
	public boolean isOccupied(int rowNum, int colNum){
		if(this.isValid(rowNum,colNum)){
		if(boardArray[rowNum][colNum] != 0)
			return true;
		}
		
		return false;
	}
	
	/*
	 * sets the current state of the board to a string representation
	 * parameters: none
	 * returns: string boardString (string version of the board in ones and zeroes)
	 */
	public String toString(){
		String boardString = "";
		for(int i = 0; i< this.getRows(); i++){
			for(int j = 0; j< this.getCols(); j++){
				boardString += boardArray[i][j] + " ";
			}
			boardString += "\n";
		}
		return boardString;
	}
	/*
	 * sets every location on the board as unoccupied or zero
	 * parameters: none
	 * returns: none
	 */
	public void clear(){
		for(int row = 0; row < boardArray.length; row++){
			for(int col = 0; col < boardArray[row].length; col++)
				boardArray[row][col] = 0;
		}
			
	}
	
}