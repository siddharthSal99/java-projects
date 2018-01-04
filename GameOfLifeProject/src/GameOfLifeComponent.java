/*
 * Siddharth Salunkhe
 * This class contains the paint instructions for the GameOfLife component. This extends the JComponenet class, and can now be added to JFrames, etc.
 */
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameOfLifeComponent extends JComponent {
	private GameOfLife game;
	private int frameHeight;
	private int frameWidth;
	/*
	 * This ctor creates a game of life component from a game of life object. 
	 * parameters: GameOfLife game
	 */
	public GameOfLifeComponent(GameOfLife game){
		this.game = game;
	}
	/*
	 * This method calls the DrawGame method to draw the game of life
	 * Parameters: Graphics g
	 * return: none
	 */
	public void paintComponent(Graphics g){
		this.frameHeight = getHeight();
		this.frameWidth = getWidth();
		Graphics2D g2 = (Graphics2D) g;
		DrawGame game1 = new DrawGame(game, frameHeight, frameWidth);
		game1.draw(g2);
		
	}
	/*
	 * This method sets a cell to Alive or dead depending on whether the cell was alive or dead previously (it changes it from dead to alive or vice versa) and repaints it.
	 * Parameters: int x, int y (location of the cell)
	 * returns: none
	 */
	public void setCell(int x, int y) {

		if(game.isAlive(y, x))
			game.setCell(y, x, 0);
		else
			game.setCell(y, x, 1);
		
		repaint();
	}
	/*
	 * This method randomizes the configuration of the board and repaints it
	 * Parameters: none
	 * returns: none
	 */
	public void randomize(){
		game.randomize();
		repaint();
	}
	/*
	 * This method clears the board and repaints it
	 * Parameters: none
	 * returns: none
	 */
	public void clear(){
		for(int i = 0; i < game.getRows(); i++){
			for(int j = 0; j < game.getCols(); j++){
				game.setCell(i, j, 0);
			}
		}
		repaint();
	}
		
}
