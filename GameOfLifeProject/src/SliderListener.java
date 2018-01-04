/*
 * this class implements the ChangeListener class as a listener for the slider to control the speed of the generation
 * 
 */
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
	private Timer t;
	/*
	 * this ctor accesses the timer so that is can be changed
	 */
	public SliderListener(Timer t){
		this.t = t;
		
	}
	/*
	 * The method accesses the timer in the graphics class and changes the delay based on the change in position of the slider dial
	 */
	public void stateChanged(ChangeEvent event){
		JSlider source = (JSlider)event.getSource();
		t.setDelay(source.getValue());
	}
}
