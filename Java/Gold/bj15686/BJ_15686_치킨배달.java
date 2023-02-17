package Gold.bj15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * BJ 15686 치킨배달
 * - 1. 구현방법
 * 		- BF, Back-tracking
 * @author 박건후
 *
 */
public class BJ_15686_치킨배달 {
	private static int[][] city;
	private static ArrayList<Node> chickens = new ArrayList<Node>();
	private static ArrayList<Node> homes = new ArrayList<Node>();
	private static boolean[] visited;
	private static int m;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		city = new int[n][n];
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n ; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 2)// 치킨집이면,
					chickens.add(new Node(i, j)); // 치킨집 담는 arrayList에 넣어줘 
				else if (city[i][j] == 1) // 집이면,
					homes.add(new Node(i, j)); // 집 담는 arrayList에 넣어줘
			}
		}
		
		visited = new boolean[chickens.size()];// 모든 치킨집에 대한 visited boolean 생성
		backtracking(0,0);// backtracking
		System.out.println(min);
		
	}
	private static void backtracking(int depth, int count) {
		if(depth == m) {// 종료조건
			int chickenDistance = 0;
			for(int i = 0; i< homes.size();i++) {// 모든 집에 대해
				int sum = Integer.MAX_VALUE; // 최솟값을 구해야하므로 초기값은 최대값으로 지정
				for(int j = 0; j< chickens.size(); j++) {
					if(visited[j]) {
						int distance = Math.abs(homes.get(i).x-chickens.get(j).x)	
								+ Math.abs(homes.get(i).y-chickens.get(j).y);// manhattan거리 계산
						sum = Math.min(sum, distance); // 업데이트 
					}
				}
				chickenDistance += sum; // 치킨거리 더해주고
			}
			min = Math.min(chickenDistance, min); // 최솟값갱신
			return;
		}
		for(int i = count; i< chickens.size(); i++) {
			if(visited[i] == false) { // 방문하지 않은 곳에 대해
				visited[i] = true; // 방문했다고하고 
				backtracking(depth + 1, i + 1); // dfs
				visited[i] = false; // 다시 방문할 수 있으므로 방문체크 해제
			}
		}
	}
	public static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
