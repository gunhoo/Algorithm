package SWTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 맨위에서부터
 * 	1부터 n-1까지 보면서
 * 		size = 1~n-1까지 
 * 		대각선으로 size만큼 가면서 size만큼 다 가거나, 0또는n-1만나면 꺾어 
 * @author Gunhoo
 *
 */
public class SW_2105_디저트카페 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb =new StringBuilder();
		for(int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			answer = -1;
			for(int i =0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {-1,1,1,-1};
	
	private static void bfs() {
		for(int size=1; size<=N-1; size++) {
			for(int size2 = 1; size2 <= N-1; size2++) {
				for(int i =0 ; i <= N-3; i++) {
					out :for(int j = 1; j < N-1; j++) {
						visited = new boolean[101];
						int dir = 0;
						visited[map[i][j]] = true;
						int nx = i;
						int ny = j;
						for(int k = 0 ; k < size2; k++) {
							nx = nx + dx[dir];
							ny = ny + dy[dir];
							if(visited[map[nx][ny]]) continue out;
							visited[map[nx][ny]] = true;
							if(ny == 0|| nx == N-1 || ny == N-1 || k == size2-1) {
								dir++;
								break;
							}
						}
						if(nx == N-1) continue out;
						for(int k = 0 ; k < size; k++) {
							nx = nx + dx[dir];
							ny = ny + dy[dir];
							if(nx == N || ny == N) continue out;
							if(visited[map[nx][ny]]) continue out; 
							visited[map[nx][ny]] = true;
							if(nx == N-1 || k == size-1) {
								dir++;
								break;
							}
						}
						
						for(int k = 0 ; k < size2; k++) {
							nx = nx + dx[dir];
							ny = ny + dy[dir];
							if(nx == 0 || ny == N) continue out;
							if(visited[map[nx][ny]]) continue out; 
							visited[map[nx][ny]] = true;
							if(ny == N-1 || k == size2-1) {
								dir++;
								break;
							}
						}
						if(nx == 0 || ny == 0) continue out;
						for(int k = 0 ; k < size; k++) {
							nx = nx + dx[dir];
							ny = ny + dy[dir];
							if(nx == i && ny == j ) break;
							if(nx == 0 || ny == 0) continue out;
							if(visited[map[nx][ny]]) continue out; 
							visited[map[nx][ny]] = true;
							if(nx == 0 || k == size-1) {
								dir++;
								break;
							}
						}
						if(nx==i && ny == j) { // 복귀에 성공헀으면,
							count();
						}
					}
				}
			}
			
		}
		
	}
	private static void count() {
		int sum = 0;
		for(int i =0; i < 101; i++) {
			if(visited[i]) {
				sum++;
			}
		}
		if (sum < 4) return;
		answer = Math.max(answer, sum);
	}
	
}
