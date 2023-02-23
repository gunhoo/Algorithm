package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static int dan = 2;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static ArrayList<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			String[] st = br.readLine().split("");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		search();
		System.out.println(dan-2); // 단지수 출력
		Collections.sort(answer); // 정렬
		while(!answer.isEmpty()) System.out.println(answer.remove(0)); // 세대수 출력
	}
	
	private static void search() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if (map[i][j] == 1) { // 1발견하면
					bfs(i, j); // bfs 돌림
				}
			}
		}
	}
	
	private static void bfs(int a, int b) {
		int sum = 0;//세대수 저장 위한 변수
		Queue<Node> q = new LinkedList<>(); // 큐
		q.add(new Node(a,b)); // 초기값 넣어주고
		while(!q.isEmpty()) {
			Node node = q.poll(); // 큐에서 뽑아
			for(int i = 0 ; i < 4; i++) { // 4방탐색
				int nx = node.x+dx[i]; // 이동
				int ny = node.y+dy[i]; // 이동
				if (0<= nx && nx<N && 0<=ny && ny<N && map[nx][ny] == 1) { // 범위 내고 1이면
					map[nx][ny] = dan; // 단지수로 바꿔
					sum++; // 세대수 증가
					q.add(new Node(nx, ny)); // 큐에 넣어줘
				}
			}
		}
		dan++; // 단 증가 // 사실 이 문제에선 안해도 됨
		answer.add(sum>0?sum:1); // 일단 bfs로 들어왔다는게 1이 존재하는건데 sum이 0이면 이동한게 없다는 것이므로 1으로 치환
	}
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
