package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * dfs 문제 : 선택/선택하지 않음
 * @author 박건후
 *
 */
public class D3_5215_햄버거다이어트_박건후 {
	public static class Hamburger{
		int score;
		int calo;
		public Hamburger(int s, int c) {
			this.score = s;
			this.calo = c;
		}
	}
	static int n, l, answer;
	static Hamburger[] hamb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= t; test_case++) {
			answer = 0; // 초기화
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			hamb = new Hamburger[n];
			for(int i = 0 ; i< n ; i++) { // 입력
				st = new StringTokenizer(br.readLine());
				hamb[i] = new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			select(0,0,0); // 선택 (고른개수, 누적점수, 토탈칼로리)
			System.out.println("#"+test_case + " "+answer);
			
		}
	}
	
	private static void select(int idx, int score, int calo) {
		if(calo > l) return; // 칼로리가 맥시멈보다 크면 종료
		if(calo <= l) answer = Math.max(answer, score); // 맥시멈보다 작거나 같으면 비교 후 업데이트
		if( idx == n) return; // 다 골랐으면 종료
		
		select(idx+1, score+hamb[idx].score, calo+hamb[idx].calo); // 다음 idx를 고른다.(idx증가, 점수와 칼로리도 증가)
		select(idx+1, score, calo); // 고르지 않고 넘어간다.(idx만 1 증가)
		
		
	}

}
