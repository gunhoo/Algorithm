package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 풀이방법
 * 		- 현재방 값보다 1큰 방으로 이동할 수 있음
 * 		- 완탐 BFS
 * 1,1 ~ n,n
 * @author 박건후
 *
 */
public class D4_1861_정사각형방_박건후 {
	static int n;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int answer, room;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t ; test_case++) {
			answer = 0;
			n = Integer.parseInt(br.readLine());
			room = n*n;
			map = new int[n+1][n+1];
			for(int i = 1 ; i <= n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1 ; j <= n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝
			for(int i = 1 ; i<= n ; i++) {			// bfs돌기
				for(int j = 1 ; j<= n ; j++) {
					bfs(i,j);
				}
			}
			System.out.println("#"+test_case+" "+ room + " "+answer);
		}
	}
	private static void bfs(int a, int b ) {
		int sum = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a,b));
		while(!q.isEmpty()) {
			Node node = q.poll(); // 큐에서 뽑고
			for(int i = 0 ; i<4 ; i++) { // 4방향 탐색
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				if( 0< nx && nx<=n && 0<ny && ny<=n && map[nx][ny] == map[node.x][node.y]+1) {
					q.add(new Node(nx, ny)); // 큐에 다음 노드 넣어준다ㅏ.
					sum++; // 이동한 갯수 증가
					break; // 1증가된거 만나면 for문 도는거 의미 없다. 왜냐하면 중복된 숫자는 나오지 않기 때문이다.
				}
			}
		}
		if(sum != 1) { // 만약 이동했다면
			if( sum > answer) { // 근데 그게 기존에 가지고 있던 것보다 많이 이동했다면
				answer = sum; // 업데이트 
				room = map[a][b]; // 업데이트 
			}
			else if( sum == answer ) { // 만약 같다면
				room = Math.min(room, map[a][b]); // 작은걸로 업데이트
			}
			
		}
		
	}
	
	static class Node{
		int x, y;
		public Node(int a, int b) {
			this.x=a;
			this.y =b;
		}
	}

}
