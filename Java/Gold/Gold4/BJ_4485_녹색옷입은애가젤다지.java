package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷입은애가젤다지 {
	static int dx[] = {1,-1,0,0}; // 4방탐색을 위한 변수
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 1; // 테케
		int[][] map; // 지도
		int[][] dp; // memoization을 위한 배열
		while(true) { // 0을 받을 때 까지 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if( N == 0 ) break; // 0이면 탈출
			map = new int[N][N]; // 배열 생성
			dp = new int[N][N]; // 배열 생성

			for(int i =0 ; i < N ; i++) { // 입력
				st = new StringTokenizer(br.readLine());
				for(int j =0 ;j < N ;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = Integer.MAX_VALUE; /// 최솟값구하는것이므로 최대값으로 초기화
				}
			}
			dp[0][0] = map[0][0]; // 시작셋팅
			Queue<Node> q = new ArrayDeque<>(); // 4방탐색을 위한 q
			q.add(new Node(0,0)); 
			while(!q.isEmpty()) {
				Node pos = q.poll();
				for(int dir = 0; dir <4 ; dir++) { // 4방향으로,
					int nx = pos.x + dx[dir]; // 이동해서,
					int ny = pos.y + dy[dir];
					if(0<=nx && nx < N && 0<=ny && ny < N) { // 범위 내면,
						if(dp[nx][ny] > dp[pos.x][pos.y]+map[nx][ny]) { // 근데 그게 값이 지금경로보다 크면
							dp[nx][ny] = dp[pos.x][pos.y]+map[nx][ny]; // 메모값 갱신
							q.add(new Node(nx,ny)); // 큐에 넣어줘
						}
					}
				}
			}
			
			System.out.println("Problem "+test_case+": "+ dp[N-1][N-1]); // 가장오른쪽아래 값이 최솟값
			test_case++; // 테케증가
		}
		
	}
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
