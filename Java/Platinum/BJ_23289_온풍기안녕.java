package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 모든 온풍기에서 바람이 나옴(0빈 1좌 2우 3상 4하 5조사해야하는칸)
 * 2. 온도 조절(4방향으로 퍼짐)
 * 3. 가장 바깥족 4면 온도 감소
 * 4. answer += 1;
 * 5. 조사해야하는 칸이 K이상인지 검사 > K이상이거나 answer가 100이면 종료
 * 6. answer 출력 
 * @author 박건후
 *
 */
public class BJ_23289_온풍기안녕 {
	static class Map{
		int t=0, info;
		boolean left=false, right=false, up=false, down=false;
		public Map(int info) {
			this.info = info;
		}
	}
	static class Point{
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static int R, C, K, W, answer = 0;
	static Map map[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception{
		init(); // 입력
		while(true) {
			upTemp(); // 온풍기 메서드
			manageTemp(); // 온도 조절 메서드
			deTemp(); // 온도 감소 메서드
			answer++; // 초콜릿 먹어
//			print();
			if(isGood() || answer == 101) { // 모든칸이 K이상이거나, 초콜릿 100번 넘어가면
				break;
			}
		}
		System.out.println(answer);
	}
	
	private static void upTemp() {
		for(int i =0 ;i < R; i++) {
			for(int j =0 ; j < C; j++) {
				if(map[i][j].info == 0 || map[i][j].info == 5)continue;
				visited = new boolean[R][C];
				Queue<Point> q = new ArrayDeque<>();
				switch(map[i][j].info) {
				case 2: // 좌
					q.offer(new Point(i, j-1, 5));
					while(!q.isEmpty()) {
						Point point = q.poll();
						if(point.cnt == 0) continue;
						if(point.x < 0 || point.x >= R || point.y < 0 || point.y >=C 
								|| visited[point.x][point.y]) continue;
						visited[point.x][point.y] = true;
						map[point.x][point.y].t += point.cnt;
						if(point.x-1 >= 0 && point.y-1>=0 
								&& !map[point.x][point.y].up && !map[point.x-1][point.y-1].right)
							q.offer(new Point(point.x-1, point.y-1, point.cnt-1));
						if(!map[point.x][point.y].left)
							q.offer(new Point(point.x, point.y-1, point.cnt-1));
						if(point.x+1 < R && point.y-1>=0 
								&& !map[point.x][point.y].down && !map[point.x+1][point.y-1].right)
							q.offer(new Point(point.x+1, point.y-1, point.cnt-1));
					}
					break;
				case 1://우
					q.offer(new Point(i, j+1, 5));
					while(!q.isEmpty()) {
						Point point = q.poll();
						if(point.cnt == 0) continue;
						if(point.x < 0 || point.x >= R || point.y < 0 || point.y >=C 
								|| visited[point.x][point.y]) continue;
						visited[point.x][point.y] = true;
						map[point.x][point.y].t += point.cnt;
						if(point.x-1 >= 0 && point.y+1<C 
								&& !map[point.x][point.y].up && !map[point.x-1][point.y+1].left)
							q.offer(new Point(point.x-1, point.y+1, point.cnt-1));
						if(!map[point.x][point.y].right)
							q.offer(new Point(point.x, point.y+1, point.cnt-1));
						if(point.x+1 < R && point.y+1<C 
								&& !map[point.x][point.y].down && !map[point.x+1][point.y+1].left)
							q.offer(new Point(point.x+1, point.y+1, point.cnt-1));
					}
					break;
				case 3://상
					q.offer(new Point(i-1, j, 5));
					while(!q.isEmpty()) {
						Point point = q.poll();
						if(point.cnt == 0) continue;
						if(point.x < 0 || point.x >= R || point.y < 0 || point.y >=C 
								|| visited[point.x][point.y]) continue;
						visited[point.x][point.y] = true;
						map[point.x][point.y].t += point.cnt;
						if(point.x-1 >= 0 && point.y-1>=0 
								&& !map[point.x][point.y].left && !map[point.x-1][point.y-1].down)
							q.offer(new Point(point.x-1, point.y-1, point.cnt-1));
						if(!map[point.x][point.y].up)
							q.offer(new Point(point.x-1, point.y, point.cnt-1));
						if(point.x-1 >= 0 && point.y+1<C 
								&& !map[point.x][point.y].right && !map[point.x-1][point.y+1].down)
							q.offer(new Point(point.x-1, point.y+1, point.cnt-1));
					}
					break;
				case 4://하
					q.offer(new Point(i+1, j, 5));
					while(!q.isEmpty()) {
						Point point = q.poll();
						if(point.cnt == 0) continue;
						if(point.x < 0 || point.x >= R || point.y < 0 || point.y >=C 
								|| visited[point.x][point.y]) continue;
						visited[point.x][point.y] = true;
						map[point.x][point.y].t += point.cnt;
						if(point.x+1 < R && point.y-1>=0 
								&& !map[point.x][point.y].left && !map[point.x+1][point.y-1].up)
							q.offer(new Point(point.x+1, point.y-1, point.cnt-1));
						if(!map[point.x][point.y].down)
							q.offer(new Point(point.x+1, point.y, point.cnt-1));
						if(point.x+1 < R && point.y+1<C 
								&& !map[point.x][point.y].right && !map[point.x+1][point.y+1].up)
							q.offer(new Point(point.x+1, point.y+1, point.cnt-1));
					}
					break;
				}
			}
		}
	}
	
	private static void manageTemp() {
		int tmap[][] = new int[R][C];
		for(int i =0 ; i < R ; i++) {
			for(int j =0; j  <C; j++) {
				tmap[i][j] = map[i][j].t;
			}
		}
		for(int i =0 ; i < R; i++) {
			for(int j =0 ; j < C; j++) {
				if(map[i][j].t == 0)continue;
				if(!map[i][j].up && i-1 >=0 && 3 < map[i][j].t-map[i-1][j].t) { // 위로 조절
					int tmp = (map[i][j].t-map[i-1][j].t)/4;
					tmap[i-1][j] += tmp;
					tmap[i][j] -= tmp;
				}
				if(!map[i][j].down && i+1<R && 3 < map[i][j].t-map[i+1][j].t ) { // 밑으로 조절
					int tmp = (map[i][j].t-map[i+1][j].t)/4;
					tmap[i+1][j] += tmp;
					tmap[i][j] -= tmp;
				}
				if(!map[i][j].left && j-1 >= 0 && 3 < map[i][j].t-map[i][j-1].t) { // 좌로 조절
					int tmp = (map[i][j].t-map[i][j-1].t)/4;
					tmap[i][j-1] += tmp;
					tmap[i][j] -= tmp;
				}
				if(!map[i][j].right && j+1 < C && 3 < map[i][j].t-map[i][j+1].t) { // 우로 조절
					int tmp = (map[i][j].t-map[i][j+1].t)/4;
					tmap[i][j+1] += tmp;
					tmap[i][j] -= tmp;
				}
				
			}
		}
		for(int i =0 ; i < R ; i++) {
			for(int j =0; j<C; j++) {
				map[i][j].t = tmap[i][j];
			}
		}
		
	}
	
	private static void deTemp() {
		for(int j =0 ; j <C; j++) {
			if(map[0][j].t != 0)
				map[0][j].t -= 1;
			if(map[R-1][j].t != 0)
				map[R-1][j].t -= 1;
		}
		for(int i = 1; i < R-1; i++) {
			if(map[i][0].t != 0)
				map[i][0].t -= 1;
			if(map[i][C-1].t != 0)
				map[i][C-1].t -= 1;
		}
	}
	
	private static boolean isGood() {
		for(int i =0 ; i < R; i++) {
			for(int j=0 ; j <C ; j++) {
				if(map[i][j].info != 5) continue; // 5만 조사하면 돼
				if(map[i][j].t < K )return false; // 온도가 K 미만인 얘가 존재하면 안돼
			}
		}
		return true;
	}
	
	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Map[R][C];
		for(int i =0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < C; j++) {
				map[i][j] = new Map(Integer.parseInt(st.nextToken()));
			}
		}
		W = Integer.parseInt(br.readLine());
		for(int i =0 ;i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			if(t == 0) {
				map[x][y].up = true;
				map[x-1][y].down = true;
			}else {
				map[x][y].right = true;
				map[x][y+1].left = true;
			}
		}
	}
	private static void print() {
		for(int i = 0; i < R; i++) {
			for(int j =0 ; j < C; j++) {
				System.out.print(map[i][j].t+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
