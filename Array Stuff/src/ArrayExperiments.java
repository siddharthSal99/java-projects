import java.util.ArrayList;

public class ArrayExperiments {



	public static void printArray(int[] a){
//		for(int i = 0; i < a.length; i++)
//			System.out.print(a[i] + " ");
		
		// for-each loop
		for(int val: a)
			System.out.print(val + " ");
		
	//	System.out.println();
	}
	
	public static void printArray(String[] a){
		for(String val: a)
			System.out.print(val + " ");
		
	//	System.out.println();
	}
	
	/*
	 * Returns a tally of the number of even values in an int[] array
	 */
	public static int countEvens(int[] list){
		int count = 0;
		
		for(int num: list)
			if(num % 2 == 0)
				count++;
		return count;
	}
	
	public static void sort(String[] list){
		for(int i = 0; i < list.length; i++){
			for(int j = i + 1; j < list.length; j++){
				if(list[i].compareToIgnoreCase(list[j]) > 0){
					String temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	public static int[] maxAndMin(int [] nums){
		for(int i = 0; i <= nums.length ; i++){
			for(int j = i + 1 ; j < nums.length ; j++){
				if (nums[i] > nums[j]){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
			
		}
		int[] maxMin = {nums[0],nums[nums.length - 1]};
		return maxMin;
			
	}
	
	public static int fibonacci(int n){
		if(n == 1 || n == 2 ) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	public static void main(String[] args) {
		int[] a = {4,6,8,2,3,7,9,88,21};
		System.out.println(fibonacci(10));
//		ArrayExperiments.printArray(a);
//		System.out.println();
//		System.out.println("contains " + countEvens(a) + " even values." + "\n");
//		
//		String[] words = {"cat", "quail", "whale", "peacock", "turtle", "Turtle","baboon","whale",
//				"dog"};
//		printArray(words);
//		System.out.println();
//		sort(words);
//		printArray(words);
//		System.out.println();
//		//int[] vals = new int[10];
//		int[] vals = { 2,4,9,12,42,54,78,65,7,90 };
//		
//		System.out.print("The min and max values of the array are "); printArray(maxAndMin(vals)); System.out.print("respectively");
//		System.out.println();
//		double[] values = {-1.2, -34.6, -5.03,100, -45, -2.256, -17.31,12, -17.3224, -18, -7.7, -5.901, 0};
//		
//		double max = values[0];
//		for( double x : values){
//			if (x > max)
//				max = x;
//		}
//		System.out.println(max);
//		
//		int[] abcd = {0,1,2,3,4,5,6,7,8,9};
//		System.out.println(abcd.length);
//		
//		int[][] m = {{3,4,5,6,12},
//					{34,54,6,3,4},
//					{1,2,3,4,5,6,7,8,9,0},
//					{67,34}};
//	printArray(arrayMaxes(m));

	}
	
	public static int rowMax(int[] m){
		for(int i = 0; i < m.length; i++){
			if(m[0] < m[i]){
				int temp = m[0];
				m[0] = m[i];
				m[i] = temp;
			}
		}
		return m[0];
	}
	
	public static int[] arrayMaxes(int[][] m){
		int[] maxes = new int[m.length];
		for (int rows = 0; rows < m.length; rows++){
			maxes[rows] = rowMax(m[rows]);
		}
		return maxes;
	}


	
}







