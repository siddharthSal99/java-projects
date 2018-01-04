/*
 * This class finds the factorial of an input value. Using the BigInteger class, this class can calculate very large factorial numbers. Since a factorialized number cannot be negative, 
 * all negative numbers are treated as positive. The program will continue to ask you if you would like to enter another number to factorialize, and will terminate after the user 
 * tells the program not to accept any more factorials.
 * 
 * This class is also designed to test the validity of the projectile motion formula. It takes an initial velocity, gravitational acceleration and time interval to recalculate velocity,
 * position, velocity and time. It then compares the simulated projectile motion values with the formula values at certain times, and prints them every second. A negative value for 
 * gravitational acceleration and initial velocity is ignored and changed to positive. The motion of the projectile follows the parabolic path and will print values as position is
 * greater than zero, as well as the instant position dips below zero to indicate when the projectile hits the ground.
 * 
 * This Class also prints out a table of values. One column for the length of the rectangle, one column for the width, and one column for the calculated area.
 * The class prompts you for a minimum and maximum length and width. should they be put out of order, (ie the min and max width are switched), then the class will automatically switch
 * them to the right order. the values printed range from the minimum dimension to the maximum dimension, calculating the area of the range of values.
 *  All negative values will be treated as positives. This Class only works for integer values for side lengths.
 */
import java.util.Scanner;
import java.math.BigInteger;

public class LoopExamples {
	private static Scanner input = new Scanner(System.in);
	
	/* 
	 * This method prompts the user for a long integer to factorialize. If the input number is negative, it changes the number to its positive counterpart.
	 * it calls the compute factorial method to calculate the factorial, and then prints it. The condition of the while loop is the return value of the anotherFactorial() method.
	 * As long as it is true, the method will repeat and ask for another number to factorialize.
	 * 
	 * parameters: none
	 * returns: none
	 * output: prints the factorial of the input long integer.
	 */

	public static void factorial(){
		
		do{

			System.out.println("Please enter a non-negative integer to factorialize");
			System.out.println("all negative integers will be treated as their positive counterparts");
			long value = input.nextLong();	

			if (value < 0)
				System.out.println(computeFactorial(-value));

			else 
				System.out.println(computeFactorial(value));

		}
		while(anotherFactorial());
		
	}

	/*
	 * This method calculates the factorial of an input long integer. Using the BigInteger class, it calculates and returns the value of the factorial.
	 * 
	 * parameters: long value, prompted in the factorial() method.
	 * returns: BigInteger factorial result.
	 */
	private static BigInteger computeFactorial(long value){
		BigInteger bigValue = new BigInteger("" + value);
		BigInteger result = new BigInteger("1");
		int i = 1;
		if (value == 0)
			return BigInteger.ONE;
		else{
			while (i < value){
				result = new BigInteger( "" + bigValue.multiply(result));
				bigValue = new BigInteger("" + bigValue.subtract(BigInteger.ONE));
				i++;
			}
			return result;
		}
	}
	/*
	 * This method prompts the user if they would like to enter another factorial. This is used as a condition for the while loop in the factorial() method to repeat the loop.
	 * 
	 *  parameters: none
	 *  returns: boolean, if the user would like to enter another factorial, then the method returns true.
	 */
	private static boolean anotherFactorial(){

		Scanner input = new Scanner(System.in);
		String answer;
		while (true){
			System.out.println("would you like to find another factorial? \n please enter y or n" );
			answer = input.nextLine();
			if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")){
				break;
			}
			else{
				System.out.println("invalid response, please enter y or n");
			}
			
		}
		if (answer.equalsIgnoreCase("y")){
			return true;
		}
		else
			return false;
	}


	
	/*
	 * This method uses helper methods to gain input from the user as to their specified gravitational acceleration and their time interval. It then runs the simulation, printing
	 * the updated velocity, position, and formula position, and time after every one second.
	 * 
	 * parameters: double, initial Velocity
	 * returns: none
	 * output: prints a table of values of the simulated projectile motion.
	 */
		public static void simulation(double initialVelocity){
			Scanner input = new Scanner(System.in);
			final double INITIALPOSITION = 0;
			double initialVel = checkVelocity(initialVelocity);
			double deltaT = checkDeltaT();
			double gravAccel = checkGravity();
			double velocity = initialVel;
			double position = INITIALPOSITION;
			double formulaPosition = INITIALPOSITION;
			double time = 0;
			int i = 0;

			
			System.out.printf("%12s | %12s | %12s | %12s | %n", "Velocity", "Position", "Formula Position", "Time");
			
			do{

				if (i % (1/deltaT) == 0)
					System.out.printf("%12.4f | %12.4f | %16.4f | %12.4f | %n", velocity, position, formulaPosition, time);
				
				velocity = velocity - gravAccel * deltaT;
				formulaPosition = formulaMotion(time, initialVel, gravAccel);
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
		private static double formulaMotion(double time, double initialVelocity, double gravAccel){
			double formulaPosition = -0.5 * gravAccel * time * time + initialVelocity * time;
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
		 * This method is a helper method to gain input for the time interval of the simulation. The program will also not accept a time interval of <= 0. It will continue to prompt the 
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
		

	/*
	 * This method uses helper methods to gain input for the min/max length and width from the user. It then takes those values and makes sure that the min and max of the respective
	 * dimensions of the rectangle are not out of order. If the minimum of a dimension is greater than the maximum, then this method switches the two, making the old max, the new min, and 
	 * vice versa. It then calls the printRectangle() method to display the table of rectangle width, length and area on the output.
	 * 
	 * Parameters: none
	 * Return values: none
	 * Output: prints table of values on the console
	 */
	public static void rectangleTable(){
		do{
			Scanner input = new Scanner(System.in);
			int lengthMin = checkMinLength();
			int lengthMax = checkMaxLength();
			int widthMin = checkMinWidth();
			int widthMax = checkMaxWidth();

			
			if (widthMax <= widthMin){
				int a = widthMax;
				int b = widthMin;
				widthMin = a;
				widthMax = b;
			}

			if (lengthMax <= lengthMin){
				int a = lengthMax;
				int b = lengthMin;
				lengthMin = a;
				lengthMax = b;
			}

			printRectangleTable(lengthMin, lengthMax, widthMin, widthMax);
		}
		while(anotherTable());
	}

	/*
	 * This method prompts the user for a minimum integer length for the length of the rectangle. If the input value is negative, the method changes it to positive.
	 * 
	 * parameters: none
	 * return: int, minimum length of rectangle
	 */
	private static int checkMinLength(){
		System.out.println("Please enter a minimum integer length for the rectangle");
		int lengthMin = input.nextInt();
		if (lengthMin < 0)
			return -lengthMin;
		return lengthMin;
	}
	/*
	 * This method prompts the user for a maximum integer length for the length of the rectangle. If the input value is negative, the method changes it to positive.
	 * 
	 * parameters: none
	 * return: int, maximum length of rectangle
	 */
	private static int checkMaxLength(){
		System.out.println("Please enter a maximum integer length for the rectangle");
		int lengthMax = input.nextInt();
		if (lengthMax < 0)
			return -lengthMax;
		return lengthMax;
	}
	/*
	 * This method prompts the user for a minimum integer length for the width of the rectangle. If the input value is negative, the method changes it to positive.
	 * 
	 * parameters: none
	 * return: int, minimum width of rectangle
	 */
	private static int checkMinWidth(){
		System.out.println("Please enter a minimum integer width for the rectangle");
		int widthMin = input.nextInt();
		if (widthMin < 0)
			return -widthMin;
		return widthMin;
	}
	/*
	 * This method prompts the user for a maximum integer length for the width of the rectangle. If the input value is negative, the method changes it to positive.
	 * 
	 * parameters: none
	 * return: int, maximum width of rectangle
	 */
	private static int checkMaxWidth(){
		System.out.println("Please enter a maximum integer width for the rectangle");
		int widthMax = input.nextInt();
		if (widthMax < 0)
			return -widthMax;
		return widthMax;
	}
	/*
	 * This method takes in the integer dimensions that were input by the user and prints the range of values from the smallest to the largest dimension.
	 * It also prints the calculated area next to the respective length and width
	 * 
	 * parameters: int, minimum length, max length, minimum width, max width
	 * returns: none
	 * output: prints table of areas
	 */
	private static void printRectangleTable(int lengthMin, int lengthMax, int widthMin, int widthMax){
		System.out.println("width  length  area");
		for(int i = 0; i <= Math.abs(Math.abs(widthMax)-Math.abs(widthMin)); i++ ){

			for(int j = 0; j <= Math.abs(Math.abs(lengthMax)-Math.abs(lengthMin)); j++ ){

				int tableWidth = Math.abs(widthMin) + i; 
				int tableLength = Math.abs(lengthMin) + j; 
				int tableArea = tableWidth * tableLength;
				System.out.print(tableWidth + "\t" + tableLength + "\t" + tableArea);
				System.out.println();
			}

			System.out.println();
		}
	}
	public static boolean anotherTable(){
		Scanner input = new Scanner(System.in);
		String answer;
		while (true){
			System.out.println("would you like to print another rectangle table? \n please enter y or n" );
			answer = input.nextLine();
			if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")){
				break;
			}
			else{
				System.out.println("invalid response, please enter y or n");
			}
			
		}
		if (answer.equalsIgnoreCase("y")){
			return true;
		}
		else
			return false;
	}
	
	

	public static void main(String [] args){
		factorial();
		System.out.println();
		LoopExamples.simulation(20.25);
		System.out.println();
		simulation(-20);
		System.out.println();
		simulation(0);
		System.out.println();
		simulation(-40);
		System.out.println();
		rectangleTable();
	}

	
}
/*
 Please enter a non-negative integer to factorialize
all negative integers will be treated as their positive counterparts
-5
120
would you like to find another factorial? 
 please enter y or n
y
Please enter a non-negative integer to factorialize
all negative integers will be treated as their positive counterparts
120
6689502913449127057588118054090372586752746333138029810295671352301633557244962989366874165271984981308157637893214090552534408589408121859898481114389650005964960521256960000000000000000000000000000
would you like to find another factorial? 
 please enter y or n
fhg
invalid response, please enter y or n
would you like to find another factorial? 
 please enter y or n
y
Please enter a non-negative integer to factorialize
all negative integers will be treated as their positive counterparts
-1200
63507890863456767124026223135865363993920361927048401849732641593094118304334664838518489279761202858110442656198961423888337785958374054395875090008179394602121729048755527506222388620438398012556615061940909904115015164483186340282667999681601237310950712039020066375755766076440811303940538840103890741951917564190561275396873204122937083746098640414588850116107225675520412584415359155103495655208534054658149146203739758027326003354866456731097561086620889903717246818807490131678158299401901235057514328881677204150054888001843870188616756694468379677033228639349974219800691760236674808772459147849761319772233349285258185354881462706759016416844508026593468378544952254302304068325633905800617846092173316334920423976973219453332902616477256306327233355305287468380745909208415980513577159243876582648875144838454034618802839634184994308400967856236366107563273185702779295861081100580569890291839403080692152562549750464518941296615589072961901445867101610266912853288908304184351248084449986727837714164724886934713403840928394071581648559037175552279054765268191336562999918827853842984694855922999162907679561931097787771324637893456823082524179018246504955405803121771121360752264414781039718455098118457351815525441962553663917394824907930942411732997508709279776658345871568600666174624864566227235992187598660130953640936345350873339744682415089563501119516442999676532779307108492176925439731860347372511112433604790992759325197681339726349322054878255119874625965850196940660648685990671210212572225564228346159053754713667934756177880507837712524591347066833930606771513277248914447108453842428044821209156242191481316239948456314071437111282270756494813443336707372525017024678559199590515860360962136467183581351799081925904581530470013515629221769984825958416224944982867113744499809912183809641523923237883957287541972186804232110652653006828947123647231393100716154785438044926596489481061404444949958850342025214038700582411675847296195285368313134928856220726124462351334098415059073275239953735718425086123827271757497468773885713767925771130546617686545287963633612898691413349119011210341661317374809835898724194978360650558823413986166888783608735534361048197825992486540004672367499044204531085976637277941222039312514997381320707709813267213844400528265917241905520030567187527121305903232698469502319828288497642071789544559470672876896682816986176852553613912123976135208540633191577134212923764719883260091745561140753211368159375154389149276613870478944559132118639123292629448861220166692668795869998815536697843168702435154762819119055700781916899847331952260368608062686678197902264191722301178373738543720223581116366378070649868986724225640819288848872888236573440404740650405057575066492961346462735749115329710082527101393654163731209311139319445720303577449977552535888706315264756010489543514382828926003274237925093166062460951592960000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
would you like to find another factorial? 
 please enter y or n
y
Please enter a non-negative integer to factorialize
all negative integers will be treated as their positive counterparts
30
265252859812191058636308480000000
would you like to find another factorial? 
 please enter y or n
y
Please enter a non-negative integer to factorialize
all negative integers will be treated as their positive counterparts
0
1
would you like to find another factorial? 
 please enter y or n
n

please enter a small positive Time Interval 
0.01
please enter a non-zero gravitiational acceleration
-9.8
    Velocity |     Position | Formula Position |         Time | 
     20.2500 |       0.0000 |           0.0000 |       0.0000 | 
     10.4500 |      15.3010 |          15.2450 |       1.0000 | 
      0.6500 |      20.8020 |          20.8930 |       2.0000 | 
     -9.1500 |      16.5030 |          16.7410 |       3.0000 | 
    -18.9500 |       2.4040 |           2.7890 |       4.0000 | 
    -20.2240 |      -0.1487 |           0.2554 |       4.1300 | 

please enter a small positive Time Interval 
-0.01
invalid Time Interval
please enter a small positive Time Interval 
0.02
please enter a non-zero gravitiational acceleration
10
    Velocity |     Position | Formula Position |         Time | 
     20.0000 |       0.0000 |           0.0000 |       0.0000 | 
     10.0000 |      14.9000 |          14.7980 |       1.0000 | 
      0.0000 |      19.8000 |          19.9980 |       2.0000 | 
    -10.0000 |      14.7000 |          15.1980 |       3.0000 | 
    -20.0000 |      -0.4000 |           0.3980 |       4.0000 | 

0.0 is an invalid initial velocity
please enter a new non-zero initial velocity
0
0.0 is an invalid initial velocity
please enter a new non-zero initial velocity
20
please enter a small positive Time Interval 
0.5
please enter a non-zero gravitiational acceleration
-9.81
    Velocity |     Position | Formula Position |         Time | 
     20.0000 |       0.0000 |           0.0000 |       0.0000 | 
     10.1900 |      12.6425 |           8.7738 |       1.0000 | 
      0.3800 |      15.4750 |          18.9638 |       2.0000 | 
     -9.4300 |       8.4975 |          19.3437 |       3.0000 | 
    -19.2400 |      -8.2900 |           9.9138 |       4.0000 | 

please enter a small positive Time Interval 
0.025
please enter a non-zero gravitiational acceleration
0
invalid gravitational acceleration
please enter a non-zero gravitiational acceleration
5
    Velocity |     Position | Formula Position |         Time | 
     40.0000 |       0.0000 |           0.0000 |       0.0000 | 
     35.0000 |      37.4375 |          36.6234 |       1.0000 | 
     30.0000 |      69.8750 |          69.2484 |       2.0000 | 
     25.0000 |      97.3125 |          96.8734 |       3.0000 | 
     20.0000 |     119.7500 |         119.4984 |       4.0000 | 
     15.0000 |     137.1875 |         137.1234 |       5.0000 | 
     10.0000 |     149.6250 |         149.7484 |       6.0000 | 
      5.0000 |     157.0625 |         157.3734 |       7.0000 | 
      0.0000 |     159.5000 |         159.9984 |       8.0000 | 
     -5.0000 |     156.9375 |         157.6234 |       9.0000 | 
    -10.0000 |     149.3750 |         150.2484 |      10.0000 | 
    -15.0000 |     136.8125 |         137.8734 |      11.0000 | 
    -20.0000 |     119.2500 |         120.4984 |      12.0000 | 
    -25.0000 |      96.6875 |          98.1234 |      13.0000 | 
    -30.0000 |      69.1250 |          70.7484 |      14.0000 | 
    -35.0000 |      36.5625 |          38.3734 |      15.0000 | 
    -40.0000 |      -1.0000 |           0.9984 |      16.0000 | 

Please enter a minimum integer length for the rectangle
-2
Please enter a maximum integer length for the rectangle
-8
Please enter a minimum integer width for the rectangle
-4
Please enter a maximum integer width for the rectangle
-5
width  length  area
4	2	8
4	3	12
4	4	16
4	5	20
4	6	24
4	7	28
4	8	32

5	2	10
5	3	15
5	4	20
5	5	25
5	6	30
5	7	35
5	8	40

would you like to print another rectangle table? 
 please enter y or n
y
Please enter a minimum integer length for the rectangle
2
Please enter a maximum integer length for the rectangle
-8
Please enter a minimum integer width for the rectangle
0
Please enter a maximum integer width for the rectangle
0
width  length  area
0	2	0
0	3	0
0	4	0
0	5	0
0	6	0
0	7	0
0	8	0

would you like to print another rectangle table? 
 please enter y or n
y
Please enter a minimum integer length for the rectangle
0
Please enter a maximum integer length for the rectangle
10
Please enter a minimum integer width for the rectangle
2
Please enter a maximum integer width for the rectangle
-7
width  length  area
2	0	0
2	1	2
2	2	4
2	3	6
2	4	8
2	5	10
2	6	12
2	7	14
2	8	16
2	9	18
2	10	20

3	0	0
3	1	3
3	2	6
3	3	9
3	4	12
3	5	15
3	6	18
3	7	21
3	8	24
3	9	27
3	10	30

4	0	0
4	1	4
4	2	8
4	3	12
4	4	16
4	5	20
4	6	24
4	7	28
4	8	32
4	9	36
4	10	40

5	0	0
5	1	5
5	2	10
5	3	15
5	4	20
5	5	25
5	6	30
5	7	35
5	8	40
5	9	45
5	10	50

6	0	0
6	1	6
6	2	12
6	3	18
6	4	24
6	5	30
6	6	36
6	7	42
6	8	48
6	9	54
6	10	60

7	0	0
7	1	7
7	2	14
7	3	21
7	4	28
7	5	35
7	6	42
7	7	49
7	8	56
7	9	63
7	10	70

would you like to print another rectangle table? 
 please enter y or n
y
Please enter a minimum integer length for the rectangle
-9
Please enter a maximum integer length for the rectangle
-2
Please enter a minimum integer width for the rectangle
2
Please enter a maximum integer width for the rectangle
5
width  length  area
2	2	4
2	3	6
2	4	8
2	5	10
2	6	12
2	7	14
2	8	16
2	9	18

3	2	6
3	3	9
3	4	12
3	5	15
3	6	18
3	7	21
3	8	24
3	9	27

4	2	8
4	3	12
4	4	16
4	5	20
4	6	24
4	7	28
4	8	32
4	9	36

5	2	10
5	3	15
5	4	20
5	5	25
5	6	30
5	7	35
5	8	40
5	9	45

would you like to print another rectangle table? 
 please enter y or n
n
*/
