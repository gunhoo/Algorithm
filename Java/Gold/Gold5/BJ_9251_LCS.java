package Gold.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9251_LCS {
	static char[] a, b;
	static Integer[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		dp = new Integer[a.length][b.length];
		System.out.println(lcs(a.length-1, b.length-1));
		
	}
	
	private static int lcs(int x, int y) {
		if(x < 0 || y < 0) return 0;
		if(dp[x][y] == null) {
			dp[x][y] = 0;
			if(a[x] == b[y]){
				dp[x][y] = lcs(x-1, y-1)+1;
			}else {
				dp[x][y] = Math.max(lcs(x-1,y), lcs(x, y-1));
			}
		}
		return dp[x][y];
	}

}
