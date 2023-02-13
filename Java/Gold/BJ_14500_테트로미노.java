package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ 14500 테트로미노
 * 정사각형 4개를 이어붙인 모양 : 테트로미노(5종)
 * 1. 풀이방법
 * bfs인데 조건을 상하죄우 아니고 각모양별로dxdy따로 만들어서
 * 1,1 ~ n,m까지 탐색하여(완전탐색)max값 업데이트하기
 *  > 각 모양별 dxdy 조건 만들기..? 너무 많은 경우의 수(모양 뒤집어도 되니깐)
 * 1-2 풀이방법2
 * 그냥 본인 위치에서 dfs 돌리는데 깊이 4가 되면 종료
 * > 잘못됐어
 * 1-3 풀이방법3
 * bfs로 풀어야해 
 * 2. 풀이시간
 * 10:38~11:46
 * @author Gunhoo
 *
 */
public class BJ_14500_테트로미노 {
	static int[][] map;
	static int max = 0;
	static boolean[][] visited;
	static int n,m;
	static int tmpMax = 0;
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,1); // x, y, depth
		System.out.println(max);
	}
	private static void dfs(int a, int b, int depth) {
		if( depth == 4) {
			if(tmpMax > max) {
				max = tmpMax;
				System.out.println("***max : "+max);
			}
			tmpMax -= map[a][b];
			visited[a][b] = false;
			return;
		}
		visited[a][b] = true; 
		for(int i = 0 ; i< n ; i++) {
			for(int j = 0 ; j< m ; j++) {
				if(visited[i][j]==false) { // 아직 방문 안한 친구들
					visited[i][j] = true;// 본인은 트루로 바꿔주고
					System.out.println("tmpMax: "+tmpMax);
					tmpMax += map[i][j];
					System.out.println("map: "+map[i][j]);
					dfs(i,j, depth++); // 자신의 위치에서 depth+1넘겨주고 다시 dfs
					System.out.println("tmpMax after dfs: "+tmpMax);
				}
			}
		}
	}

}
