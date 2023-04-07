package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16930_달리기 {
	static int N, M, K, x1, x2, y1,y2, answer=Integer.MAX_VALUE;
	static Node map[][];
	static int direction[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	static class Node{
		int x, y, second;
		char c;
		public Node(int x, int y, int second, char c) {
			this.x = x;
			this.y = y;
			this.second = second;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception  {
		input();
		bfs();
//		print();
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	
	private static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x1, y1, 0, '.'));
		map[x1][y1].second = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.second >= answer) continue;
			if(node.x == x2 && node.y == y2) {
				answer = Math.min(answer, node.second);
				continue;
			}
			out: for(int i =0 ;i < 4 ;i++) {
				for(int k = 1 ; k <= K ; k++) {
					int nx = node.x + direction[i][0]*k;
					int ny = node.y + direction[i][1]*k;
					if(0>nx || N<=nx || 0>ny || ny>=M || map[nx][ny].second == node.second+1) continue;
					if( map[nx][ny].c != '.'|| map[nx][ny].second < node.second+1) continue out;
					map[nx][ny].second = node.second+1;
					q.offer(new Node(nx, ny, node.second+1, '.'));
				}
			}
		}
	}
	private static void print() {
		for(int i =0; i < N;i++) {
			for(int j =0 ; j < M ; j++) {
				System.out.print(map[i][j].second+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void input()throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Node[N][M];
		for(int i =0 ; i < N ; i++) {
			String input = br.readLine();
			for(int j =0 ; j < M ;j++) {
				map[i][j] = new Node(i,j, Integer.MAX_VALUE, input.charAt(j));
			}
		}
		st= new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken())-1;
		y1 = Integer.parseInt(st.nextToken())-1;
		x2 = Integer.parseInt(st.nextToken())-1;
		y2 = Integer.parseInt(st.nextToken())-1;
	}
}
