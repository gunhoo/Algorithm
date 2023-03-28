package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1463_1로만들기 {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		if(N==1) {
			System.out.println(0);
			return;
		}
		if(N<4) {
			System.out.println(1);
			return;
		}
		dp[0] = dp[1] = dp[2] = dp[3] = 1;
		for (int i = 4; i < N+1; i++) {
			dp[i] = dp[i-1]+1;
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
		}
		System.out.println(dp[N]);
	}
}