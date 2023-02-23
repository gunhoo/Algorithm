package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 박건후
 *
 */
public class BJ_1260_DFS와BFS {
	static int N;
	static int[][] map;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		isSelected = new boolean[N+1]; // dfs를 위한 선택되었는지 체크하기 위한 함수
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1; // 간선 연결
		}
		
		dfs(V); // 시작점 dfs
		System.out.println();
		bfs(V); // 시작점 bfs
	}
	
	private static void dfs(int v) {
		isSelected[v] = true; // 자신을 true로 바꿔주고
		System.out.print(v+" "); // 출력
		for(int i = 1; i<= N ; i++) { // 모든 노드들에 대해 
			if(!isSelected[i] && map[v][i] == 1) { // 아직 방문하지 않았고, 연결되어있으면
				dfs(i); // 재귀
			}
		}
	}
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>(); // 너비 탐색을 위한 q
		boolean[] visited = new boolean[N+1]; // 방문체크를 위한 boolean
		visited[v] = true; // 자신을 방문체크하고
		q.add(v); // 큐에 넣어줘
		while(!q.isEmpty()) { // 모든 큐에 대해
			int n = q.poll(); // 하나 뽑고
			System.out.print(n+" "); // 출력하고
			for(int i =1; i<= N ; i++) { // 다른 모든 간선중에
				if( !visited[i] && map[n][i] == 1) { // 방문하지 않았고, 연결되어있으면
					visited[i] = true; // 방문처리
					q.offer(i); // 큐 삽입
				}
			}
		}
	}

}
