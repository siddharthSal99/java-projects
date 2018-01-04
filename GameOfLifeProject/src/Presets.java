/*
 * Siddharth salunkhe
 * this class implements the action listener class. This creates the presets for buttons with various functions. There are preset configurations for the GameBoard
 * as well as functions to JButtons such as clearing and randomizing the board, and starting/stopping a timer and finding the next generation.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JButton;

public class Presets implements ActionListener {
	private GameOfLife game;
	private GameOfLifeComponent gameOfLife;
	private JButton btnNextGen;
	private JButton btnTimerStop;
	private JButton btnTimerResume;
	private JButton btnGliderPreset;
	private JButton btnClearPreset;
	private JButton btnRandomizePreset;
	private JButton btnAcornPreset;
	private JButton btnLongLine;
	private JButton btnExplosion;
	private Timer t;

/*
 * this constructor assigns references to all the preset buttons. 
 * Parameters:  Timer t,GameOfLife game, GameOfLifeComponent gameOfLife,JButton btnTimerStop, JButton btnTimerResume, 
 * 				JButton btnGliderPreset, JButton btnClearPreset, JButton btnRandomizePreset, 
 * 				JButton btnAcornPreset, JButton btnLongLine, JButton btnExplosion, JButton btnNextGen
 * 
 * 
 */
	public Presets(Timer t,GameOfLife game, GameOfLifeComponent gameOfLife,JButton btnTimerStop, JButton btnTimerResume, JButton btnGliderPreset, JButton btnClearPreset, JButton btnRandomizePreset, JButton btnAcornPreset, JButton btnLongLine, JButton btnExplosion, JButton btnNextGen){
		this.game = game;
		this.gameOfLife = gameOfLife;
		this.btnNextGen = btnNextGen;
		this.btnTimerStop = btnTimerStop;
		this.btnTimerResume = btnTimerResume;
		this.btnGliderPreset = btnGliderPreset;
		this.btnClearPreset = btnClearPreset;
		this.btnRandomizePreset = btnRandomizePreset;
		this.btnAcornPreset = btnAcornPreset;
		this.btnLongLine = btnLongLine;
		this.btnExplosion = btnExplosion;
		this.t = t;

	}
	/*
	 * This method has multiple parts and when a certain button action event calls this method the function that occurs is dependent on the JButton that adds the listener.
	 * Parameters: ActionEvent event
	 * returns: none
	 */
	public void actionPerformed(ActionEvent event){

		if(event.getSource() == btnTimerStop){
			t.stop();
		}
		else if(event.getSource() == btnTimerResume){
			t.start();
		}
		else if(event.getSource() == btnGliderPreset){

			gameOfLife.setCell(10, 10);
			gameOfLife.setCell(10, 11);
			gameOfLife.setCell(10, 12);
			gameOfLife.setCell(9, 12);
			gameOfLife.setCell(8, 11);

		}
		else if(event.getSource() == btnClearPreset){
			gameOfLife.clear();
		}
		else if(event.getSource() == btnRandomizePreset){
			gameOfLife.randomize();
			gameOfLife.repaint();
		}
		else if(event.getSource() == btnAcornPreset){
			gameOfLife.setCell(40, 40);
			gameOfLife.setCell(41, 40);
			gameOfLife.setCell(41, 38);
			gameOfLife.setCell(43, 39);
			gameOfLife.setCell(44, 40);
			gameOfLife.setCell(45, 40);
			gameOfLife.setCell(46, 40);
		}
		else if(event.getSource() == btnExplosion){
			gameOfLife.setCell(40, 40);
			gameOfLife.setCell(41, 41);
			gameOfLife.setCell(41, 39);
			gameOfLife.setCell(42, 39);
			gameOfLife.setCell(43, 40);
			gameOfLife.setCell(42, 40);
			gameOfLife.setCell(42, 41);

		}
		else if(event.getSource() == btnNextGen){
			game.nextGen();
			gameOfLife.repaint();
		}
		else if(event.getSource() == btnLongLine){
			for(int i = 20; i < 61; i++){
				gameOfLife.setCell(i, 40);
			}

		}


	}
}
