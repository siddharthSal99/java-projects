
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NextGenListener implements ActionListener {
	private GameOfLife game;
	private GameOfLifeComponent gameOfLife;
	
	public NextGenListener(GameOfLife game, GameOfLifeComponent gameOfLife){
		this.game = game;
		this.gameOfLife = gameOfLife;
	}
public void actionPerformed(ActionEvent event){
		game.nextGen();
		 new GameOfLifeComponent(game);
		gameOfLife.repaint();

	}
}