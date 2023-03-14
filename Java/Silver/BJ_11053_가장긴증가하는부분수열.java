package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 10 28 10 20 25 10 30 50 
 * @author Gunhoo
 *
 */
public class BJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		st =  new StringTokenizer(br.readLine());
		int[] arr = new int[A];
		int[] dp = new int[A];
		for(int i =0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		for(int i = A-2; i>=0; i--) {
			for(int j = i+1; j < A; j++) {
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[A-1]);
		
	}

}
