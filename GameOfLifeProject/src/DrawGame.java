/*
 * This class contains the drawing instructions for the game of life. cells are filled in while the board is a darker base color.
 * It also prints the generation number in the bottom right corner.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DrawGame {
	private GameOfLife game;
	private int width;
	private int height;
	/*
	 * constructor accepts the three data fields 
	 * parameters: GameOfLife game, int frameHeight, int frameWidth
	 */
	public DrawGame(GameOfLife game, int frameHeight, int frameWidth){
		this.game = game;
		this.height = frameHeight;
		this.width = frameWidth;
	}
	/*
	 * These are the actual drawing instructions using graphics
	 * parameters: Graphics2D g2
	 * returns: none
	 */
	public void draw(Graphics2D g2){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(game.isAlive(i, j)){
					g2.setColor(Color.magenta);
					g2.fillRect(10 * j, 10 * i, 10, 10);
				}
				else{
					g2.setColor(Color.DARK_GRAY);
					g2.fillRect(10 * j, 10 * i, 10, 10);
				}
			}
		}
		for(int i = 0; i < width; i+= 10){
			for(int j = 0; j < height; j+= 10){
				
				g2.setColor(Color.black);
				g2.drawRect(i, j, 10, 10);
			}
		}	
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("SansSerif",Font.PLAIN, 20));
		g2.drawString("Generation Number: " + game.getGenNum(), 30, height - 20);
		
		
	}
}