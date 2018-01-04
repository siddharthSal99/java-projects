import java.util.Scanner;
public class TestPrograms {

	public static void main(String[] args) {
/*
		Scanner row = new Scanner(System.in);
		System.out.println("rows");
		int rows = row.nextInt();
		
		Scanner column = new Scanner (System.in);
		System.out.println("columns");
		int columns = column.nextInt();
*/
		for (int rows = 1, columns = 1 ; rows < 11 ; rows ++ , columns ++){

		for(int i = 0 ; i<= rows - 1 ; i++){
			int j = 1;
			for ( ; j <= columns ; j++){
				System.out.print (columns * i + j + "," );
			}
		System.out.println();
		}
		
	}
		
		
	}

}