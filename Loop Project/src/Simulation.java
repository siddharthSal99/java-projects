/*

 * This class demonstrates the variety of ways to use loops and the different situations

 * that are appropriate for the different types of loops. The loops that are demonstrated

 * in this class are while, do-while, and while loops. 

 * 

 * In the first part of this class, several methods are used to calculate the factorial of

 * a number. A factorial is defined as a number consistently being multiplying 1 less than the 

 * number until it is multiplied by 1. Several methods were constructed so that negative

 * numbers will not be accepted and if an input of 0 is entered, 1 will be given as an

 * output. Also methods were created so the user may keep entering new numbers to find

 * their factorial.

 * 

 * In the second part of this class, several methods are used to find the areas of rectangles.

 * The area of a rectangle is found by multiplying the length and the width of the rectangle.

 * The output is formated into a table to show 3 columns:one for the width, one for the length

 * and one for the width.Methods were created so that negative lengths and widths will not be taken. 

 * Methods were also created so the user may pick new lengths if they want to.

 * 

 * In the final part of the class, several methods were used to simulate the flight of a projectile.

 * The projectile is modeled by a quadratic equation formula. The simulation breaks up the quadratic equation

 * into two different equations. The simulation prints its value every .01 seconds while the formula

 * will print the value every 1 second. The goal is to use the simulation to prove the formula that 

 * the simulation is trying to model.

 */

import java.math.*;

import java.util.Scanner;

public class Simulation {

static Scanner userinput = new Scanner(System.in);

static BigInteger number;

static int length;

static int length1;

static int width;

static int width1;

static double s;

static double s1;

static double v;



/*

* Allows the 

*/

public static void userInput(){

boolean a = false;

BigInteger bi = new BigInteger("0"); 

while (!a){

System.out.println("Pick a positive number to find its factorial");

number = userinput.nextBigInteger(); 

if (number.compareTo(bi) == -1){

a = false;

}

if ((number.compareTo(bi) == 1) || (number.compareTo(bi) == 0)){

a = true;

}

}

}


public static BigInteger findFactorial(){

BigInteger factorial = number;

BigInteger bi1 = new BigInteger("1");

while (number.compareTo(bi1) == 1){

factorial = factorial.multiply(number.subtract(bi1));

number = number.subtract(bi1);

}

System.out.println(factorial);

return factorial;

}



public static void findNewFactorial(){

boolean a = true; 

do{

String str;

System.out.println("Do you want to pick another number"); 

str = userinput.nextLine();

if (str.equalsIgnoreCase("y")){

userInput();

findFactorial(); 

}

else if (str.equalsIgnoreCase("n")){

System.out.println("Good bye!");

a = false;

}

} while(a); 



}


public static int area(int length, int width){

int area = length*width;

return area;

}


public static void rectangleUserInput(){

boolean a = false;

while(!a){

System.out.println("Enter 4 positive numbers to find a list areas of rectangles");

length = userinput.nextInt();

length1 = userinput.nextInt();

width = userinput.nextInt();

width1 = userinput.nextInt();

if (length < 0 || length1 < 0 || width < 0 || width1 < 0){

a = false;

}

else if (length > 0 && length1 > 0 && width > 0 && width1 > 0){

a = true;

}

}

}



public static void findAreasofRectangles(){

int i = length;

System.out.print("Width");

System.out.print("     Length    ");

System.out.println("   Area   ");

for (; width <= width1; width++ ){

for(; length <= length1; length++){

System.out.print(width);

System.out.print("          " +   length);

System.out.println("        " + area(length,width));

}

length = i;

}

}

public static void findNewAreas(){

boolean a = true; 

do{

String str;

System.out.println("Do you want to find new areas?"); 

str = userinput.nextLine();

if (str.equalsIgnoreCase("y")){

rectangleUserInput();

findAreasofRectangles(); 

}

else if (str.equalsIgnoreCase("n")){

System.out.println("Good bye!");

a = false;

}

} while(a); 

}

public static double simulationInput(){

boolean a = false;

while(!a){

System.out.println("Enter a velocity to find its position");

v = userinput.nextDouble();

if ( v >= 0){

a = true;

}

if (v < 0){

a = false;

}

}

return v;

}

public static void simulation(double initialVelocity){

double deltaT = .01;

double g = 9.8;

double v = initialVelocity;

int i = 0;

double time = 0;

double s1 = 0;

System.out.println("Time                Simulation Value             Formula Value");

for (; s1 >= 0 ; i++){

Simulation.formula(time , v);

time+=deltaT;

v = v - 9.8*deltaT;

s1 = s1 + v*deltaT;

if (i%100 == 0){

System.out.println(time + "              "+ s1 + "             "+ Simulation.formula(time, initialVelocity));

}

}

}


public static double formula(double time, double initialVelocity){

double s = -0.5*9.8*time*time + v*time;

return s;

}


public static void simulationReplay(){

boolean a = true; 

do{

String str;

System.out.println("Do you want pick another velocity"); 

str = userinput.nextLine();

if (str.equalsIgnoreCase("y")){

simulationInput();

simulation(v); 

}

else if (str.equalsIgnoreCase("n")){

System.out.println("Good bye!");

a = false;

}

} while(a); 

}



public static void main(String[] args) {

BigInteger val = new BigInteger("0");

userInput(); 

if (number.compareTo(val) == 0){

System.out.println("The factorial is 1");

}

else{

findFactorial();

}

findNewFactorial();


rectangleUserInput();


findAreasofRectangles();


findNewAreas();


double v = simulationInput();


simulation(v);


simulationReplay();



}



}
///*
// * This class demonstrates the variety of ways to use loops and the different situations
// * that are appropriate for the different types of loops. The loops that are demonstrated
// * in this class are while, do-while, and while loops. 
// * 
// * In the first part of this class, several methods are used to calculate the factorial of
// * a number. A factorial is defined as a number consistently being multiplying 1 less than the 
// * number until it is multiplied by 1. Several methods were constructed so that negative
// * numbers will not be accepted and if an input of 0 is entered, 1 will be given as an
// * output. Also methods were created so the user may keep entering new numbers to find
// * their factorial.
// * 
// * In the second part of this class, several methods are used to find the areas of rectangles.
// * The area of a rectangle is found by multiplying the length and the width of the rectangle.
// * The output is formated into a table to show 3 columns:one for the width, one for the length
// * and one for the width.Methods were created so that negative lengths and widths will not be taken. 
// * Methods were also created so the user may pick new lengths if they want to.
// * 
// * In the final part of the class, several methods were used to simulate the flight of a projectile.
// * The projectile is modeled by a quadratic equation formula. The simulation breaks up the quadratic equation
// * into two different equations. The simulation prints its value every .01 seconds while the formula
// * will print the value every 1 second. The goal is to use the simulation to prove the formula that 
// * the simulation is trying to model.
// */
//import java.math.*;
//import java.util.Scanner;
//public class Simulation {
//	static Scanner userinput = new Scanner(System.in);	
//	static BigInteger number;
//	static int length;
//	static int length1;
//	static int width;
//	static int width1;
//	static double s;
//	static double s1;
//	static double v;
//
//	/*
//	 * Allows the 
//	 */
//	public static void userInput(){
//		boolean a = false;
//		BigInteger bi = new BigInteger("0"); 
//		while (!a){
//		System.out.println("Pick a positive number to find its factorial");
//		number = userinput.nextBigInteger(); 
//		if (number.compareTo(bi) == -1){
//			a = false;
//			}
//		if ((number.compareTo(bi) == 1) || (number.compareTo(bi) == 0)){
//			a = true;
//			}
//		}
//	}
//	
//	public static BigInteger findFactorial(){
//			BigInteger factorial = number;
//			BigInteger bi1 = new BigInteger("1");
//			while (number.compareTo(bi1) == 1){
//				factorial = factorial.multiply(number.subtract(bi1));
//				number = number.subtract(bi1);
//			}
//			System.out.println(factorial);
//			return factorial;	
//	}
//
//	public static void findNewFactorial(){
//		boolean a = true; 
//		do{
//			String str;
//			System.out.println("Do you want to pick another number"); 
//			str = userinput.nextLine();
//			if (str.equalsIgnoreCase("y")){	
//				userInput();
//				findFactorial(); 
//			}
//			else if (str.equalsIgnoreCase("n")){
//				System.out.println("Good bye!");
//			a = false;
//			}
//		} while(a); 
//
//	}
//	
//	public static int area(int length, int width){
//		int area = length*width;
//		return area;	
//	}
//	
//	public static void rectangleUserInput(){
//		boolean a = false;
//		while(!a){
//			System.out.println("Enter 4 positive numbers to find a list areas of rectangles");
//			length = userinput.nextInt();
//			length1 = userinput.nextInt();
//			width = userinput.nextInt();
//			width1 = userinput.nextInt();
//			if (length < 0 || length1 < 0 || width < 0 || width1 < 0){
//				a = false;
//			}	
//			else if (length > 0 && length1 > 0 && width > 0 && width1 > 0){
//				a = true;
//				}
//		}
//	}
//
//	public static void findAreasofRectangles(){
//		int i = length;
//		 System.out.print("Width");
//			System.out.print("     Length    ");
//			System.out.println("   Area   ");
//		 for (; width <= width1; width++ ){
//			for(; length <= length1; length++){
//				System.out.print(width);
//				System.out.print("          " +   length);
//				System.out.println("        " + area(length,width));
//			}
//			length = i;
//		 }
//	}	
//	public static void findNewAreas(){
//		boolean a = true; 
//		do{
//			String str;
//			System.out.println("Do you want to find new areas?"); 
//			str = userinput.nextLine();
//			if (str.equalsIgnoreCase("y")){	
//				rectangleUserInput();
//				findAreasofRectangles(); 
//			}
//			else if (str.equalsIgnoreCase("n")){
//				System.out.println("Good bye!");
//			a = false;
//			}
//		} while(a); 	
//	}
//	public static double simulationInput(){
//		boolean a = false;
//		while(!a){
//			System.out.println("Enter a velocity to find its position");
//			v = userinput.nextDouble();
//			if ( v >= 0){
//				a = true;
//			}
//				if (v < 0){
//					a = false;
//				}
//		}
//		return v;
//	}
//	public static void simulation(double initialVelocity){
//		double deltaT = .01;
//		double g = 9.8;
//		double v = initialVelocity;
//		int i = 0;
//		double time = 0;
//		double s1 = 0;
//		System.out.println("Time                Simulation Value             Formula Value");
//			for (; s1 >= 0 ; i++){
//			Simulation.formula(time , v);	
//			time+=deltaT;
//			v = v - 9.8*deltaT;
//			s1 = s1 + v*deltaT;
//			if (i%100 == 0){
//				System.out.println(time + "              "+ s1 + "             "+ Simulation.formula(time, initialVelocity));
//			}
//		}
//	}
//	
//	public static double formula(double time, double initialVelocity){
//		double s = -0.5*9.8*time*time + v*time;
//		return s;
//	}
//	
//	public static void simulationReplay(){
//		boolean a = true; 
//		do{
//			String str;
//			System.out.println("Do you want pick another velocity"); 
//			str = userinput.nextLine();
//			if (str.equalsIgnoreCase("y")){	
//				simulationInput();
//				simulation(v); 
//			}
//			else if (str.equalsIgnoreCase("n")){
//				System.out.println("Good bye!");
//			a = false;
//			}
//		} while(a); 	
//	}
//		
//	
//	public static void main(String[] args) {
//		BigInteger val = new BigInteger("0");
//		userInput(); 
//		if (number.compareTo(val) == 0){
//			System.out.println("The factorial is 1");
//		}
//		else{
//			findFactorial();
//		}
//		findNewFactorial();
//		
//		rectangleUserInput();
//		
//		findAreasofRectangles();
//		
//		findNewAreas();
//		
//		double v = simulationInput();
//		
//		simulation(v);
//		
//		simulationReplay();
//		
//		
//	}
//
//}


/*
public class Simulation {
static double deltaT = 0.01;
final static double g = 9.81;
public static void simulation(double initialV){
	final double initialS = 0;	
	double formulaS;
	//double sf; You don't really need this variable
	double v = initialV;
	//double g = 9.81; You don't really need this variable
	double s = initialS;
	double velocity = v;
	int i = 0;
	double deltaT = 0.01; 
	System.out.println("Time                   Simulation Value             Formula Value");
	for(;s>=0; deltaT += .01){
		velocity = Simulation.updateV(velocity);
		formulaS = Simulation.formula(deltaT,v);
		s = Simulation.updateS(s, velocity);
		deltaT += .01;
		
		if (i % 100 == 0){ //the number is 100 because 1/deltaT == 100, and you want to print every second...
			System.out.println(deltaT +"      " + s + "      " + formulaS + "      " + velocity);
		}
		i++;
	}
}

private static double updateV(double velocity){
	double newV = velocity - g * deltaT;
	return newV;
}
private static double updateS(double s, double velocity){
	double newS = s + velocity * deltaT;
	return newS;
}
private static double formula(double time, double initialVelocity){
	//double deltaT = time;  You're not really using this variable
	double formulaValue = -0.5 * 9.81 * time * time + initialVelocity * time;
	return formulaValue;
}
public static void main(String[] args) {
	simulation(20);
}
}
*/