package d2;
import java.util.Scanner;


public class d2_1974 {
	private static int fac(int a) {
		int result = 1;
		for (int i=1; i<=a; i++) {
			result *= i;
		}
		return result;
	}
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 1;
			// declare a sudoku variable 
			int[][] sudoku = new int[9][9];
			// fill the sudoku 
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			for (int i=0; i<9; i++) {
				int sum_val = 1;
				// check row
				for (int j=0; j<9; j++) {
					sum_val *= sudoku[i][j];
				}
				if(sum_val != fac(9)) {
					answer = 0;
					break;
				}
				sum_val = 1;
				// check col
				for (int j=0; j<9; j++) {
					sum_val *= sudoku[j][i];
				}
				if(sum_val != fac(9)) {
					answer = 0;
					break;
				}
				sum_val = 1;
				// check square
				if(i%3 == 0) {
					for(int j=0; j<3; j++) {
						sum_val *= sudoku[i][j] * sudoku[i+1][j] * sudoku[i+2][j];
					}
					if(sum_val != fac(9)) {
						answer = 0;
						break;
					}
					sum_val = 1;
					for(int j=3; j<6; j++) {
						sum_val *= sudoku[i][j] * sudoku[i+1][j] * sudoku[i+2][j];
					}
					if(sum_val != fac(9)) {
						answer = 0;
						break;
					}
					sum_val = 1;
					for(int j=6; j<9; j++) {
						sum_val *= sudoku[i][j] * sudoku[i+1][j] * sudoku[i+2][j];
					}
					if(sum_val != fac(9)) {
						answer = 0;
						break;
					}
				}
			}
			System.out.println("#"+test_case+" "+answer);
			
		}

	}

}
