package d4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class D4_1868_파핑파핑지뢰찾기 {
	static int N;
	static String[][] map, tmap;
	static int answer;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int test_case = 1; test_case <= t ; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new String[N][N];
			tmap = new String[N][N];
			answer = Integer.MAX_VALUE;
			for(int i =0 ; i < N ; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j < N ; j++) {
					map[i][j] = str[j];
				}
			}
			for(int i =1 ; i < N*N; i++) {
				for(int ii =0 ; ii<N; ii++) {
					tmap[ii] = Arrays.copyOf(map[ii], map[ii].length);
				}
				if(bfs(i)) {
					answer = i;
					break;
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	private static boolean bfs(int cnt) {
		String[][] ttmap = new String[N][N];
		if( cnt ==0 ) {
			for(int i = 0; i < N ; i++) {
				for(int j =0 ; j < N ; j++) {
					if(tmap[i][j].equals(".")) return false; // 하나라도 탐색 안된 곳이 있으면
				}
			}
			return true; // 다돌았는데 없으면 true
		}
		
		for(int i =0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(tmap[i][j].equals(".")) {
					for(int ii =0 ; ii<N; ii++) {
						ttmap[ii] = Arrays.copyOf(tmap[ii], tmap[ii].length);
					}
					count(i, j);
//					print();
					if(bfs(cnt-1)) return true;
					else {
						tmap = ttmap;
						return false;
					}
				}
			}
		}
		return false;
	}
	private static void print() {
		for(int i =0 ; i < N ; i++) {
			for(int j = 0 ; j  < N ; j++) {
				System.out.print(tmap[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void count(int a, int b) {
		int sum = 0;
		LinkedList<Point> list = new LinkedList<>();
		list.add(new Point(a,b));
		while(!list.isEmpty()) {
			Point point = list.remove(0);
			sum = 0;
			for(int i =0 ; i < 8 ; i++) {
				int nx = point.x+dx[i];
				int ny = point.y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N ) {
					if(tmap[nx][ny].equals("*")) sum++;
				}
			}
			if(sum != 0) tmap[point.x][point.y] = ""+sum;
			else {
				for(int i =0 ; i < 8 ; i++) {
					int nx = point.x+dx[i];
					int ny = point.y+dy[i];
					if(0<=nx && nx<N && 0<=ny && ny<N ) {
						if(tmap[nx][ny].equals("."))
							list.add(new Point(nx, ny));
					}
				}
				tmap[point.x][point.y] = "0";
			}
		}
		
//		return ""+sum;
	}
}
