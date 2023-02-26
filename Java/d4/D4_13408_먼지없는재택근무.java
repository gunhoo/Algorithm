package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 거리에 대한 조건이 명시되어있지 않음
 * 맨하탄 거리 아님 
 * 유클리드 거리 아님
 * 한칸전진하고, 그 행/열에서 좌우로 봤을 때 가장짧은 거리, 거리가 같다면 가장 오른쪽
 * @author 박건후
 *
 */
public class D4_13408_먼지없는재택근무 {
	static int N;
	static int[][] map;
	static Node robot;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t ; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0 ; i< N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			robot = new Node(0,0);
			String[] commands = br.readLine().split("");
			for(String s : commands) {
				visited =new boolean[N][N];
				execute(s.charAt(0));
			}
			sb.append("#").append(test_case).append("\n");
			print();
		}
		System.out.print(sb);
	}
	private static void execute(char command) {
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> cand = new ArrayList<>();
		q.add(robot);
		visited[robot.x][robot.y] =true;
		switch(command) {
		case 'R':
			while(!q.isEmpty()) {
//				if(cand.size() >= 1) break;
				Node node = q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = node.x +dx[i];
					int ny = node.y + dy[i];
					// 범위 내에 있고, 기울기가 -1이상 1이하면 추가
					if(0<=nx && nx<N && 0<=ny && ny<N && ny > robot.y && -1.0<=(nx-robot.x)*1.0/(ny-robot.y) &&(nx-robot.x)*1.0/(ny-robot.y)<=1.0 && !visited[nx][ny]) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						if(map[nx][ny] == 1) cand.add(new Node(nx, ny));//먼지면 후보에 넣어줘
					}
				}
			}
			Collections.sort(cand, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					int d1 = Math.abs(o1.x-robot.x)+Math.abs(o1.y-robot.y);
					int d2 = Math.abs(o2.x-robot.x)+Math.abs(o2.y-robot.y);
					if( o1.y==o2.y) {
						if( Math.abs(o2.x-robot.x)== Math.abs(o1.x-robot.x))return o1.x-o2.x;
						return Math.abs(o2.x-robot.x)-Math.abs(o1.x-robot.x); // 거리 같으면 가장 오른쪽(x값 가장 큰)
					}
					return 	o2.y-o1.y; // 내림차순정렬
				}
				
			});
			break;
		case 'U':
			while(!q.isEmpty()) {
//				if(cand.size() >= 1) break;
				Node node = q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = node.x +dx[i];
					int ny = node.y + dy[i];
					if(0<=nx && nx<N && 0<=ny && ny<N && nx < robot.x && -1.0<=(ny-robot.y)*1.0/(nx-robot.x)&&(ny-robot.y)*1.0/(nx-robot.x)<=1.0 && !visited[nx][ny] ) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						if(map[nx][ny] == 1) cand.add(new Node(nx, ny));
					}
				}
			}
			Collections.sort(cand, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					int d1 = Math.abs(o1.x-robot.x)+Math.abs(o1.y-robot.y);
					int d2 = Math.abs(o2.x-robot.x)+Math.abs(o2.y-robot.y);
					if( o1.x==o2.x) {
						if(Math.abs(o1.y-robot.y)==Math.abs(o2.y-robot.y)) return o1.y-o2.y;
						return Math.abs(o2.y-robot.y)-Math.abs(o1.y-robot.y);
					}
					return 	o1.x-o2.x; // 내림차순정렬
				}
				
			});
			break;
		case 'D':
			while(!q.isEmpty()) {
//				if(cand.size() >= 1) break;
				Node node = q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = node.x +dx[i];
					int ny = node.y + dy[i];
					if(0<=nx && nx<N && 0<=ny && ny<N && nx > robot.x && -1.0<=(ny-robot.y)*1.0/(nx-robot.x)&&(ny-robot.y)*1.0/(nx-robot.x)<=1.0 && !visited[nx][ny] ) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						if(map[nx][ny] == 1) cand.add(new Node(nx, ny));
					}
				}
			}
			Collections.sort(cand, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					int d1 = Math.abs(o1.x-robot.x)+Math.abs(o1.y-robot.y);
					int d2 = Math.abs(o2.x-robot.x)+Math.abs(o2.y-robot.y);
					if( o1.x==o2.x) {
						if(Math.abs(o2.y-robot.y)==Math.abs(o1.y-robot.y)) return o2.y-o1.y;
						return Math.abs(o2.y-robot.y)-Math.abs(o1.y-robot.y);
					}
					return 	o2.x-o1.x; // 내림차순정렬
				}
				
			});
			break;
		case 'L':
			while(!q.isEmpty()) {
//				if(cand.size() >= 1) break;
				Node node = q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = node.x +dx[i];
					int ny = node.y + dy[i];
					if(0<=nx && nx<N && 0<=ny && ny<N && ny < robot.y && -1.0<=(nx-robot.x)*1.0/(ny-robot.y) &&(nx-robot.x)*1.0/(ny-robot.y)<=1.0 && !visited[nx][ny] ) {
						q.add(new Node(nx, ny));
						visited[nx][ny] = true;
						if(map[nx][ny] == 1) cand.add(new Node(nx, ny));
					}
				}
			}
			Collections.sort(cand, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					int d1 = Math.abs(o1.x-robot.x)+Math.abs(o1.y-robot.y);
					int d2 = Math.abs(o2.x-robot.x)+Math.abs(o2.y-robot.y);
					if( o1.y==o2.y) {
						if(Math.abs(o1.x-robot.x)==Math.abs(o2.x-robot.x))return o2.x-o1.x;
						return Math.abs(o2.x-robot.x)-Math.abs(o1.x-robot.x);
					}
					return 	o1.y-o2.y; // 내림차순정렬
				}
				
			});
			break;
		}
		if(cand.size() != 0) { // 먼지가 0개가 아니면
			Node nextPos = cand.remove(cand.size()-1); // 가장 짧고 오른쪽에 있는 녀석 뽑아
			robot = nextPos; // 로봇 위치 갱신
			map[robot.x][robot.y] = 0; // 로봇위치 0으로 바꿈
		}
		
	}
	private static void print() {
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
