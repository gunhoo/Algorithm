package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * greedy처럼 생겼으나  greedy로 해결하지 못함
 * BFS로 3방향 탐색해야해
 * @author 박건후
 *
 */
public class BJ_1697_숨바꼭질 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bfs(N, K);
	}
	
	private static void bfs(int N, int K) {
		int[] dp = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while(!q.isEmpty()){
			int a = q.poll();
			if(a == K ) { // 이동한 거리가 동생의 위치면
				System.out.println(dp[a]); // 시간을 출력
				return;
			}
			int[] cand = {a-1, a+1, 2*a}; // 갈 수 있는 곳은 -1, +1, x2
			for(int i : cand) { //  후보지 중에
				if( 0<= i && i<= 100000 && dp[i] == 0) { // 그게 범위 내에 있고, 방문하지 않은 곳이라면
					dp[i] = dp[a]+1; // 이동시간 증가
					q.add(i); // 큐에 넣어줌
				}
			}
		}
	}

}
