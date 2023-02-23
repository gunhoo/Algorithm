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
 * 1. 풀이방법
 * 		- BFS로 시도하였으나, 예제3처럼 막혀있는 경우 새로운 경로를 찾을 수 없음
 * 		- DFS로 재시도, 성공
 * 
 * @author 박건후
 *
 */
public class BJ_1987_알파벳 {
	static int R, C;
	static char[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[] visited = new boolean[26]; // 알파벳 개수만큼 설정
	static int answer = 0;
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
		visited[map[0][0]-65] = true; // 처음은 방문헀으니까 true로 바꿔주고
		dfs(0,0,1); // 재귀
		System.out.println(answer);
	}
	
	private static void dfs(int a, int b, int cnt) {
		answer = Math.max(answer, cnt); // 현재까지 고른 갯수와 answer와 비교/갱신
		for(int i = 0 ; i < 4; i++) { // 4방탐색
			int nx = a+dx[i]; // 한칸이동
			int ny = b+dy[i]; // 한칸이동
			if( 0<= nx && nx<R && 0<= ny && ny<C ) { // 갈 수 있으면
				if(visited[map[nx][ny]-'A']) continue; // 만약 방문했었다면 패스
				visited[map[nx][ny]-'A'] = true; // 방문처리해주고
				dfs(nx, ny, cnt+1); // 재귀
				visited[map[nx][ny]-'A'] = false; // 방문해제
			}
		}
	}

}
