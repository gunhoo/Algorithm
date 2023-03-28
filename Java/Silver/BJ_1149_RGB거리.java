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
		int[][] dp = new int[N+1][3]; // DP 배열 생성
		for(int i =1; i <= N ;i++) { 
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], Integer.MAX_VALUE); // 최솟값을 구하기위해 기본값을 최댓값으로 설정
			for(int j =0; j < 3; j++) {
				int color = Integer.parseInt(st.nextToken()); // 값 입력받고
				for(int k = 0; k < 3; k++) { // 윗칸을 본다
					if(k == j ) continue; // 같은 칸이면 패스
					dp[i][j] = Math.min(dp[i][j], color+dp[i-1][k]); // 현재 자신의 값과 자신의윗줄의값+현재color의 값을 넣어 memoization을 갱신한다
				}
			}
		}
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2])); // 3개중 최솟값 출력
	}

}
