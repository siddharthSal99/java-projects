/*
 * This class is designed to test the validity of the projectile motion formula. It takes an initial velocity, gravitational acceleration and time interval to recalculate velocity,
 * position, velocity and time. It then compares the simulated projectile motion values with the formula values at certain times, and prints them every second. A negative value for 
 * gravitational acceleration and initial velocity is ignored and changed to positive. The motion of the projectile follows the parabolic path and will print values as position is
 * greater than zero, as well as the instant position dips below zero to indicate when the projectile hits the ground.
 */
import java.util.Scanner;

public class ProjectileMotion {
	
	private static Scanner input = new Scanner(System.in);
/*
 * This method uses helper methods to gain input from the user as to their specified gravitational acceleration and their time interval. It then runs the simulation, printing
 * the updated velocity, position, and formula position, and time after every one second.
 * 
 * parameters: double, initial Velocity
 * returns: none
 * output: prints a table of values of the simulated projectile motion.
 */
	public static void simulation(double initialVelocity){

		final double INITIALPOSITION = 0;
		double initialVel = ProjectileMotion.checkVelocity(initialVelocity);
		double deltaT = ProjectileMotion.checkDeltaT();
		double gravAccel = ProjectileMotion.checkGravity();
		double velocity = initialVel;
		double position = INITIALPOSITION;
		double formulaPosition = INITIALPOSITION;
		double time = 0;
		int i = 0;

		input.close();
		System.out.printf("%12s | %12s | %12s | %12s | %n", "Velocity", "Position", "Formula Position", "Time");
		
		do{

			if (i % (1/deltaT) == 0)
				System.out.printf("%12.4f | %12.4f | %16.4f | %12.4f | %n", velocity, position, formulaPosition, time);
			
			velocity = velocity - gravAccel * deltaT;
			formulaPosition = ProjectileMotion.formulaMotion(time, initialVel);
			position = position + velocity * deltaT;
			time += deltaT;
			i++;
		}
		while(position >= 0);
		System.out.printf("%12.4f | %12.4f | %16.4f | %12.4f | %n", velocity, position, formulaPosition, time);
	}

/*
 * This method uses the accepted formula for projectile motion and returns a position based on the given parameters
 * 
 * parameters: double time, and double initial velocity
 * returns: double new position
 */
	private static double formulaMotion(double time, double initialVelocity){
		double formulaPosition = -0.5 * 9.8 * time * time + initialVelocity * time;
		return formulaPosition;

	}


/*
 * This method is a helper method to gain input for the gravitational acceleration of the simulation. The method checks if the acceleration is positive or negative and changes it 
 * accordingly to positive. The program will also not accept a gravitational acceleration of 0.
 * 
 * parameters: none
 * returns: double gravitational acceleration
 */
	private static double checkGravity(){
		double gravAccel;
		while (true){
			
			System.out.println("please enter a non-zero gravitiational acceleration");
			gravAccel = input.nextDouble();
			if(gravAccel == 0)
				System.out.println("invalid gravitational acceleration");
			else
				break;
		}
		
		if (gravAccel < 0)
			return -gravAccel;
		else 
			return gravAccel;
	}

	/*
	 * This method is a helper method to gain input for the time interval of the simulation. . The program will also not accept a time interval of <= 0. It will continue to prompt the 
	 * user until the appropriate input is received.
	 * 
	 * parameters: none
	 * returns: double deltaT
	 */
	private static double checkDeltaT(){
		double deltaT;
		while (true){

			System.out.println("please enter a small positive Time Interval ");
			deltaT = input.nextDouble();
			
			if(deltaT <= 0)
				System.out.println("invalid Time Interval");
			else
				return deltaT;
		}
		
	}
	/*
	 * This method is a helper method to gain input for the velocity of the simulation. The program will also not accept a velocity of 0. All negative initial velocities will be changed
	 * to positive.
	 * It will continue to prompt the user until the appropriate input is received.
	 * 
	 * parameters: initial velocity
	 * returns: double initial velocity (modified)
	 */
	private static double checkVelocity(double initialVelocity){

		while (initialVelocity == 0){

			System.out.println(initialVelocity + " is an invalid initial velocity");
			System.out.println("please enter a new non-zero initial velocity");
			initialVelocity = input.nextDouble();

		}
		
		if (initialVelocity < 0)
			return -initialVelocity;
		else
			return initialVelocity;
	}
	
	public static void main(String [] args){
		ProjectileMotion.simulation(20);

	}

}