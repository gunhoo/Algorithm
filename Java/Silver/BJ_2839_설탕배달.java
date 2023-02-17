package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans= 0;
		while(n>=0) {
			if( n%5 == 0) { // 5로 나누어떨어지면
				ans += n/5; // 5 봉지수만큼 더하고
				break; // 탈출
			}
			n -= 3; // 아니면 3만큼 빼고
			ans += 1; // 추가
		}
		if(n < 0) System.out.println(-1);
		else System.out.println(ans);
		
	}

}
