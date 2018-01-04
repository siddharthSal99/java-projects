/*
 * This class implements the Mouse Listener class to add the function that a left mouse click can set a cell to alive or dead.
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellClickListener implements MouseListener {
	private GameOfLifeComponent gameOfLife;
	/*
	 * this method needs to access the game of life component as it needs to set the value at certain locations on the GameBoard
	 * parameters: GameOfLife game, GameOfLife
	 */
	public CellClickListener(GameOfLife game, GameOfLifeComponent gameOflife){
		this.gameOfLife  = gameOflife;
	}
	
	/*
	 * This method recognizes where a mouse click occurs and changes the state of the cell from dead to alive or alive to dead
	 * parameters: MouseEvent event
	 * returns: none
	 */
	public void mouseClicked(MouseEvent event){
		int x = event.getX() / 10;
		int y = event.getY() / 10;

		gameOfLife.setCell(x,y);
		
	}
	//Do-nothing methods need to be implemented
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent event){}
	
}
