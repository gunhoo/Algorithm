package Gold.Gold5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 토마토
 * BFS풀이
 * @author 박건후
 *
 */
public class BJ_7576_토마토 {
	static int M, N ;
	static int[][] map, tmap;
	static LinkedList<Point> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmap = new int[N][M];
		list = new LinkedList<>();
		
		for(int i =0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 입력
				if(map[i][j] == 1) list.add(new Point(i, j));
			}
		}
		
		bfs();
		int ans = -1;
		boolean tf = false;
		for(int i =0 ; i < N; i++) {
			for(int j =0 ; j < M ; j++) {
				if(map[i][j] == 0 ) { // 0이 존재하면 안돼
					ans = 0; // 근데 존재하면 ans=0으로 초기화
					tf = true; // 탈출조건
					break; // 탈출
				}
				ans = Math.max(ans, map[i][j]); // ans값 갱신
			}
			if(tf) break; // 탈출
		}
		System.out.println(ans-1); // 출력
	}
	static int[] dx = {1,-1,0,0}; // 4방탐색
	static int[] dy = {0,0,1,-1}; // 4방탐색
	
	private static void bfs() {
		while (!list.isEmpty()) { // 모두 탐색
			Point point = list.remove(0); // 뽑고
			int x = point.x; 
			int y = point.y;
			for(int i =0 ; i < 4; i++) {
				int nx = x+dx[i]; // 4방 탐색
				int ny = y+dy[i]; // 4방 탐색
				if( 0<= nx && nx< N && 0<=ny && ny<M && map[nx][ny] == 0) { // 이동가능하면,
					map[nx][ny] = map[x][y]+1; // 시간값 갱신
					list.add(new Point(nx, ny)); // q에 넣어줘
				}
			}
		}
	}
		
}
