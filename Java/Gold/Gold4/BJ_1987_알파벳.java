package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 말은 4방향 이동 가능
 * 지금까지의 모든 경로와 달라야해  
 * 최대 몇칸 갈 수 있나?
 * 
 * 이동하면서, arrayList에 없으면
 * ArrayList에 넣고 이동
 * 더이상 갈 수 없으면 arrayList 사이즈 출력하면 돼
 * 
 * @author 박건후
 *
 */
public class BJ_1987_알파벳 {
	static int R, C;
	static char[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<Character> history = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i =0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j =0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		history.add(map[0][0]);
//		bfs(0,0,map[0][0]);
		System.out.println(history.size());
	}
	
	private static void dfs() {
		
	}
	/*
	private static void bfs(int a, int b, char ch) { // bfs로 풀면 안되고 dfs로 풀어야할듯 예제3번
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(a,b,ch));
		while(!q.isEmpty()) {
			Node node = q.poll();
			System.out.println(node.c);
			for(int i = 0 ; i < 4; i++) { // 4방향을오
				boolean tf = false;
				int nx = node.x + dx[i]; // 한칸이동
				int ny = node.y + dy[i];
				if(0<=nx && nx<R && 0<=ny && ny<C) { // 범위 내에 있고,
					for( char c : history) {//방문이력중에
						if( c == map[nx][ny]) { // 동일하면
							tf = true;
							break; // 탈출
						}
					}
					if(!tf) { // 방문이력중에 없으면
						history.add(map[nx][ny]);
						q.add(new Node(nx, ny, map[nx][ny]));
					}
				}
			}
			
		}
	}*/
	
	static class Node{
		int x, y;
		char c;
		public Node(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

}
