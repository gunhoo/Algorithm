package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 1. 풀이방법  :DFS, 탈출조건 확인
 * @author 박건후
 *
 */
public class BJ_3109_빵집 {
	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int answer=0;
	static int[] dx = {-1,0,1};
	static ArrayList<Integer> start;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m]; // 전체 지도를 담는 변수
		visited = new boolean[n][m]; // 방문했는지 판별하기 위한 변수
		start = new ArrayList<>(); // 시작지점(1열)을 담기 위한 변수
		for(int i = 0 ; i< n ; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0 ; j<m; j++) {
				map[i][j] = str[j].charAt(0);
			}
			if(map[i][0] != 'x' ) start.add(i);
		}
		for(int i : start) { // 모든 시작점에 대해
			dfs(new Node(i, 0)); // dfs이용			
		}
 
		System.out.println(answer);
	}
	
	private static boolean dfs(Node cur) {
		if ( cur.y == m-1) { // 만약 끝에 도달했다면
			answer++;  // 정답 1증가
			return true;
		}
		
		for(int i =0 ; i< 3; i++) {
			int nx = cur.x + dx[i]; // 위, 중간, 아래 방향으로 이동
			if(0<=nx && nx<n &&  map[nx][cur.y+1] == '.' && visited[nx][cur.y+1] == false) { // 범위 내이고, 갈 수 있고, 방문하지 않았다면
				visited[nx][cur.y+1] = true; // 방문했다고 하고,
				map[nx][cur.y+1] = 'x'; // 벽으로 바꿔버리고, 
				if(dfs(new Node(nx, cur.y+1))) return true; // 한칸이동하여 다시 탐색한다.
//					visited[nx][ny] = false; // 시간 초과의 원인(Greedy하게 풀어야해)
//					map[nx][ny] = '.'; // 왜냐하면 탐색에 성공하면 굳이 이후 과정을 볼 필요가 없기 때문(Backtracking)
			}
		}
	
		return false;
	}
	
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
