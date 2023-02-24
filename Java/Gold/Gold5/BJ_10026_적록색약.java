package Gold.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author 박건후
 *
 */
public class BJ_10026_적록색약 {
	static int  N;
	static char[][] map, tmpMap; // 일반맵, 적록색약을 위한 맵
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0}; // bfs 위한 
	static int[] dy = {0,0,-1,1};
	static int index = 0; // 정답
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		tmpMap = new char[N][N];
		for(int i = 0 ; i < N ; i ++) {
			String[] str = br.readLine().split("");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str[j].charAt(0);
				tmpMap[i][j] = str[j].charAt(0);
				if(tmpMap[i][j] == 'G') tmpMap[i][j] = 'R'; // 하나를 아예 없애버려
			}
		}
		bfs(map);
		System.out.print(index+" ");
		index = 0; // 초기화
		visited = new boolean[N][N]; // 초기화
		bfs(tmpMap); // 적록색약
		System.out.println(index);
		
	}
	
	private static void bfs(char[][] map) {
		for(int i = 0; i < N ; i++) {
			for(int j =0; j < N ; j++) {
				if (map[i][j] == 'R' ||map[i][j] == 'G' || map[i][j] == 'B' ) { // 색깔이 존재하면
					Queue<Node> q = new LinkedList<Node>(); // 큐생성
					q.add(new Node(i, j)); // 큐에 넣어주고
					visited[i][j] = true; // 방문처리
					while(!q.isEmpty()) { // 갈 수 있을 때까지
						Node node = q.poll();
						for(int k =0 ; k < 4; k++) { // 4방향으로
							int nx = node.x + dx[k]; // 이동
							int ny = node.y + dy[k]; // 이동
							// 범위내에 있고, 이동한 부분의 색깔이 이전 부분의 색깔과 같고, 방문하지 않은 곳이라면,
							if( 0<= nx && nx<N && 0<= ny && ny<N && map[nx][ny] == map[i][j] && !visited[nx][ny]) {
								map[nx][ny]  = 'A'; // 그곳에 쓰레기값 저장
								visited[nx][ny] = true; // 방문처리
								q.add(new Node(nx, ny)); // 다음 탐색을 위해 큐에 넣어줘
							}
						}	
					}
					map[i][j] = 'A'; // 기존값 쓰레기값으로 처리
					index++; // 정답 (구역) 1 증가
				}
			}
		}
	}
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
