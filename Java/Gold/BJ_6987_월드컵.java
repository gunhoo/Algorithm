package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경우의 수 에 대해 모두 탐색, 
 * @author 박건후
 *
 */
public class BJ_6987_월드컵 {
	static int[] home = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] away = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[][] nation = new int[6][3];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int test_case = 0; test_case < 4 ; test_case++) {
			st = new StringTokenizer(br.readLine());
			int[] sum = new int[6];
			for(int i = 0 ; i< 6;i++) {
				nation[i][0] =  Integer.parseInt(st.nextToken());
				nation[i][1] =  Integer.parseInt(st.nextToken());
				nation[i][2] =  Integer.parseInt(st.nextToken());
				sum[i] += nation[i][0]+nation[i][1]+nation[i][2];
			}
			boolean tf = false;
			for(int sumI : sum) {
				if (sumI != 5) { // 1팀당 5경기 안했으면 
					System.out.print("0 "); // 불가능
					tf = true; // 회기 조건
					break; // 탈출
				}
			}
			if(tf) continue;
			if (dfs(0)) System.out.print("1 ");
			else System.out.print("0 ");
			
		}
	}
	
	private static boolean dfs(int num) {
		if( num == 15) return true;
	
		if( nation[home[num]][0] != 0 && nation[away[num]][2] != 0) { // 홈 이기고 어웨이 질 때 
			nation[home[num]][0] -= 1;
			nation[away[num]][2] -= 1;
			if(dfs(num+1)) return true; // 끝났을 경우 끝내
			nation[home[num]][0] += 1; // 아니면 원복
			nation[away[num]][2] += 1; 
		}
		
		if(nation[home[num]][1] != 0 && nation[away[num]][1] != 0) { // 비길 때 
			nation[home[num]][1] -= 1;
			nation[away[num]][1] -= 1;
			if( dfs(num+1) ) return true;
			nation[home[num]][1] += 1;
			nation[away[num]][1] += 1;
		}
		
		if( nation[home[num]][2] != 0 && nation[away[num]][0] != 0) { // 홈지고 어웨이 이길 때
			nation[home[num]][2] -= 1;
			nation[away[num]][0] -= 1;
			if(dfs(num+1)) return true;
			nation[home[num]][2] += 1;
			nation[away[num]][0] += 1;
		}

		return false;
	}
	
}
