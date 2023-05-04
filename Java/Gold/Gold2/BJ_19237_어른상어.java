package Gold.Gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1234 상하좌우
 * 
 * @author 박건후
 *
 */
public class BJ_19237_어른상어 {
	private static int N, M, k, totalSharks, time =0;
	private static Map[][] map;
	private static Shark[] sharks;
	private static int[][] directions = {{}, {-1,0}, {1,0}, {0,-1}, {0,1}};
	
	public static void main(String[] args) throws Exception{
		init();
		while(true) {
			move();
			time++;
			if(totalSharks == 1 || time == 1000) break; // 상어가 한마리만 남거나, 시간이 1000초가 됐으면
		}
		System.out.println(time==1000?-1:time);
	}
	
	private static void move() {
		for(int i = M ; i >= 1; i--) { // 1번상어부터 움직여
			int dir = sharks[i].dir;
			int possible = 0;
			for(int j =0 ; j < 4; j++) { // 4방향으로 움직일 수 있어, (우선순위 적용해야해)
				int newDir = sharks[i].primaryDir[dir][j]; // 이게 이동방향
				int nx = sharks[i].x + directions[newDir][0];
				int ny = sharks[i].y + directions[newDir][1];
				if(0>nx || nx >= N || ny<0 || ny>=N ) continue;


			}
//			map[sharks[i].x][sharks[i].y];
		}
	}

	
	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		totalSharks = M;
		map = new Map[N][N];
		sharks = new Shark[M+1];
		for(int i =0 ;i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < N  ; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 0) map[i][j] = new Map(false, 0, 0);
				else map[i][j] = new Map(true, tmp, k);
				sharks[tmp] = new Shark(i,j, tmp, 0);
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i =0 ;i < totalSharks ; i++) {
			sharks[i].dir = Integer.parseInt(st.nextToken());
		}
		for(int i =0 ; i < totalSharks ; i++) {
			for(int j =0 ; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 4; k++) {
					sharks[i].primaryDir[j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}

	private static class Map{
		boolean isShark;
		int sharkNum, life;
		public Map(boolean isShark, int s, int l) {
			super();
			this.isShark = isShark;
			this.sharkNum = s;
			this.life = l;
		}
	}
	private static class Shark{
		int x, y, num, dir;
		int[][] primaryDir;
		
		public Shark(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.primaryDir = new int[4][4];
		}
	}
}
