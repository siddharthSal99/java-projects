/*
 * This is the display class where the game is run from. It creates the initial states of a game of life and one can play because of all the presets and functions that
 * are joined in this class.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class GameOfLifeDisplay extends JFrame {
	private int width = 800;
	private int height = 800;


/*
 * the game is run from this main method
 * parameters: String[] args
 * returns: none
 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOfLifeDisplay frame = new GameOfLifeDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/*
 * This is the display part of the class that declares all the buttons and listeners, as well as creates a new game of life. The JFrame and all its components are created and added.
 * Parameters: none
 * 
 */
	public GameOfLifeDisplay() {
		
		//new JFrame and GameOfLife
		JFrame gameFrame = new JFrame();
		gameFrame.setSize(width,height);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameOfLife game = new GameOfLife(100,100);

		//new content pane and sets the layout to BorderLayout. also adds the GameOfLifeComponent
		gameFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		GameOfLifeComponent gameOfLife = new GameOfLifeComponent(game);
		gameFrame.getContentPane().add(gameOfLife);
		
		//adds the MouseMistener to the GameOfLifeComponent
		CellClickListener clickListener = new CellClickListener(game,gameOfLife);
		gameOfLife.addMouseListener(clickListener);
	
		//Declares all the JButtons
		JButton btnExplosion = new JButton ("Explosion");
		JButton btnTimerStop = new JButton ("Timer Stop");
		JButton btnLongLine = new JButton ("Long Line");
		JButton btnTimerResume = new JButton ("Timer Start");
		JButton btnGliderPreset = new JButton ("Glider");
		JButton btnClearPreset = new JButton ("Clear");
		JButton btnRandomizePreset = new JButton ("Randomize");
		JButton btnAcornPreset = new JButton ("Acorn");
		JButton btnNextGen = new JButton ("Next Gen");
		ActionListener listener2 = new NextGenListener(game, gameOfLife);
		
		//Creates the slider and the timer that controls the speed and the change from generation to generation. Also creates major ActionListener with all the preset functions
		JSlider speed = new JSlider(20,300);
		speed.setInverted(true);
		Timer t = new Timer(speed.getValue(), listener2);
		speed.addChangeListener( new SliderListener(t));
		ActionListener listener = new Presets(t, game,  gameOfLife, btnTimerStop,  btnTimerResume,  btnGliderPreset, btnClearPreset,  btnRandomizePreset,  btnAcornPreset,  btnLongLine,  btnExplosion, btnNextGen);
		
		//labels for the slider
		Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
		labels.put(300, new JLabel("Slow") );
		labels.put( 20 , new JLabel("Fast") );
		speed.setLabelTable( labels );
		speed.setPaintLabels(true);
		
		// assigns the buttons the same action listener since all the functoins are in the same presets class
		btnExplosion.addActionListener(listener);
		btnNextGen.addActionListener(listener);
		btnTimerStop.addActionListener(listener);
		btnTimerResume.addActionListener(listener);
		btnGliderPreset.addActionListener(listener);
		btnClearPreset.addActionListener(listener);
		btnRandomizePreset.addActionListener(listener);
		btnAcornPreset.addActionListener(listener);
		btnLongLine.addActionListener(listener);
		
		//creates a JPanel for the buttons that control generation stepping
		JPanel topPanel = new JPanel();
	    topPanel.add(btnNextGen);
	    topPanel.add(btnTimerStop);
	    topPanel.add(btnTimerResume);
	    topPanel.add(speed);
	   
	    //creates a panel for all the preset configurations of the GameOfLife
	    JPanel presets = new JPanel();
	    presets.add(btnGliderPreset);
	    presets.add(btnClearPreset);
	    presets.add(btnRandomizePreset);
	    presets.add(btnAcornPreset);
	    presets.add(btnLongLine);
	    presets.add(btnExplosion);

	    //Adds the GameOfLifeComponent to the content pane, adds the JPanels to the same pane, and sets the makes it visible on the JFrame
	    gameFrame.getContentPane().add(gameOfLife);
	    gameFrame.getContentPane().add(topPanel, BorderLayout.NORTH);
	    gameFrame.getContentPane().add(presets, BorderLayout.SOUTH);
		gameFrame.setVisible(true);
		
		
	
		
	}

}
