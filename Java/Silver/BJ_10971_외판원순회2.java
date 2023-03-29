package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2 {
	static int N;
	static int map[][];
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i =0 ;i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ;j < N ;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int j =0 ; j< N ;j++) // 시작지점이 어디냐에서 부터 시작
			for(int i =0 ;i < N ; i++) { // 
				if( i == j || map[j][i] == 0) continue; // 본인이거나 길이없으면 안돼
				visited = new boolean[N];
				visited[i] = true;
				dfs(j, i, 1, map[j][i]); // j에서 i로 이동, 1번 고른거고, 거리는 
			}
		System.out.println(answer);
	}
	
	private static void dfs(int start, int num, int cnt, int distance) {
		if (cnt == N) { // N만큼 모두 골랐으면,
			if( start != num) return; // 자신으로 회기 안했으면 그냥 종료
			for(int i = 0; i < N ;i++) if(!visited[i]) return; // 하나라도 방문 안한거 있으면 종료
			answer = Math.min(answer, distance);  //지금까지 왔던길과 answer값 비교 후 갱신
			return;
		}
		for(int i = 0; i < N ; i++) {
			if( i == num ) continue; // 자기 자신으로는 안감
			if(map[num][i] != 0 && !visited[i]) { // 연결돼있으면
				visited[i] = true; // 방문처리하고, 
				dfs(start, i, cnt+1, distance+map[num][i]); // dfs
				visited[i] = false; // 다른 경로 탐색해야하므로 visit 원복
			}
		}
	}

}
