package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 조합, 재귀
 * @author 박건후
 *
 */
public class BJ_3040_백설공주와일곱난쟁이 {
	static int[] kids, realKids;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		kids  = new int[9];
		realKids = new int[7];
		
		for(int i = 0 ; i< 9;  i++) {
			kids[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0,0);
	}
	
	private static void dfs(int cnt, int start) {
		if(cnt == 7) { // 7난장이 다 골랐으면
			int sum = 0; // sum 이 100인지 확인하기 위한 변수
			for(int i : realKids) sum += i; // realKids후보에 있는 놈들 다 더해
			if (sum == 100) { // 100 이면 끝낼 수 있어
				StringBuilder sb = new StringBuilder();
				for(int i : realKids) sb.append(i).append('\n'); // 출력
				System.out.print(sb);
				return; // 종료
				
			}
			return; // 종료조건
		}
		for(int i = start ; i < 9 ; i++) {
			realKids[cnt] = kids[i]; // 선택
			dfs(cnt+1, i+1); // 현재 난장이 고르고, 무게 더해주고
		}
	}

}
