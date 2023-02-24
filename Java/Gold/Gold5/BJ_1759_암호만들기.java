package Gold.Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	static char[] input;
	static char[] password;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		password = new char[L];
		input = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < C ; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		dfs(0, 0);
		System.out.print(sb);
	}
	
	
	private static void dfs(int num, int depth) {
		if(depth == L) {
			if( check() ) // 주어진 조건 만족하면 
				sb.append(password).append("\n"); // 후보에 추가
			return;
		}
		
		for(int i = num ; i< C; i++) {
			password[depth] = input[i]; 
			dfs(i+1, depth+1); // 하나 선택하고 깊이 추가
		}
		
	}
	private static boolean check() {
		int vowel = 0;
		int consonant = 0;
		for( char c : password) {
			if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c=='u') {
				vowel++; // 모음 갯수 
			}else consonant++; // 자음갯수
		}
		if( vowel >= 1 && consonant >=2 ) return true; // 주어진 조건 만족하면 true
		return false; // 만족 못하면 false
	}
}
