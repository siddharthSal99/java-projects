import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class Display {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setMinimumSize(new Dimension(500,500));
		
		ThreeDPolygon polygon = new ThreeDPolygon(150,6);
		ThreeDPolygonComponent polyComp = new ThreeDPolygonComponent(frame.getHeight(),frame.getWidth(),polygon,Color.yellow);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				polygon.rotate(0.01);
				polyComp.repaint();
			}	
		});
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.black);
		frame.add(btnStart,BorderLayout.SOUTH);
		frame.getContentPane().add(polyComp, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
