package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BJ_16926 배열돌리기
 * bfs로 배열 돌리자 하 > 우 > 상 > 좌 (범위가 넘어가면 방향 바꿔주기)
 * tmp값을 저장하고 값 1증가 
 * @author 박건후
 *
 */
public class BJ_16926_배열돌리기1_박건후 {
	static class Node{
		int x,y;
		int val;
		public Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.val = v;
		}
	}
	static int n,m, r;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<= r; i++) {
			visited = new boolean[n][m];
			bfs();
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j< m ; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	private static void bfs() {
		for(int i = 0; i<Math.min(n, m)/2 ; i++) {
			int direction = 0;
			Queue<Node> q = new LinkedList<Node>();
			q.add(new Node(i,i, map[i][i]));
			while(!q.isEmpty()) {
				Node node = q.poll();
				visited[node.x][node.y] = true;
				int nx = node.x + dx[direction];
				int ny = node.y + dy[direction];
				if( nx<0 || ny<0 || nx >=n-i || ny>=m-i) { //범위 밖이면
					nx -= dx[direction]; // 방향 다시  되돌려 줌
					ny -=  dy[direction];
					direction = (direction+1)%4;
					nx += dx[direction];
					ny += dy[direction];
				}else if(visited[nx][ny] == true) { // 범위 안이고 다음좌표가 이미 방문했다면
					if ( !(nx == i && ny == i)) { // 근데 그게 시작지점이 아니면 껍데기를 만난거니까
						nx -= dx[direction]; // 방향 다시  되돌려 줌
						ny -=  dy[direction];
						direction = (direction+1)%4;
						nx += dx[direction];
						ny += dy[direction];
					}
				}
				int tmp = map[nx][ny]; // 다음 방문 위치의 값을 tmp에 넣어줌
				map[nx][ny] = node.val; // 다음 방문 위치의 값을 기존 node.val(옛날값)을 넣어줌
				if(visited[nx][ny] == true) break; // 마지막으로 업데이트 한 위치가 이미 방문한 위치에 만나면 break
				q.offer(new Node(nx, ny, tmp)); // 아니면 q에 넣어줘서 계속함, 이때 다음위치의 업데이트 되기 전 값(tmp)를 넣어줌
			}
		}
	}

}
