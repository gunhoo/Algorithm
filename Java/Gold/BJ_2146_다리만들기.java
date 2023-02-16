package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 섬을 arraylist<Node>로 넘기고 tmpMap을 0으로 만들어줘 > arrayList에서 하나씩 뽑아서 map에 있는 1이랑 비교
 * (a-x + b-y -1) : 다리수
 * 다리수 1인거 찾으면 바로 탈출 : 시간단축 
 * @author gunhoo
 *
 */
public class BJ_2146_다리만들기 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int min;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		min = 2*n-3; // maximun 값으로 설정
		
		for(int i = 0 ; i< n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		// 입력 완료 //
		int landNum = 1;
		for(int i = 0 ; i< n; i++) {
			for(int j = 0 ; j< n ; j++) {
				if(map[i][j] == 1) {
					seperateIslands(i, j, ++landNum);
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				if(map[i][j] != 0 && !isolated(i, j)) {
					visited = new boolean[n][n];
					findOther(i, j, map[i][j]);
				}
			}
		}
		 // 마지막 섬에서 시작
		System.out.println(min);
		
	}
	private static void findOther(int a, int b, int curVal) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a, b,0));
		visited[a][b]= true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i =0 ; i< 4 ; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if( 0<= nx && nx < n && 0<=ny && ny < n && !visited[nx][ny] && map[nx][ny] != curVal) {
					visited[nx][ny] = true;
					if( map[nx][ny] != 0 ) {// 0이 아니고 , 자신과 다른 섬을 찾으면
						min = Math.min(min, node.dis);
						if(min <= 1) return;
					}
					else { // 바다면 탐색해야해
						q.add(new Node(nx, ny, node.dis+1));
					}
				}
			}
		}
	}
	
	private static void seperateIslands(int a , int b, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a, b,0));
		map[a][b]= c;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0 ; i< 4 ; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if( 0<= nx && nx < n && 0<=ny && ny < n && map[nx][ny] == 1) {
					map[nx][ny] = c;
					q.add(new Node(nx, ny,0));
				}
			}
		}
		
	}
	private static boolean isolated(int x, int y) { // 사방탐색해서 하나라도 0발견되면 고립된게 아님
		if(map[x][y-1>=0?y-1:0] == 0) return false; // 왼쪽
		if(map[x][y+1<n?y+1:y] == 0) return false; 
		if(map[x-1>=0?x-1:x][y] == 0) return false;
		if(map[x+1<n?x+1:x][y] == 0) return false; //false는 해안가란 소리임
		return true; // true 리턴하면 고립된거임(해안x)
	}
	static class Node{
		int x, y;
		int dis;
		public Node(int a, int b, int d) {
			this.x = a;
			this.y = b;
			this.dis = d;
		}
	}

}
