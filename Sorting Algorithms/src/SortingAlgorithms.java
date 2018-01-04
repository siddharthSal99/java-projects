import java.util.ArrayList;

public class SortingAlgorithms {

	public static void selectionSort(int[] a){
		for(int i = 0; i < a.length; i++){
			int minIndex = i;
			int index = i;
			while(index < a.length){
				if(a[index] < a[minIndex])
					minIndex = index;
				index++;
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}
	public static void selectionSort(ArrayList<String> a){
		for(int i = 0; i< a.size(); i++){
			int minIndex = i;
			int index = i;
			while(index < a.size()){
				if(a.get(index).compareTo(a.get(minIndex)) < 0)
					minIndex = index;
				index++;
			}
			a.set(minIndex, a.set(i,a.get(minIndex)));
		}
	}



	public static void mergeSort(int[] a){
		if(a.length <= 1)
			return;
		int[] b = new int[a.length / 2];
		int[] c = new int[a.length - b.length];

		for(int i = 0; i < b.length; i++)
			b[i] = a[i];
		for(int j = 0; j < c.length; j++)
			c[j] = a[j + b.length];

		mergeSort(b); mergeSort(c);
		merge(a,b,c);

	}
	public static void merge(int[] a, int[] b, int[] c){
		int k = 0; int i = 0; int j = 0;
		while(k < a.length){
			if(i >= b.length || j >= c.length)
				break;

			if(b[i] < c[j])
			{a[k] = b[i]; i++;}
			else
			{a[k] = c[j]; j++;}
			k++;
		}
		if(b.length > 0){
			while(j < c.length)
			{a[k] = c[j]; j++; k++;}
		}
		if(c.length > 0){
			while(i < b.length)
			{a[k] = b[i]; i++; k++;}
		}
	}


//	//quicksort for int arrays
//	public static void quickSort(int[] a) {
//			quickSort(a, 0, a.length - 1);
//		}
//
//		public static void quickSort(int[] a, int start, int end) {
//			// if(start >= end) return;
//			if (end - start < 1)
//				return;
//			int s = start;
//			int e = end;
//			int pvt = a[start];
//			while (s <= e) {
//
//				if (a[s] <= pvt ) {
//					s++;
//				}
//				else if (a[e] > pvt ) {
//					e--;
//				}
//				else {
//					int temp = a[s];
//					a[s] = a[e];
//					a[e] = temp;
//					
//				}
//			}
//			
//			int temp = a[start];
//			a[start] = a[e];
//			a[e] = temp;
//			
//			
//			quickSort(a, start, e - 1);
//			quickSort(a, e + 1, end);
//
//		}

	public static void split(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = a[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (a[i] < pivot && i < j) {
                i++;
            }
            while (a[j] >= pivot && j > i) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[start];
        a[start] = a[j];
        a[j] = temp;
        printArray(a);
        split(a, start, j - 1);
        split(a, j + 1, end);
    }

    public static void quickSort(int[] a) {
        split(a, 0, a.length - 1);
    }
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int fix = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > fix) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = fix;
		}
	}

	public static void insertionSort(ArrayList<String> a) {
		for (int i = 1; i < a.size(); i++) {
			String fix = a.get(i);
			int j = i;
			while (j > 0 && a.get(j).compareTo(fix) > 0) {
				a.set(j, a.get(j - 1));
				j--;
			}
			a.set(j,fix);
		}
	}

	public static void printArray(int[] a){
		for(int vals: a){
			System.out.print(" " + vals + ",");

		}
		System.out.println();
	}

	public static void main(String[] args){
		int[] a = {9,8,2,6,8, 7, 6, 5, 4, 3, 2, 1,-7};
		int[] b = {1,2,3,4};
		int[] c = {5,6,7,8,9};
		
		ArrayList<String> d = new ArrayList<String>(10);
		d.add("batman");
		d.add("superman");
		d.add("wonderwoman");
		d.add("greenlantern");
		d.add("hawkgirl");
		d.add("martianmanhunter");
		d.add("flash");
		d.add("drfate");
		d.add("bluebeetle");
		d.add("greenarrow");
		printArray(a);
		//System.out.println(a);
		quickSort(a);
		//System.out.println(a);
		printArray(a);

	}

}


