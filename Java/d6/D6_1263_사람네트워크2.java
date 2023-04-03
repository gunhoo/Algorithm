package d6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D6_1263_사람네트워크2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case<= t; test_case++) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i =0 ;i < N ; i++) {
				for(int j = 0; j< N ;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0) map[i][j] = 100000000; // 충분히 큰 값
				}
			}
			
			for (int k = 0; k < N; k++) { // 경유지
				for (int i = 0; i < N; i++) { // 출발지
					for (int j = 0; j < N; j++) { // 도착지
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]); // 갱신
					}
				}
			}
			int answer = Integer.MAX_VALUE;
			for(int i =0 ;i < N ;i++) {
				int sum =0;
				for(int j =0 ; j < N; j++) {
					sum += map[i][j];
				}
				answer = Math.min(answer, sum);
			}
			System.out.println("#"+test_case+" "+answer);
				
		}
	}

}
