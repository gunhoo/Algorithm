import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10870_피보나치수5_박건후 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		if(n >2) {
			for(int i = 0; i< 2; i++) {
				dp[i] = i;
			}
			for(int i = 2; i<= n ; i++) {
				dp[i] = dp[i-1]+dp[i-2];
			}
			System.out.println(dp[n]);
		}else if(n!= 0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
