/*
 * This utility class calculates statistics for a given array of data points of type double. All the statistics methods call the fixArray() method
 * which sorts and returns a different array of type double. The statistics can be calculated for any array with more than zero data points.
 * For the empty array, statistics will return as a Not-A-Number error message. 
 */
import javax.swing.JFrame;
import java.util.ArrayList;

public class Statistics {
	/*
	 * This method accepts an array of type double, copies the array into another array, then sorts the array least to greatest.
	 * it then returns the sorted array copy, not the original array.
	 * Parameters: double[] data
	 * returns: double[] fixed array
	 */
	public static double[] fixArray(double[] data){
		double[] fixedArray = new double [data.length];
		for (int i = 0; i < data.length ; i++){
			fixedArray[i] = data[i];
		}
		for(int i = 0; i < fixedArray.length; i++){
			for(int j = i + 1; j < fixedArray.length; j++){
				if(fixedArray[i] > fixedArray[j]){
					double temp = fixedArray[i];
					fixedArray[i] = fixedArray[j];
					fixedArray[j] = temp;
				}
			}
		}

		return fixedArray;
	}
	/*
	 * This method accepts the double array and sorts the array using the fixArray() method. It then subtracts the largest value from
	 * the smallest value by subtracting the first element from the last element. the range is a single number of type double. 
	 *  An empty array parameter will return A not-A-number error message.
	 * parameters: double[] data
	 * returns: double range
	 */	
	public static double range(double[] data){
		if(data.length == 0)
			return Double.NaN;
		double[] temp = fixArray(data);
		double range = temp[temp.length - 1] - temp[0];
		return range;
	}

	/*
	 * This method calculates the mode(s) of a data set. If there is more than one mode, then all the modes are returned in an ArrayList
	 * of type Double. An empty array parameter will return an empty array list.
	 * parameters: double[] data
	 * returns: ArrayList <Double> modes;
	 */	
	public static ArrayList<Double> mode(double[] data){	
		double[] temp = fixArray(data);
		ArrayList<Double> tempList = new ArrayList<Double>(temp.length);
		for (int i = 0; i < temp.length ; i++){
			tempList.add(temp[i]); 
		}
		int max = 1;
		int count = 0;
		ArrayList<Double> modes = new ArrayList<Double>();
		for (int i = 0; i < tempList.size();i++){
			count = 0;
			for (int j = i + 1; j < tempList.size(); j++){
				if (tempList.get(i).equals(tempList.get(j)))
					count++;
			}
			if(count >= max)
				max = count;
		}
		for (int i = 0; i < tempList.size();i++){
			count = 0;
			for (int j = i +1 ; j < tempList.size(); j++){
				if (tempList.get(i).equals(tempList.get(j)))
					count++;
			}
			if(count == max)
				modes.add(tempList.get(i));
		}
		if((double)temp.length / (max + 1) == modes.size())
			return new ArrayList<Double>();
		else return modes;
	}

	/*
	 * this method returns the mean of a data set in an array of type double. The values are all added up, then the sum is divided by the
	 * number of elements in the array. No need to sort.
	 * parameters: double[] data
	 * returns: double value ; it is the mean because the sum is divided by the number of terms
	 */
	public static double mean(double[] data){
		if(data.length == 0)
			return Double.NaN;
		double sum = 0;
		for(double vals : data)
			sum += vals;
		return sum/(data.length);
	}
	/*
	 * This method calculates the median of a data set. After sorting the array, it checks if the array has an even or odd length, and based on that, either returns the average of the
	 * two middle numbers in the data set, if it is even, or the middle number, if it is odd.
	 * parameters: double[] data
	 * returns: double median
	 */
	public static double median(double[] data){
		if(data.length == 0)
			return Double.NaN;

		double[] temp = fixArray(data);
		double median = 0;
		if (temp.length % 2 == 0)
			median = (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2;
		else
			median = temp[(int)temp.length / 2];

		return median;
	}
	/*
	 * This method calculates the upper quartile of a data set. It first sorts the array. It then creates a temporary array from the upper half, discounting the median, of the original array.
	 * The method then returns the median of the new array, which is the upper quartile value.
	 * Parameters: double[] data
	 * Returns: double upper Quartile value (median of the upper half of data set)
	 */
	public static double upperQuartile(double[] data){
		if(data.length == 0)
			return Double.NaN;

		double[] temp = fixArray(data);
		double[] upperQ = new double[temp.length/2];

		if(temp.length % 2 == 0){
			for(int i = temp.length/2, j = 0 ; i < temp.length ; i++, j++)
				upperQ[j] = temp[i];
		}
		else{
			for(int i = temp.length/2 + 1, j =0 ; i < temp.length ; i++, j++)
				upperQ[j] = temp[i];
		}
		return median(upperQ);
	}
	/*
	 * This method calculates the lower quartile of a data set. It first sorts the array. It then creates a temporary array from the lower half, discounting the median, of the original array.
	 * The method then returns the median of the new array, which is the lower quartile value.
	 * Parameters: double[] data
	 * Returns: double lower quartile value (median of the lower half of data set)
	 */
	public static double lowerQuartile(double[] data){
		if(data.length == 0)
			return Double.NaN;

		double[] temp = fixArray(data);
		double[] lowerQ = new double[temp.length/2];
		if(temp.length % 2 == 0){
			for(int i = temp.length/2 - 1  ; i >= 0 ; i--)
				lowerQ[i] = temp[i];
		}
		else
			for(int i = temp.length/2 - 1 ; i >= 0 ; i--)
				lowerQ[i] = temp[i];
		return median(lowerQ);
	}
	/*
	 * This method calculates the interquartile range of the data set. It subtracts the values of the lower quartile from the upper quartile.
	 * Parameters: double[] data
	 * Returns: double interquartile range value (difference between upper and lower quartiles)
	 */
	public static double interquartileRange(double[] data){
		if(data.length == 0)
			return Double.NaN;

		return upperQuartile(data) - lowerQuartile(data);
	}
	/*
	 * This method calculates any outliers in the data set. it compares all the values in a data set to the upper and lower fences, and adds it to an array if it falls outside those 
	 * fences.
	 * Parameters: double[] data
	 * Returns: ArrayList<Double> outliers
	 */
	public static ArrayList<Double> outliers(double[] data){
		double[] temp = fixArray(data);
		ArrayList<Double> outliers = new ArrayList<Double>();
		double upperFence = lowerQuartile(temp) - 1.5 * interquartileRange(temp);
		double lowerFence = upperQuartile(temp) + 1.5 * interquartileRange(temp);
		for(double vals : temp){
			if(vals < upperFence || vals > lowerFence )
				outliers.add(vals);
		}
		if(data.length == 0)
			return new ArrayList<Double>();
		return outliers;
	}
	/*
	 * This method returns the standard deviation of the data set. Using the standard deviation formula, the method calls the mean() method and calculates the special formula sum 
	 * using that.
	 * Parameters: double[] data
	 * Returns: double standard deviation (returns the square root of the sum / (number of terms - 1)    )
	 */
	public static double standardDeviation(double[] data){
		if(data.length == 0)
			return Double.NaN;
		double xBar = mean(data);
		double sum = 0;
		for(double vals : data){
			sum += Math.pow(vals - xBar, 2);
		}
		return Math.sqrt(sum / (data.length - 1));
	}
/*
 * This method calculates the z score of a given value in relation to a given data set. using the mean() and standardDeviation() methods, the z-score is calculated using the given formula
 * Parameters: double[] data, and double value
 * Returns: double zScore
 */
	public static double zScore(double[] data , double value){
		if(data.length == 0)
			return Double.NaN;

		double xBar = mean(data);
		double zScore = (value - xBar) / standardDeviation(data);
		return zScore;

	}
	/*
	 * This method prints the values of a given array in order (not sorted)
	 * parameters: double[] a
	 * returns: void
	 * output: displays the values of an array separated by commas
	 */
	public static void printArray(double[] a){
		for(double val: a)
			System.out.print(val + ", ");
		System.out.println();
	}
	/*
	 * This array calculates the minimum of a given array. It sorts the array least to greatest, then returns the first (0th) index value.
	 * parameters: double[] data
	 * returns: double minimum
	 */
	public static double min(double[] data){
		if(data.length == 0)
			return Double.NaN;
		double[] temp = fixArray(data);
		double min = temp[0];
		return min;
	}
	/*
	 * This array calculates the maximum of a given array. It sorts the array least to greatest, then returns the last index value.
	 * parameters: double[] data
	 * returns: double maximum
	 */
	public static double max(double[] data){
		if(data.length == 0)
			return Double.NaN;
		double[] temp = fixArray(data);
		double max = temp[temp.length - 1];
		return max;
	}
	/*
	 * this method creates a JFrame and adds the BoxAndWhiskerComponent to the JFrame and makes it visible
	 * Parameters: double[] data
	 * Returns: void
	 * output: creates a JFrame with a box and whisker plot of the double[] data on it.
	 */
	public static void drawBox(double[] data){

		JFrame boxFrame = new JFrame();
		boxFrame.setSize(500,500);
		boxFrame.setTitle("Box and Whisker Plot");
		boxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boxFrame.setVisible(true);

		BoxAndWhiskerComponent graph = new BoxAndWhiskerComponent(data);
		boxFrame.add(graph);

	}
}
