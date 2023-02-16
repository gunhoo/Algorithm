package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4 {
	static int n, m , k;
	static int[][] map, tmpMap;
	static boolean[][] visited;
	static int min = 5000; // 가질 수 있는 최대값(내용물 100 * M최대 50)
	static int r, c, s;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class Node{
		int x,y;
		int val;
		public Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.val = v;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		tmpMap = new int[n][m];
		
		for(int i = 0 ; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i< map.length ; i++) { // 현재 map을 복사한다 
            tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
		for(int test = 0 ; test < k ; test++) {
			visited = new boolean[n][m];
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			makeVisit();
			rotation();
//			for(int i = 0 ; i< n ; i++) {
//				for(int j = 0; j<m;j++) {
//					System.out.print(tmpMap[i][j]+" ");
//				}
//				System.out.println();
//			}
			
		}
		
	}
	private static void makeVisit() {
		for(int i = r-s-1 ; i < r+s ; i++) {
			for(int j = c-s-1; j< c+s; j++) {
				visited[i][j] = true;
			}
		}
		
	}
	private static void rotation() {
//		for(int i = 0 ; i< map.length ; i++) { // 현재 map을 복사한다 
//            tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
//        }
		int idx = -1;
		for(int i = r-s-1; i< (2*r+s)/2 ; i++) {
			idx++;// 대각선 수
			int y = c-s-1+idx; // 시작 y좌표
			int direction = 0;
			Queue<Node> q = new LinkedList<Node>();
			q.add(new Node(i,y, tmpMap[i][y]));
			while(!q.isEmpty()) {
				Node node = q.poll();
				visited[node.x][node.y] = false;
				int nx = node.x + dx[direction];
				int ny = node.y + dy[direction];
				if( nx<0 || ny<0 || nx >=n-idx || ny>=m-idx) { //범위 밖이면
					nx -= dx[direction]; // 방향 다시  되돌려 줌
					ny -=  dy[direction];
					direction = (direction+1)%4;
					nx += dx[direction];
					ny += dy[direction];
				}else if(visited[nx][ny] == false) { // 범위 안이고 다음좌표가 이미 방문했다면
					if ( !(nx == i && ny == y)) { // 근데 그게 시작지점이 아니면 껍데기를 만난거니까
						nx -= dx[direction]; // 방향 다시  되돌려 줌
						ny -=  dy[direction];
						direction = (direction+1)%4;
						nx += dx[direction];
						ny += dy[direction];
					}
				}
				int tmp = tmpMap[nx][ny]; // 다음 방문 위치의 값을 tmp에 넣어줌
				tmpMap[nx][ny] = node.val; // 다음 방문 위치의 값을 기존 node.val(옛날값)을 넣어줌
				if(visited[nx][ny] == false) break; // 마지막으로 업데이트 한 위치가 이미 방문한 위치에 만나면 break
				q.offer(new Node(nx, ny, tmp)); // 아니면 q에 넣어줘서 계속함, 이때 다음위치의 업데이트 되기 전 값(tmp)를 넣어줌
			}
		}
		// rotation이 다 끝나면 행 체크
		updateMin();
	}
	private static void updateMin() {
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum = 0;
			for(int j = 0; j < m ; j++) {
				sum += tmpMap[i][j];
			}
		}
		min = Math.min(min, sum);
	}

}
