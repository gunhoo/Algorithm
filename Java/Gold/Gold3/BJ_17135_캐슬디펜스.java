package Gold.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 모든 위치에 궁수 놓아봐
 * @author 박건후
 *
 */

public class BJ_17135_캐슬디펜스 {
	static int N, M, D;
	static int answer = 0;
	static int[][] map,tmpMap ;
	static int totalEnemy = 0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Comparator<Node> range;
	static int count;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmpMap = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) totalEnemy++;
			}
		}
		putArcher();
		System.out.println(answer);
	}
	private static void putArcher() { // 모든 경우의 수에 대해 아쳐를 놓는다.
		for(int i = 0 ; i < N*M-2; i++) {
			if(map[i/M][i%M] == 1) continue;
			for(int j = 0; j < N*M-1; j++) {
				if(map[j/M][j%M] == 1) continue;
				for(int k = 0; k < N*M; k++) {
					if(map[k/M][k%M] == 1) continue;
					map[i/M][i%M] = -1; // 세 궁수를 설치하고
					map[j/M][j%M] = -1;
					map[k/M][k%M] = -1;
					game(i/M, i%M, j/M, j%M, k/M, k%M);// 궁수가 잡는 메서드 dfs로 해야할 것 같아
					map[i/M][i%M] = 0; // 세 궁수 원복
					map[j/M][j%M] = 0;
					map[k/M][k%M] = 0;
				}
			}
		}
	}
	private static void game(int aX, int aY, int bX, int bY, int cX, int cY) { // 궁수가 적을 잡는 메서드 , dfs써서 깊이만큼 탐색해야하고, 적을 움직여야해
		for(int i = 0 ; i < N ; i++) {  // 원본은 수정하면 안돼
			tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		int tmp = totalEnemy;
		count = 0;
		while(totalEnemy>0) { // 적이 하나라도 존재하면 계속해야해
			range = new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.y == o2.y) return o1.x-o2.x; // 오름차순 , 뒤에서부터뽑으면 큰값
					return o2.y-o1.y; // 내림차순 정렬, 뒤에서부터 뽑으면 가장 작은 y값 먼저 나가니깐.
				}
				
			};
			dfs(aX, aY,0); // 궁수가 잡는 로직
			range = new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.y == o2.y) return o1.x-o2.x; // 오름차순 , 뒤에서부터뽑으면 큰값
					return o2.y-o1.y; // 내림차순 정렬, 뒤에서부터 뽑으면 가장 작은 y값 먼저 나가니깐.
				}
				
			};
			dfs(bX, bY,0); // 궁수가 잡는 로직
			range = new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.y == o2.y) return o1.x-o2.x; // 오름차순 , 뒤에서부터뽑으면 큰값
					return o2.y-o1.y; // 내림차순 정렬, 뒤에서부터 뽑으면 가장 작은 y값 먼저 나가니깐.
				}
				
			};
			dfs(cX, cY,0); // 궁수가 잡는 로직
			for(int i = 0 ; i < M; i++) { //맨밑에칸
				if ( tmpMap[N-1][i] == 1) totalEnemy -= tmpMap[N-1][i]; // 적이면 빼줘
			}
			for(int i =N-2 ; i >= 0 ; i--) { // 밑에서 한칸 띄고부터봐
				for(int j = M-1 ; j >= 0 ; j--) {
					if(map[i+1][j]== -1){ // 밑칸이 궁수면
						if(map[i][j] == 1) totalEnemy -= map[i][j]; // 적이있으면 죽었으니 빼줘 
						continue; // 덮어씌지 않고 패스
					}else { // 밑칸이 궁수가 아니면 덮어쓸 수 있다.
						if(tmpMap[i][j] == -1) { // 근데 윗칸에 궁수 있으면
							tmpMap[i+1][j] = 0; // 밑칸은 위에서 내려오지 않고 0이 나오겠지
						}else { // 둘다 궁수가 없으면
							tmpMap[i+1][j] = tmpMap[i][j]; // 아니면 한칸씩 밑으로 옮겨
						}
					}
						
				}
			}
			for(int i =0 ; i < M; i++) { // 맨 윗칸은 0으로 만들어
				tmpMap[0][i] = 0; 
			}
		}
		answer = Math.max(answer, count);
		totalEnemy = tmp; // 다시 원복
	}
	// bfs로 구현해야 할 듯 
	private static void bfs(int a, int b) { // 궁수의 위치를 받고
		visited = new boolean[N][M];
		visited[a][b] = true;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a,b));
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(Math.abs(node.x-a)+Math.abs(node.y-b) == D+1) break; // 사정거리 밖이면 탈출
			for(int j =0 ; j < 4; j++) {
				int nx = node.x+dx[j];
				int ny = node.y+dy[j];
				if( 0<= nx && nx<N && 0<=ny && ny < M ) {
					if(map[nx][ny] == 1) // 적이 있으면
						range.add(new Node(nx, ny)); // 넣어줘
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		
	}
	/*
	private static void dfs(int a, int b, int depth) { // 궁수의 위치를 받고
		// arrayList에 1인놈들 좌표 
		if(depth == D) { // 종료 로직
			if(range.size() > 0) { // 적이 있으면
				Node dead = range.poll(); // 가장 왼쪽아래적 뽑아서
				count++;
				map[dead.x][dead.y] = 0; // 0으로 만들어
				
			}
			return;
		}
		for(int i =0 ; i < 4; i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			if( 0<= nx && nx<N && 0<=ny && ny < M ) {
				if(map[nx][ny] == 1) // 적이 있으면
					range.add(new Node(nx, ny)); // 넣어줘
				dfs(nx, ny, depth+1);
			}
		}
		
	}*/
	
	static class Node{
		int x, y;
		public Node(int a,int b) {
			this.x = a;
			this.y= b;
		}
	}
}
