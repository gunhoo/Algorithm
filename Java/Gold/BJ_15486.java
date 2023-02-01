package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 풀이시간 20:00 ~ 20:40 (실패: 시간초과)
 * ~21:30 코드리뷰/ dp로 수정 (실패: 시간초과)
 * 12:00~12:30 코드리뷰/수정 (성공) 
 * 
 * 1. 문제 풀이 유형?
 * 		- DP 문제인듯?
 * 
 * 
 * 
 * @author Gunhoo
 *
 */
public class BJ_15486 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		boolean[] visited = new boolean[n];
		
		for(int i = 0; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		/* 최초 시도 : 시간초과 : 원인? 탐색 too much
		for(int i = 0 ; i< n ; i++) {
			int idx = 0;
			// arrayList를 만들어서
			ArrayList<Integer> canMax = new ArrayList<>();
			if((i+t[i])>n ) { // 범위를 넘어가는 보상은 의미 없으므로 0으로 초기화
				p[i] = 0;
			}
			for(int j = idx; j < i ; j++) {
				if(visited[j] == false && (j+t[j])<= i) {
					canMax.add(p[i]+p[j]);
					visited[j-1>0?j-1:0] = true;
//					System.out.println("i: "+i+"j: "+j+"visitied: "+visited[j]);
				}
			}
			if(canMax.size() > 0) {
				Collections.sort(canMax, Collections.reverseOrder());
				p[i] = canMax.get(0);
				idx = i;
			}
		}

		Arrays.sort(p);
		System.out.println(p[p.length-1]);
		*/
		
		// dp
		int[] dp = new int[n+1];
		int max = 0;
		for(int i = 0; i< n ; i++) {
			max = Math.max(max, dp[i]); // 현재값이랑 기존의 max값 비교하여 max 업데이트
			if((i+t[i]) <= n){ // 넘어가지 않는 범위면 
				dp[i+t[i]] = Math.max(dp[i+t[i]], max+p[i]); // 내 자리에서 p만큼 떨어진 dp값을 *dp값*과 현재까지 *최대값 + 내자리의 보상* max값 넣어줌
			}
		}
		max = Math.max(max, dp[n]);
		System.out.println(max);

	}

}
