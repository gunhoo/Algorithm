package d2;
import java.util.Scanner;

public class d2_1961 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int[][] arrays = new int[n][n];
			// fill the array
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arrays[i][j] = sc.nextInt();
				}
			}
				
			System.out.println("#"+test_case);
			
			for(int i=0; i<n; i++) {
				for(int j=n-1; j>=0; j--) {
					System.out.printf(""+arrays[j][i]);
				}
				System.out.printf(" ");
				for(int j=n-1; j>=0; j--) {
					System.out.printf(""+arrays[n-i-1][j]);
				}
				System.out.printf(" ");
				for(int j=0; j<n; j++) {
					System.out.printf(""+arrays[j][n-i-1]);
				}
				System.out.println();
			}
			
		}
		

	}

}
