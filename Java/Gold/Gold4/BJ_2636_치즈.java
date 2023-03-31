package Gold.Gold4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	static int N, M;
	static int[][] map;
	static int totalCheese=0, beforeCheese=0;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int time =0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i =0 ; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]== 1) {
					totalCheese++;
				}
			}
		}
		while(time<3) {
			visited= new boolean[N][M];
			beforeCheese = 0;
			melting();
			time++;
			print();
		}
		System.out.println(time);
		System.out.println(beforeCheese);
	}

	private static int[] dx = {1,-1,0,0}; 
	private static int[] dy = {0,0,-1,1};
	
	private static void melting() {
		Queue<Point> melting = new ArrayDeque<>();
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					Queue<Point> q = new ArrayDeque<>();
					visited[i][j] = true;
					q.add(new Point(i, j));
					while(!q.isEmpty()) {
						Point ice = q.poll();
						for(int i1 =0 ;i1 < 4; i1++) {
							int nx = ice.x + dx[i1];
							int ny = ice.y + dy[i1];
							if(0<= nx && nx < N && ny>=0 && ny< M && map[nx][ny] == 1 && visited[nx][ny] == false) {
								visited[nx][ny] = true;
								q.add(new Point(nx, ny));
								for(int j1 = 0 ; j1 < 4; j1++) {
									int nnx = nx + dx[j1];
									int nny = ny + dy[j1];
									if(0<= nnx && nnx < N && nny>=0 && nny< M && map[nnx][nny] == 0) {
										melting.add(new Point(nx, ny));
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		
		while(!melting.isEmpty()) {
			Point p = melting.poll();
			System.out.println(p.x+" "+p.y);
			map[p.x][p.y] = 0;
			totalCheese--;
			beforeCheese++;
		}
	}
	
	private static void print() {
		for(int i =0 ; i < N ;i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
