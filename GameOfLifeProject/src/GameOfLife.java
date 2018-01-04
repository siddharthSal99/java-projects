/*
 * Siddharth Salunkhe
 * This class creates a Game of Life that can be played on a GameBoard object. Game of Life is played with the rules that a live cell with 2 or three neighbors survives
 * while a cell with more than 3 or less than 2 neighbors dies. A dead cell with exactly three neighbors comes to life. This class defines all the methods needed to play this game.
 */
import java.util.Random;

public class GameOfLife {
	private GameBoard gameBoard;
	private int genNumber;
/*
 * constructor creates a game of life from a preset game board by copying the game board array into another array, and setting the private Gameboard to that array
 * parameters:: GameBoard board
 *  
 */
	public GameOfLife(GameBoard board){
		int[][] boardArray = new int[board.getRows()][board.getCols()];
		for(int i = 0; i< board.getRows(); i++){
			for (int j = 0; j < board.getCols(); j++){
				boardArray[i][j] = board.getPiece(i, j);
			}
		}   
		gameBoard = new GameBoard(boardArray);
	}
	/*
	 * constructor creates a game of life given a length and width of the game
	 * parameters: int num rows, int num cols
	 */
	public GameOfLife(int numRows, int numCols){
		this(new GameBoard(numRows, numCols));
	}
	/*
	 * constructor creates a game of life from a 2D array
	 * parameters: int[][] board
	 * 
	 */
	public GameOfLife(int[][] board){
		this(board.length, board[0].length );
	}
	/*
	 * setter for the value of a cell
	 * parameters: int row num, int col num, int new value
	 * returns: old value of cell (int)
	 */
	public void setCell(int rowNum, int colNum, int newVal){
		gameBoard.setPiece(rowNum, colNum, newVal);
	}
	/*
	 * getter for the value of a piece at a certain location
	 * parameters: none
	 * returns: int piece value
	 */
	public int getPiece(int rowNum, int colNum){
		int pieceVal = gameBoard.getPiece(rowNum, colNum);
		return pieceVal;
	}
	/*
	 * getter for the number of rows of the game
	 * parameters: none
	 * returns: int number of rows
	 */
	public int getRows(){
		return gameBoard.getRows();
	}
	/*
	 * getter for the number of cols of the game
	 * parameters: none
	 * returns: int number of cols in GameBoard
	 */
	public int getCols(){
		return gameBoard.getCols();
	}
	/*
	 * getter for the genration number of the board
	 * parameters: none
	 * returns: int gen number
	 */
	public int getGenNum(){
		return genNumber;
	}
	/*
	 * converts the current state of the game to a string
	 * parameters: none
	 * returns: String boardString
	 */
	public String gameToString(){
		String boardString = gameBoard.toString();
		return boardString;
	}
	/*
	 * counts the number of live neighbors a cell has in a generation
	 * parameters: int row num, int col num
	 * returns: int num neighbors
	 */
	public int numNeighbors(int rowNum, int colNum){
		int numNeighbors = 0;

		for (int i = rowNum - 1; i <= rowNum + 1; i++){
			for(int j = colNum - 1; j <= colNum + 1; j++){
				if(i == rowNum && j == colNum)
					continue;
				if (gameBoard.isOccupied(i,j)){
					numNeighbors++;

				}
			}
		}
		return numNeighbors;
	}
	/*
	 * finds the next generation state of a cell (alive or dead) based on number of neighbors
	 * parameters: in row num, int col num
	 * returns: 1 if alive, 0 if dead, the current value if neither of the neighbor conditions are met, 1 if the cell was dead, but has exactly three neighbors
	 */
	public int nextState(int rowNum, int colNum){

		int oldVal = this.getPiece(rowNum,colNum);
		int numNeighbors = numNeighbors(rowNum, colNum);
		if (oldVal == 0 && numNeighbors == 3)
			return 1;
		else if(numNeighbors < 2)
			return 0;
		else if(numNeighbors >= 4)
			return 0;
		else return oldVal;
	}
	/*
	 * finds the next generation of the game and sets the board array to it
	 * also increments the gen number
	 * parameters: none
	 * returns: none
	 */
	public void nextGen(){
		int numRows = this.getRows();
		int numCols = this.getCols();
		GameBoard tempBoard = new GameBoard(numRows,numCols);
		for(int i = 0; i< numRows; i++){
			for(int j = 0; j < numCols; j++){
				tempBoard.setPiece(i, j, this.nextState(i, j));


			}
		}
		genNumber++;
		this.gameBoard = tempBoard;
	}
	/*
	 * randomizes the configuration of the board to dead and alive cells
	 * parameters: none
	 * returns: none
	 */
	public void randomize(){
		Random randCell = new Random();
		for(int i = 0; i< this.getRows(); i++){
			for(int j = 0; j< this.getCols(); j++){
				this.setCell(i, j, randCell.nextInt(2));
			}
		}
	}
	/*
	 * finds if a cell is alive by looking at its value
	 * parameters: int row num, int col num
	 * returns true if alive, false if dead
	 */
	public boolean isAlive(int rowNum, int colNum){
		return gameBoard.isOccupied(rowNum, colNum);
	}
	

}