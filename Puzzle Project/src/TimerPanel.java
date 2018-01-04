import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerPanel extends JPanel {

	private JLabel text;
	private JButton startTimer;
	private Timer timer = new Timer(100, null);
	private JLabel timeDisplay;
	private String displayTime = "0.0";
	private ActionListener timerListener;

	public TimerPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 0));
		this.setSize(850,100);
		this.setLocation(0,600);
		
		text = new JLabel("Want to time yourself?");
		text.setFont(new Font("Serif", Font.BOLD, 25));
		

		startTimer = new JButton("Start Timer");
		startTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long timestamp = new java.util.Date().getTime();
				
				if (timer.isRunning()) {
					return;
				}
				
				try {
					timer.removeActionListener(timerListener);
				} catch (NullPointerException n) {}
				
				timerListener = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						long timerTime = e.getWhen();
						long totalTime = (timerTime - timestamp) / 100;
						long seconds = totalTime / 10;
						long decimal = totalTime % 10;
						displayTime = "" + seconds + "." + decimal;

						timeDisplay.setText(displayTime);
					}
				};
				
				timer.addActionListener(timerListener);
				timer.start();
				text.setVisible(false);
				
				
			}

		});


		timeDisplay = new JLabel();
		timeDisplay.setText("0.0");
		timeDisplay.setFont(new Font("Serif", Font.BOLD, 50));


		this.add(text);
		this.add(startTimer);
		this.add(timeDisplay);
		this.setVisible(true);
	}


	public String stopTimer() {
		String time = displayTime;
		resetTimer();
		return time;
	}

	public void resetTimer() {
		text.setVisible(true);
		timer.stop();
		timeDisplay.setText("0.0");
		displayTime = "0.0";
	}

	public boolean isRunning() {
		return timer.isRunning();
	}
	
	public void updateVisible(boolean b) {
		Display.isTimerVisible = b;
		this.setVisible(b);
	}

}
