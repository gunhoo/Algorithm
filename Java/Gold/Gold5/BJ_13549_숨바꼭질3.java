package Gold.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * greedy처럼 생겼으나  greedy로 해결하지 못함
 * BFS로 3방향 탐색해야해
 * @author 박건후
 *
 */
public class BJ_13549_숨바꼭질3 {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N>= K) {
			System.out.println((N-K)+"\n");
			return;
		}else {
			bfs(N, K);
			System.out.println(min);
		}
	}
	
	private static void bfs(int N, int K) {
		int[] dp = new int[100001];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		dp[N]= 1;
		while(!q.isEmpty()){
			int a = q.poll();
			if(min < dp[a]) return;
//			if(a == K ) { // 이동한 거리가 동생의 위치면
//				if(min > dp[a]) {
//					min = dp[a];
//					ans =1;
//				}else if(min == dp[a]) {
//					ans++;
//				}
//				continue;
////				System.out.println(dp[a]); // 시간을 출력
////				return;
//			}
			int[] cand = {a+1, a-1, 2*a}; // 갈 수 있는 곳은 -1, +1, x2
			for(int i : cand) { //  후보지 중에
				if( 0<= i && i<= 100000) { // 그게 범위 내에 있고, 방문하지 않은 곳이라면
					if(i == K) {
						min = dp[a];
					}
					if( dp[i] == 0 || dp[i] == dp[a]+1) {
						if(i == a*2) dp[i] = dp[a];
						else dp[i] = dp[a]+1; // 이동시간 증가
						q.add(i); // 큐에 넣어줌
					}
					
				}
			}
		}
	}

}
