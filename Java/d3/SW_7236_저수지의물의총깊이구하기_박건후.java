package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SW 7236 저수지 물의 총깊이 구하기
 * 8방 탐색
 * @author Gunhoo
 *
 */
public class SW_7236_저수지의물의총깊이구하기_박건후 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dx = {-1,0,1,1,1,0,-1,-1};
		int[] dy = {-1,-1,-1,0,1,1,1,0};
		for(int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());// 저수지 구획 크기
			char[][] pond = new char[n+2][n+2];
			int ans = 0; 
			for(int i = 1; i<=n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=n ; j++) {
					pond[i][j] = st.nextToken().charAt(0);
				}
			}
			for(int i = 1 ; i<=n;i++) {
				for(int j =1 ; j<= n ; j++) {
					int tmp =0;
					if(pond[i][j] == 'G') continue; // G면 깊이 안늘어난다.
					for(int idx = 0; idx<8 ; idx++) { // 팔방으로 돌면서 
						if(pond[i+dx[idx]][j+dy[idx]] == 'W') { // W면
							tmp++; // 임시 깊이 추가
						}
					}
					ans = Math.max(ans, tmp); // 깊이가 더 깊으면 갱신
				}
			}
			if(ans==0)ans=1; // 아무것도 없을 때는 1이다.
			System.out.println("#"+test_case + " "+ans);
		}
	}

}
