/*
 * This class tests the methods of the Statistics class with different data arrays. It tests decimals, larger numbers, varying lengths of arrays, including n empty array.
 * The output of this class is grouped by a data set with all its statistics. 
 */
public class ArrayTester {
	public static void main(String[] args){
		//testing an empty array
		double[] data = {};
		//testing a single element array: methods in question are median, and quartiles.
		double[] data2 = {2};
		//testing a case with no mode, but the data point is repeated quite a few times
		double[] data3 = {1,1,1,1,1,1,1};
		//testing how the methods handle an array of two values
		double[] data4 = {4,-5};
		//all values repeated same number of times, therefore no mode
		double[] data5 = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6};
		//multiple modes, but most values are repeated
		double[] data6 = {1,1,-1,2,-2,3,3,3,4,4,5,5,6,7,7,-8,-9};
		//testing larger numbers and how mode handles multiple repeated values
		double[] data7 = {51,12,23,14,14,15,15,16,16,16,17,38,19,9};
		//testing how the methods handle decimals
		double[] data8 = {0,0,.2,5.8,.3,300.34,90.65,6.56,.34,2.76,0,99.2};
		//testing two of the same value, no mode
		double[] data9 = {0,0};
		//testing larger numbers with multiple modes
		double[] data10 = {15,15,15,-26,26,26,-34,34,44,44,44,51,-62,-62,62,77,-77,77,80,94,0};
		//double[] data11 = {0,100,42,44,51,59,39,45,75,76,69,75,20,20,25,28,25};
		double x = 6;
		
		System.out.print("The data set is: ");
		Statistics.printArray(data);
		System.out.println("The range of this data is: " + Statistics.range( data));
		System.out.println("The mean of this data is: " +Statistics.mean(data));
		System.out.println("The median of this data is: " +Statistics.median(data));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data2);
		System.out.println("The range of this data is: " +Statistics.range(data2));
		System.out.println("The mean of this data is: " +Statistics.mean(data2));
		System.out.println("The median of this data is: " +Statistics.median(data2));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data2));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data2));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data2));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data2));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data2));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data2,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data2));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data2);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data3);
		System.out.println("The range of this data is: " +Statistics.range(data3));
		System.out.println("The mean of this data is: " +Statistics.mean(data3));
		System.out.println("The median of this data is: " +Statistics.median(data3));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data3));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data3));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data3));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data3));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data3));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data3,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data3));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data3);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data4);
		System.out.println("The range of this data is: " +Statistics.range(data4));
		System.out.println("The mean of this data is: " +Statistics.mean(data4));
		System.out.println("The median of this data is: " +Statistics.median(data4));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data4));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data4));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data4));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data4));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data4));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data4,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data4));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data4);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data5);
		System.out.println("The range of this data is: " +Statistics.range(data5));
		System.out.println("The mean of this data is: " +Statistics.mean(data5));
		System.out.println("The median of this data is: " +Statistics.median(data5));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data5));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data5));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data5));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data5));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data5));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data5,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data5));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data5);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data6);
		System.out.println("The range of this data is: " +Statistics.range(data6));
		System.out.println("The mean of this data is: " +Statistics.mean(data6));
		System.out.println("The median of this data is: " +Statistics.median(data6));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data6));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data6));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data6));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data6));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data6));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data6,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data6));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data6);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data7);
		System.out.println("The range of this data is: " +Statistics.range(data7));
		System.out.println("The mean of this data is: " +Statistics.mean(data7));
		System.out.println("The median of this data is: " +Statistics.median(data7));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data7));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data7));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data7));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data7));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data7));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data7,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data7));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data7);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data8);
		System.out.println("The range of this data is: " +Statistics.range(data8));
		System.out.println("The mean of this data is: " +Statistics.mean(data8));
		System.out.println("The median of this data is: " +Statistics.median(data8));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data8));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data8));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data8));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data8));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data8));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data8,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data8));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data8);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data9);
		System.out.println("The range of this data is: " +Statistics.range(data9));
		System.out.println("The mean of this data is: " +Statistics.mean(data9));
		System.out.println("The median of this data is: " +Statistics.median(data9));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data9));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data9));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data9));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data9));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data9));
		System.out.println("The z-score of " + x + " in the data set is: " +Statistics.zScore(data9,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data9));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data9);
		System.out.println();

		System.out.print("The data set is: ");
		Statistics.printArray(data10);
		System.out.println("The range of this data is: " +Statistics.range(data10));
		System.out.println("The mean of this data is: " +Statistics.mean(data10));
		System.out.println("The median of this data is: " +Statistics.median(data10));
		System.out.println("The interquartile range of this data is: " +Statistics.interquartileRange(data10));
		System.out.println("The lower quartile of this data is: " +Statistics.lowerQuartile(data10));
		System.out.println("The upper quartile of this data is: " +Statistics.upperQuartile(data10));
		System.out.println("The standard deviation of this data is: " +Statistics.standardDeviation(data10));
		System.out.println("The outliers of this data is/are: " +Statistics.outliers(data10));
		System.out.println("The z-score of " + x + " in the data set is: "+Statistics.zScore(data10,x));
		System.out.println("The modes of this data is/are: " +Statistics.mode(data10));
		System.out.print("Just to prove the array does not change, here it is again: ");
		Statistics.printArray(data10);
		System.out.println();
		
		// Testing the drawBox() method, does it successfully create the box and whisker plot.
		// I purposely did not print all the box and whisker plots because it was a pain to run on my computer
		Statistics.drawBox(data10);
		Statistics.drawBox(data7);
	}
}
