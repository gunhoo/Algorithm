package Gold.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *	연결되어있는지 확인 
 * @author 박건후
 *
 */
public class BJ_13023_ABCDE {
	static int N,M;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int answer =0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N]; // N개만큼 생성
		for(int i = 0 ; i < N ; i++)
			map[i] = new ArrayList<>(); // 새롭게 생성
		
		for(int i=0 ; i < M ; i++) {
			st =new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b); // a번째에 b숫자 넣어
			map[b].add(a); // b번째에 a숫자 넣어
		}
		if(M<4) System.out.println(0); // 간선의 수가 4보다 작으면 불가능
		else {
			for(int i =0  ;  i  < N; i++) {
				visited = new boolean[N]; // 초기화
				if(dfs(i, 1)) break; // 탈출조건
			}
			System.out.println(answer);
		}
		
	}
	private static boolean dfs(int num, int depth) {
		if(depth == 5) { // 깊이 5만큼 들어왔으면 성공한거니까
			answer = 1; // 갱신하고
			return true; // 탈출
		}
		visited[num] = true;
		for(int i =0 ; i < map[num].size() ; i++) {
			if(!visited[map[num].get(i)]) { // 방문하지 않은 곳이라면 
				visited[map[num].get(i)] = true; // 방문처리 
				if(dfs(map[num].get(i), depth+1)) return true; // 시간단축용
				visited[map[num].get(i)]= false; // 방문해제 처리
			}
		}
		return false;
	}
}
