package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BJ 15683 감시(G4)
 * 1. 풀이방법
 * 		- 완탐
 *  	- switch문작성
 * 바로 바꾸면 안되고 모든 경우의 수 따져봐야해
 * 5번같은 경우는 바로 바꿀 수 있어.
 *  1은 3방향이상 막혀있으면 바로 끝낼 수 있어
 *  2는 2방향이상 막혀있으면 바로 끝낼 수 있어
 *  3은 2방향이상 막혀있으면 바로 끝낼 수 있어
 *  4는 1방향이상 막혀있으면 바로 끝낼 수 있어
 *  
 * @author gunhoo
 *
 */
public class BJ_15683_감시 {
	static int n, m;
	static int map[][];
	static ArrayList<Node> no5, cctv;
	static int answer = Integer.MAX_VALUE;
	static class Node{
		int x, y, num;
		public Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		no5 = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 5) no5.add(new Node(i, j, 5));
				else if(map[i][j] != 0) cctv.add(new Node(i, j, map[i][j]));
			}
		}
		cctvNo5(); // 5번은 무조건 4방향이므로 먼저 처리해준다.
		dfs(0); // 모든 경우의 수에 대해 탐색
	}
	
	private static void dfs(int cnt) {
		if( cnt == cctv.size()){ // cctv개수만큼 다 골랐으면
			answer = Math.min(answer, sum()); // 최솟값 업데이트
			return; // 종료조건
		}
		Node node = cctv.get(cnt);
		switch(node.num) {
		case 1:
			// 위
			up();
			dfs(cnt+1);
			// 오른쪽
			right();
			dfs(cnt+1);
			// 아래
			bottom();
			dfs(cnt+1);
			// 왼쪽
			left();
			dfs(cnt+1);
			break;
		case 2:
			// 위아래
			up();
			bottom();
			dfs(cnt+1);
			// 좌우
			left();
			right();
			dfs(cnt+1);
			break;
		case 3:
			// 상우
			dfs(cnt+1);
			// 우하
			dfs(cnt+1);
			// 하좌
			dfs(cnt+1);
			// 좌상
			dfs(cnt+1);
			break;
		case 4:
			// 상좌우
			dfs(cnt+1);
			// 상우하
			dfs(cnt+1);
			// 상좌하
			dfs(cnt+1);
			// 좌우하
			dfs(cnt+1);
			break;
		}
	}
	
	private static void up(int x, int y) {
		
	}
	private static void right(int x, int y) {
		
	}
	private static void left(int x, int y) {
		
	}
	private static void bottom(int x, int y) {
		
	}
	private static void cctvNo5() {// cctv 5번 녀석들 처리 로직
		while(no5.size() > 0 ) {
			Node five = no5.remove(0);
			for(int i = five.x ; i>= 0 ; i--) { // 위쪽탐색
				if( map[i][five.y] == 6 ) break;
				else if(map[i][five.y] == 0) map[i][five.y] = -1;
			}
			for(int i = five.x+1 ; i< n ; i++) { // 아래쪽탐색
				if( map[i][five.y] == 6 ) break;
				else if(map[i][five.y] == 0) map[i][five.y] = -1;
			}
			for(int i = five.y ; i>= 0 ; i--) { // 왼쪽탐색
				if( map[five.x][i] == 6 ) break;
				else if(map[five.x][i] == 0) map[five.x][i] = -1;
			}
			for(int i = five.y+1 ; i<m ; i++) { // 오른쪽탐색
				if( map[five.x][i] == 6 ) break;
				else if(map[five.x][i] == 0) map[five.x][i] = -1;
			}
		}
	}
	 /** 0인구역 모두 더해서 return해주는 메서드  @return sum*/
	private static int sum() { // 
		int sum = 0;
		for(int i = 0 ; i< n ; i++) {
			for(int j = 0 ; j< m ; j++) {
				if(map[i][j] == 0 ) sum++;
			}
		}
		return sum;
	}

}
