package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BJ 10163 색종이
 * 
 * @author 박건후
 *
 */
public class BJ_10163_색종이 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[1001][1001]; // 배경
		int[][] papers = new int[n][4]; // 순서대로 저장히기 위한
		
		for(int i  = 0; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			papers[i][0] = Integer.parseInt(st.nextToken());
			papers[i][1] = Integer.parseInt(st.nextToken());
			papers[i][2] = Integer.parseInt(st.nextToken());
			papers[i][3] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i< n ; i++) { // n개의 색종이 수만큼
			for(int j = papers[i][0]; j < papers[i][0]+papers[i][2]; j++) { // 너비 시작부터 너비 끝까지
				for( int k = papers[i][1]; k < papers[i][1]+ papers[i][3] ; k++) { // 높이 시작부터 높이 끝까지
					map[j][k] = i+1; // 해당 면적에 자신의 값을 넣어준다.
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<= n ; i++) {
			int cnt = 0;
			for(int j = 0; j< 1001 ; j++) {
				for(int k = 0; k < 1001; k++) {
					if(map[j][k] == i )cnt++; // 값이 들어가 있으면 출력
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		
	}


}
