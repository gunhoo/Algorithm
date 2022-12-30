package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d2_1959 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int max_val = 0, sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String[] a = br.readLine().split(" ");
			String[] b = br.readLine().split(" ");
			if(n<m) {
				for(int i = 0; i<= m-n; i++) {
					sum = 0;
					for(int j = 0; j < n; j++){
						sum += Integer.parseInt(a[j])*Integer.parseInt(b[j+i]);
					}
					if (sum > max_val){
						max_val = sum;
					}
				}
			}else {
				for(int i = 0; i<= n-m; i++) {
					sum = 0;
					for(int j = 0; j < m; j++){
						sum += Integer.parseInt(a[i+j])*Integer.parseInt(b[j]);
					}
					if (sum > max_val){
						max_val = sum;
					}
				}
			}
			
			
			
			System.out.println("# " +test_case + " " + max_val);
		}
	}

}
