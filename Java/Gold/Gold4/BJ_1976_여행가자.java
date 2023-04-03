package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_여행가자 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st= null;
		for(int i =0 ;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i != j && map[i][j] == 0) map[i][j] = 100001;
			}
		}
		for(int k =0 ; k < N ; k++) {
			for(int i = 0;i < N ;i++) {
				for(int j =0; j < N;j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int from = 0, to;
		boolean tf = false;
		for(int i = 0; i<M/2; i++) {
			from = Integer.parseInt(st.nextToken())-1;
			to  = Integer.parseInt(st.nextToken())-1;
			if(map[from][to] != 100001 && map[to][from] != 100001) {
				continue;
			}else {
				tf = true;
				break;
			}
		}
		if(M%2 != 0)
			if(map[from][Integer.parseInt(st.nextToken())-1] == 100001) {
				tf = true;
			}
		if(tf) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
	}

}
