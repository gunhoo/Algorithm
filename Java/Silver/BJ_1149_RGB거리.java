package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][3];
		for(int i =1; i <= N ;i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			for(int j =0; j < 3; j++) {
				int color = Integer.parseInt(st.nextToken());
				for(int k = 0; k < 3; k++) {
					if(k == j ) continue;
					dp[i][j] = Math.min(dp[i][j], color+dp[i-1][k]);
				}
			}
		}
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}

}
