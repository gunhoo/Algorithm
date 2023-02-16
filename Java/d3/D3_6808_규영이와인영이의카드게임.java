package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박건후
 *
 */
public class D3_6808_규영이와인영이의카드게임 {
	static int[] kyu, in;
	static int score;
	static int[] restCard;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test_case =1 ; test_case <= t; test_case++) {
			score = 0;
			kyu = new int[9];
			in = new int[9];
			restCard = new int[9];
			isSelected = new boolean[9];
			boolean[] count = new boolean[18];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< 9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				count[kyu[i]-1] = true; // 선택한건 제외
			}
			
			int index = 0;
			for(int i =0 ; i< 18 ; i++) {
				if(count[i]) continue; // 선택된거면 패스
				else restCard[index++] = i+1; // 나머지 카드에 저장
			}
						
			dfs(0);
			System.out.println("#"+test_case + " " + score + " "+ (362880-score));
 		}
	
	}
	private static void dfs(int depth) {
		if(depth == 9) { // 9개 다 골랐다면 비교(게임)
			int kyuScore = 0; // 이 게임에서 규 임시 합산점수
			int inScore = 0; 
			for(int i = 0 ; i<9 ; i++) { // 순서대로 돌아서
				if(kyu[i] > in[i]) kyuScore += kyu[i]+in[i]; // 크다면 점수합산
				else inScore += kyu[i]+in[i]; // 크다면 점수합산
			}
			if (kyuScore > inScore) score++; // 규 합선 점수가 더 크면 이겼음, 비기면 점수 안올라감
			return; // 종료
		}
		
		for(int i = 0; i< 9 ; i++) {
			if(isSelected[i]) continue; // 방문했으면 패스
			in[depth] = restCard[i]; // 나머지 카드 선택
			isSelected[i] = true;  // 선택해주고
			dfs(depth+1); // 깊이 탐색
			isSelected[i] = false; // 해제
		}
	}

}
