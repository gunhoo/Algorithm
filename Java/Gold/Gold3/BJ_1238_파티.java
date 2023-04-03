package Gold.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1238_파티 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		int[][] map = new int[N][N];
		for(int i = 0; i < N ; i++) {
			for(int j =0; j < N;j++) {
				if(i == j ) map[i][j] = 0;
				else map[i][j] = 1000001;
			}
		}
		for(int i =0 ; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], d);
		}
		
		for(int k = 0 ; k < N ; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N ; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int answer = 0;
		for(int i=0 ;i < N; i++) {
			answer = Math.max(answer, map[i][X]+map[X][i]);
		}
		System.out.println(answer);
	}

}
