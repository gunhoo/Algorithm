package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 플로이드 워샬
 * @author 박건후
 *
 */
public class D4_5643_키순서 {
	static int N, M, map[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t;  test_case++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i =0 ;i < N ; i++) {
				for(int j =0 ; j < N; j++) {
					if(i == j) continue;
					map[i][j] = 1000001;
				}
			}
			for(int i =0 ; i <M; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
			}
			
			for(int k = 0; k< N; k++) {
				for(int i =0 ; i < N ; i++) {
					for(int j =0 ;j < N ; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]); // 거리 갱신(플로이드-워샬)
					}
				}
			}
			
			int answer = N;
			for(int i=0; i < N ;i++) {
				for(int j = 0 ; j <N; j++) {
					if(map[i][j] != 1000001) map[j][i]=map[i][j]; // 밑으로 갈 수 있음을 나타냄
				}
			}

			for(int i=0; i < N ;i++) {
				for(int j = 0 ; j <N; j++) {
					if(map[i][j] == 1000001) {// 못가는게 있다면
						answer--; // 위치를 모르는 놈임
						break; // 탈출
					}
				}
			}
			System.out.println("#"+test_case +" "+answer);
			
		}
		
	}
}
