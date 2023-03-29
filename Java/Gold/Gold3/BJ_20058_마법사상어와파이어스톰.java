package Gold.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 분할정복으로 돌려
 * 2. 4방탐색해서 0 두개있으면 -1해 
 * 3. 모든 얼음의 합 출력
 * 4. bfs로 돌면서 가장큰 면적 구해
 * 
 * @author 박건후
 *
 */
public class BJ_20058_마법사상어와파이어스톰 {
	static int N, Q, mapSize;
	static int[][] map;
	static int remainIce;
	static int dumpSize = 0;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		mapSize = (int)Math.pow(2, N);
		map = new int[mapSize][mapSize];
		
		
		for(int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < mapSize ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				remainIce += map[i][j];
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < Q; i++) {
			visited = new boolean[mapSize][mapSize];
			int L = Integer.parseInt(st.nextToken());
			fireStorm(0, 0, L); // 돌리기
			sinking(); // 0이거나 바깥으로간 칸이 2개이상인 칸들을 -1해줌
		}
		getDummySize();
		System.out.println(remainIce); 
		System.out.println(dumpSize); // 가장 큰 면적
	}
	
	private static void fireStorm(int startX, int startY, int L) {
		// startX, startY부터 startX+2^L, startY+2^L까지가 범위
		// 그걸 돌리고,
		// startX+2^L, startY+2^L 둘다 mapSize-1 이면, 재귀안해
		// 둘다 mapSize-1이 아니면, fireStorm(startX+2^L, startY+2^L, L호출)
		int tmpSize = (int)(Math.pow(2, L));
		int[][] tmp = new int[tmpSize][tmpSize];
		for(int i = 0; i < tmpSize; i++) {
			for(int j = 0 ; j< tmpSize; j++) {
				tmp[i][j] = map[i+startX][j+startY]; 
			}
		}
		for(int i = 0; i < tmpSize; i++) {
			for(int j = 0 ; j< tmpSize; j++) {
				map[i+startX][j+startY] = tmp[tmpSize-j-1][i]; 
			}
		}
		if(startY+tmpSize != mapSize ) {
			fireStorm(startX, startY+tmpSize, L);
		}else if(startX+tmpSize != mapSize) {
			fireStorm(startX+tmpSize, 0, L);
		}
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	private static void sinking() { // 남아있는 얼음의 양 : 처음값에서 줄어든 얼음의 양을 뺀다
		int[][] tmpMap = new int[mapSize][mapSize];
		for(int i = 0 ; i < mapSize; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		for(int i=0; i < mapSize; i++) {
			for(int j = 0; j < mapSize ; j++) {
				if(map[i][j] == 0) continue;
				int zeroCnt = 0;
				for(int k =0 ; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if( nx < 0 || nx >= mapSize || ny < 0 || ny >= mapSize || map[nx][ny] == 0) {
						zeroCnt++; // 범위밖으로 나가면, 인접해있지 않아
					}
				}
				if( zeroCnt >= 2) {
					tmpMap[i][j]--;
					remainIce--;
				}
			}
		}
		map = tmpMap;
	}
	
	private static void getDummySize() {
		Queue<Node> q = new ArrayDeque<>();
		for(int i =0; i < mapSize*mapSize; i++) {
			int size = 0;
			if(map[i/mapSize][i%mapSize] != 0 && !visited[i/mapSize][i%mapSize]) {
				size++;
				q.add(new Node(i/mapSize, i%mapSize));
				while(!q.isEmpty()) {
					Node node = q.poll();
					visited[node.x][node.y] = true;
					for(int j =0; j < 4; j++) {
						int nx = node.x+dx[j];
						int ny = node.y+dy[j];
						if(nx<0 || nx>=mapSize || ny <0 || ny >= mapSize || map[nx][ny] == 0 || visited[nx][ny]) continue;
						if(map[nx][ny] != 0 ) {
							size++;
							q.add(new Node(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
			dumpSize = Math.max(dumpSize, size);
		}
		
	}
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	private static void print() {
		for(int i =0 ;i < mapSize; i++) {
			for(int j =0 ; j < mapSize; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
