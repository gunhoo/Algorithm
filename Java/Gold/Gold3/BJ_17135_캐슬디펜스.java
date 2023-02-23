package Gold.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
	static PriorityQueue<Node> range;
	static int count;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		tmpMap = new int[N+1][M];
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
		for(int i = 0 ; i < M-2; i++) {
			for(int j = i+1; j < M-1; j++) {
				for(int k = j+1; k < M; k++) {
					map[N][i] = -1; // 세 궁수를 설치하고
					map[N][j] = -1;
					map[N][k] = -1;
					game(i,j,k);// 궁수가 잡는 메서드 dfs로 해야할 것 같아
					map[N][i] = 0; // 세 궁수 원복
					map[N][j] = 0;
					map[N][k] = 0;
				}
			}
		}
	}
	private static void game(int a, int b, int c) { // 궁수가 적을 잡는 메서드 , dfs써서 깊이만큼 탐색해야하고, 적을 움직여야해
		for(int i = 0 ; i < N+1 ; i++) {  // 원본은 수정하면 안돼
			tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		int tmp = totalEnemy;
		count = 0;
		while(totalEnemy>0) { // 적이 하나라도 존재하면 계속해야해
			target = new ArrayList<Node>(); // 중복된 target을 지정했을 경우 처리하기 위한 변수
			range = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.d == o2.d) return o1.y-o2.y; // 오름차순 , 뒤에서부터뽑으면 큰값
					return o1.d-o2.d; // 내림차순 정렬, 뒤에서부터 뽑으면 가장 작은 y값 먼저 나가니깐.
				}
				
			});
			bfs(N, a); // 궁수가 잡는 로직
			range = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.d == o2.d) return o1.y-o2.y; // 오름차순 , 뒤에서부터뽑으면 큰값
					return o1.d-o2.d; // 내림차순 정렬, 뒤에서부터 뽑으면 가장 작은 y값 먼저 나가니깐.
				}
				
			});
			bfs(N, b); // 궁수가 잡는 로직
			range = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.d == o2.d) return o1.y-o2.y; // 오름차순 , 뒤에서부터뽑으면 큰값
					return o1.d-o2.d; // 내림차순 정렬, 뒤에서부터 뽑으면 가장 작은 y값 먼저 나가니깐.
				}
				
			});
			bfs(N, c); // 궁수가 잡는 로직
			if( target.size() == 3) {
				if( target.get(0).x == target.get(1).x && target.get(0).y == target.get(1).y) {
					count--;
					totalEnemy++;
				}
				if( target.get(0).x == target.get(2).x && target.get(0).y == target.get(2).y) {
					count--;
					totalEnemy++;
				}
				if( target.get(2).x == target.get(1).x && target.get(2).y == target.get(1).y) {
					count--;
					totalEnemy++;
				}
				if(target.get(0).x == target.get(1).x && target.get(0).y == target.get(1).y &&
						target.get(0).x == target.get(2).x && target.get(0).y == target.get(2).y) {
					count++;
					totalEnemy--;
				}
				tmpMap[target.get(0).x][target.get(0).y] = 0;
				tmpMap[target.get(1).x][target.get(1).y] = 0;
				tmpMap[target.get(2).x][target.get(2).y] = 0;
			}else if(target.size() == 2) {
				if( target.get(0).x == target.get(1).x && target.get(0).y == target.get(1).y) {
					count--;
					totalEnemy++;
				}
				tmpMap[target.get(0).x][target.get(0).y] = 0;
				tmpMap[target.get(1).x][target.get(1).y] = 0;
			}else if(target.size() == 1) {
				tmpMap[target.get(0).x][target.get(0).y] = 0;
			}
			
			/** 여기서부턴 한칸 이동 */
			for(int i = 0 ; i < M; i++) { //맨밑에칸
				if ( tmpMap[N-1][i] == 1) totalEnemy -= tmpMap[N-1][i]; // 적이면 빼줘
				tmpMap[N-1][i] = 0;
			}
			for(int i =N-2 ; i >= 0 ; i--) { // 밑에서 한칸 띄고부터봐
				for(int j = M-1 ; j >= 0 ; j--) {
					tmpMap[i+1][j] = tmpMap[i][j]; // 아니면 한칸씩 밑으로 옮겨
				}
			}
			for(int i =0 ; i < M; i++) { // 맨 윗칸은 0으로 만들어
				tmpMap[0][i] = 0; 
			}
		}
		
		
		answer = Math.max(answer, count);
		totalEnemy = tmp; // 다시 원복
	}
	static ArrayList<Node> target;
	// bfs로 구현해야 할 듯 
	private static void bfs(int a, int b) { // 궁수의 위치를 받고
		visited = new boolean[N+1][M];
		visited[a][b] = true;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a,b, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(Math.abs(node.x-a)+Math.abs(node.y-b) >= D) break; // 사정거리 밖이면 탈출
			for(int j =0 ; j < 4; j++) { // 사방탐색하면서
				int nx = node.x+dx[j];
				int ny = node.y+dy[j];
				if( 0<= nx && nx<N && 0<=ny && ny < M && !visited[nx][ny]) {
					if(tmpMap[nx][ny] == 1) // 적이 있으면
						range.add(new Node(nx, ny, Math.abs(node.x-a)+Math.abs(node.y-b))); // 넣어줘
					q.offer(new Node(nx, ny, Math.abs(node.x-a)+Math.abs(node.y-b)));
					visited[nx][ny]= true;
				}
			}
		}
		// range에는 적이 있는 놈들 다 있음
		if(range.size() > 0) { // 적이 있으면
			Node dead = range.poll(); // 가장 왼쪽아래적 뽑아서
			target.add(dead);
			count++; // 죽인 횟수 증가
//			tmpMap[dead.x][dead.y] = 0; // 죽은 곳은 0으로 만들어
			totalEnemy--; /// 중복할 수 있으니까 일단 놔둬
			
		}
	}

	private static void print() {
		for(int i = 0 ; i <= N ; i++){
			for(int j = 0 ; j < M ; j++) {
				System.out.print(tmpMap[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static class Node{
		int x, y, d;
		public Node(int a,int b, int d) {
			this.x = a;
			this.y= b;
			this.d = d;
		}
	}
}
