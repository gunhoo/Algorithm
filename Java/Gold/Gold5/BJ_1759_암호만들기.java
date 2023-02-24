package Gold.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 두개이상의 자음과 한개이상의 모음(aeiou)
 * L 암호에 사용된 서로 다른 알파벳 개수
 * C 사용했을 법한 문자의 종류 
 * @author 박건후
 *
 */
public class BJ_1759_암호만들기 {
	static int L, C;
	static ArrayList<Character> consonant, vowel;
	static boolean[] visited = new boolean[26];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		vowel = new ArrayList<Character>();
		consonant = new ArrayList<Character>();
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < C ; i++) {
			char c = st.nextToken().charAt(0);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { // vowel이면
				vowel.add(c);
			}else {
				consonant.add(c);
			}
		}
		Collections.sort(consonant);
		Collections.sort(vowel);
		dfs(c, 0);
		System.out.print(sb);
	}
	
	
	private static void dfs(String password, int depth) {
		if(depth == L) {
			sb.append(password).append("\n");
			return;
		}
		
		visited[password.charAt(password.length()-1)-'a'] = true; // 방문처리
		for(int i = 0 ; i < C; i++) {
			if(!visited[candidates[i].charAt(0)-'a']) {
				visited[candidates[i].charAt(0)-'a'] = true;
				dfs( password + candidates[i], depth+1);
				visited[candidates[i].charAt(0)-'a'] = false;
			}
		}
		
	}
	
}
