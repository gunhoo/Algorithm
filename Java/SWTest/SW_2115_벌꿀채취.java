package SWTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2115_벌꿀채취 {
	static int N, M, C; // M은 선택한 벌통의 사이즈야(크기)
	static int[][] map, honey;
	static int max;
	static boolean[][] visited;
	static int incomes[];
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test_case = 1;test_case <= t ; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited =new boolean[N][N];
			selected = new boolean[M];
			honey = new int[2][M];
			
			for(int i =0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// implement my logic here
			max = 0;
			// 조합으로 0~n^2-1까지 숫자 중 m개씩 2개 골라, 중복되면 안돼
			combination(visited, 0,0);
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}
	private static void combination(boolean[][] visited, int start, int cnt) {
		if(cnt == 2) { //2명 골랐으면
			incomes = new int[2];
			getMaxIncome(0,0,0); // 0번 일꾼의 maxIncome
			getMaxIncome(1,0,0); // 1번 일꾼의 maxIncome
			max = Math.max(max, incomes[0]+incomes[1]); // 기존 값이랑 비교
			return;
		}
		for(int i = start; i < N ; i++) {
			boolean tf = false;
			for(int j = 0; j<N;j++) {
				if(j+M > N) continue; // 범위 밖이면 x
				for(int k =0; k < M ; k++) { // M개 만큼
					if(visited[i][j+k]) { // 방문된 곳이면
						tf = true;
						break;
					}
				}
				if(tf) continue; // continue
				for(int k = 0; k<M; k++) {
					visited[i][j+k] = true; // 방문처리
					honey[cnt][k] = map[i][j+k];
				}
				combination(visited, start, cnt+1);
				
				for(int k = 0;k <M ; k++) 
					visited[i][j+k] = false; // 방문해제
				
			}
		}
	}
	
	
	private static void getMaxIncome(int worker, int sum, int income) {
		incomes[worker] = Math.max(incomes[worker], income);
		for(int i =0; i < M ; i++) {
			if(selected[i]) continue;
			if( sum + honey[worker][i] <= C) { // 채취할 수 있는거면
				selected[i] = true;
				getMaxIncome(worker, sum+honey[worker][i], income+honey[worker][i]*honey[worker][i]);
				selected[i] = false;
			}
		}
	}
	

	
	
	
	
	
	
}
