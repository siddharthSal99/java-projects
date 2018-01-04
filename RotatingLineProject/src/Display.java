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

/*Tharun Sankar, Alan Chai, $iddharth $alunkhe
 * March 2016
 * 
 * Display.java
 * 
 * Sets up interface for frame and panels to visualize
 * rotating Lines, Polygons, and Prisms, and to control
 * specific aspects of the visualizations.
 */
public class Display extends JFrame {
	
	/*
	 * Displays a frame showing a rotating line, polygon, or prism
	 */
	public static void main(String[] args){

		//create the frame and set the dimensions
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setMinimumSize(new Dimension(800,800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//create a Line and LineComponent from the line
		int length = 0;
		if(frame.getWidth() > frame.getHeight()) 
			length = frame.getWidth() * 2;
		else
			length = frame.getHeight() * 2;
		Line line = new Line(length);
		LineComponent lComp = new LineComponent(line, Color.yellow);
;
		//create a Prism and a PrismComponent with the prism
		Prism prism = new Prism(150,6);
		PrismComponent prismComp = new PrismComponent(prism, Color.yellow);

		//create a Polygon and a PolygonComponent with the polygon
		Polygon polygon = new Polygon(150,6,0);
		PolygonComponent polyComp = new PolygonComponent(polygon,Color.yellow);

		
		//Speed slider changes the speed of rotation
		JSlider speed = new JSlider(1,100);
		speed.setInverted(false);
		Timer t = new Timer(speed.getValue(), new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(speed.getValue() < 50){
					line.rotate(-0.01);
					polygon.rotate(-0.01);
					prism.rotate(-0.01);

				}
				else{
					line.rotate(0.01);	
					polygon.rotate(0.01);
					prism.rotate(0.01);
				}
				
				lComp.repaint();
				polyComp.repaint();
				prismComp.repaint();

			}
		});
		speed.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent event){
				JSlider source = (JSlider)event.getSource();
				if(speed.getValue() > 50)
					t.setDelay(101 - source.getValue());
				
				else
					t.setDelay(source.getValue());

			}

		});
		
		//add direction labels to the speed slider
		Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
		labels.put(1, new JLabel("Left") );
		labels.put( 100 , new JLabel("Right") );
		speed.setLabelTable( labels );
		speed.setPaintLabels(true);
		
		
		//Slider to change Shape
		JSlider shape = new JSlider(2,18);
		shape.setInverted(false);
		shape.setValue(2);
		shape.setPreferredSize(new Dimension(500,50));
		shape.addChangeListener(new ChangeListener(){
	
			public void stateChanged(ChangeEvent event){
				JSlider source = (JSlider)event.getSource();
				if(source.getValue() == 2){
					polyComp.setVisible(false);
					prismComp.setVisible(false);
					frame.getContentPane().add(lComp, BorderLayout.CENTER);
					lComp.setVisible(true);
					lComp.repaint();						
				}
				else if(source.getValue() > 2 && source.getValue() < 11) {
					prismComp.setVisible(false);
					lComp.setVisible(false);
					polygon.setNumSides(source.getValue());
					frame.getContentPane().add(polyComp, BorderLayout.CENTER);
					polyComp.setVisible(true);
					polyComp.repaint();
				}
				else{
					polyComp.setVisible(false);
					lComp.setVisible(false);
					prism.setFaceSides(source.getValue() - 8);
					frame.getContentPane().add(prismComp, BorderLayout.CENTER);
					prismComp.setVisible(true);
					prismComp.repaint();
					}

			}

		});

		//add number of sides and 3D labels to the shape slider
		Hashtable<Integer, JLabel> numSides = new Hashtable<Integer, JLabel>();
		numSides.put(2, new JLabel("2") );
		numSides.put(3, new JLabel("3") );
		numSides.put(4, new JLabel("4") );
		numSides.put(5, new JLabel("5") );
		numSides.put(6, new JLabel("6") );
		numSides.put(7, new JLabel("7") );
		numSides.put(8, new JLabel("8") );
		numSides.put(9, new JLabel("9") );
		numSides.put(10, new JLabel("10") );
		numSides.put(11, new JLabel("3P") );
		numSides.put(12, new JLabel("4P") );
		numSides.put(13, new JLabel("5P") );
		numSides.put(14, new JLabel("6P") );
		numSides.put(15, new JLabel("7P") );
		numSides.put(16, new JLabel("8P") );
		numSides.put(17, new JLabel("9P") );
		numSides.put(18, new JLabel("10P") );

		shape.setLabelTable( numSides );
		shape.setPaintLabels(true);


		//Slider to change color
				JSlider color = new JSlider(1,5);
				color.setInverted(false);
				color.setValue(1);
				color.addChangeListener(new ChangeListener(){

					public void stateChanged(ChangeEvent event){
						JSlider source = (JSlider)event.getSource();
						if(source.getValue() == 1){
							lComp.setColor(Color.yellow);
							polyComp.setColor(Color.yellow);
							prismComp.setColor(Color.yellow);
							lComp.repaint();
							polyComp.repaint();
							prismComp.repaint();
						}
						if(source.getValue() == 2){
							lComp.setColor(Color.magenta);
							polyComp.setColor(Color.magenta);
							prismComp.setColor(Color.magenta);
							lComp.repaint();
							polyComp.repaint();
							prismComp.repaint();
						}
						if(source.getValue() == 3){
							lComp.setColor(Color.green);
							polyComp.setColor(Color.green);
							prismComp.setColor(Color.green);
							lComp.repaint();
							polyComp.repaint();
							prismComp.repaint();
						}
						if(source.getValue() == 4){
							lComp.setColor(Color.red);
							polyComp.setColor(Color.red);
							prismComp.setColor(Color.red);
							lComp.repaint();
							polyComp.repaint();
							prismComp.repaint();
						}
						if(source.getValue() == 5){
							lComp.setColor(Color.white);
							polyComp.setColor(Color.white);
							prismComp.setColor(Color.white);
							lComp.repaint();
							polyComp.repaint();
							prismComp.repaint();
						}
					}

				});
				
				//add color labels to the color slider
				Hashtable<Integer, JLabel> colorScheme = new Hashtable<Integer, JLabel>();
				colorScheme.put(1, new JLabel("yellow") );
				colorScheme.put(2, new JLabel("pink") );
				colorScheme.put(3, new JLabel("green") );
				colorScheme.put(4, new JLabel("red") );
				colorScheme.put(5, new JLabel("white") );
				color.setLabelTable( colorScheme );
				color.setPaintLabels(true);


		//Start rotation button
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				t.start();
			}	
		});
		//Stop rotation button
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				t.stop();
			}	
		});


		//Setting up the frame with the components, panels and buttons
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.black);


		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnStart);
		buttonPanel.add(speed);
		buttonPanel.add(btnStop);
		buttonPanel.add(color);
		
		//This second button panel needs to be separate because the JSlider is larger
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.add(shape);
		
		
		frame.getContentPane().add(lComp, BorderLayout.CENTER);
		prismComp.setVisible(false);
		polyComp.setVisible(false);
		lComp.setVisible(true);
		
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(buttonPanel2, BorderLayout.NORTH);
		frame.setVisible(true);

	}


}
