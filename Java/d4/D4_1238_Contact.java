package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact {
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int test_case = 1; test_case <=10; test_case++) {
			map = new int[101][101]; // 초기화
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken()); // 크기 
			int start = Integer.parseInt(st.nextToken()); // 시작점
			
			st = new StringTokenizer(br.readLine());
			for(int i =0 ; i < size/2 ; i++) {
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			System.out.println("#"+test_case + " "+ bfs(start));
		}
	}
	
	private static int bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		ArrayList<Integer> list = new ArrayList<>();
		while(!q.isEmpty()) {
			int size = q.size();
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < size; i++) {
				int node = q.poll();
				for(int j = 1; j < 101; j++) {
					if(map[node][j] == 1 && !visited[j]) { // 연결되어있고, 방문하지 않았따면
						visited[j] = true; // 방문처리
						q.add(j); // 큐에 넣어주고
						max = Math.max(max, j); // max값 갱신
					}
				}
			}
			list.add(max); // max값 넣어줘
		}
		return list.get(list.size()-2); 
	}

}
