package d2;
import java.util.Scanner;

public class d2_1209 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case=1; test_case<=10; test_case++) {
			int t = sc.nextInt();
			int max_val = 0, sum_val = 0;
			int[][] arrays = new int[100][100];
			
			for(int i=0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					arrays[i][j] = sc.nextInt(); 
				}
			}
			// check row
			for(int i = 0; i<100; i++) {
				sum_val = 0;
				for(int j=0; j<100; j++) {
					sum_val += arrays[i][j];
				}
				if (sum_val > max_val) {
					max_val = sum_val;
				}
			}
			
			// check col
			for(int i = 0; i<100; i++) {
				sum_val = 0;
				for(int j=0; j<100; j++) {
					sum_val += arrays[j][i];
				}
				if (sum_val > max_val) {
					max_val = sum_val;
				}
			}
			
			// check par
			sum_val = 0;
			for(int i=0; i<100; i++) {
				sum_val += arrays[i][99-i];
			}
			if (sum_val > max_val) {
					max_val = sum_val;
			}
			sum_val = 0;
			for(int i=0; i<100; i++) {
				sum_val += arrays[99-i][i];
			}
			if (sum_val > max_val) {
					max_val = sum_val;
			}
			System.out.println("#"+test_case+" "+max_val);
		}
		

	}

}
