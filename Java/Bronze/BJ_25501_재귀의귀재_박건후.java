package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_25501_재귀의귀재_박건후 {
	static int cnt = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case =0 ; test_case < t ; test_case++) {
			cnt = 1; // 1부터 시작
			String str = br.readLine();
			System.out.println(isPalindrome(str)+" "+cnt);
		}
	}
	private static int isPalindrome(String str) {
		return recursion(str, 0, str.length()-1);
	}
	private static int recursion(String str, int l , int r) {
		if(l >= r) return 1; // 종료 조건 왼쪽이 더 커버리면 1 
		else if(str.charAt(l) != str.charAt(r)) return 0; // 아니면 0 리턴
		else { // 그 외의 경우  
			cnt++; // 총 cnt 값 증가
			return recursion(str, l+1, r-1); // 재귀
		}
	}
}
