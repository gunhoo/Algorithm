package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5607_조합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int tc= 1; tc<= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			System.out.println("#"+tc+" "+nCr(N,R));
		}
	}
	
	private static long nCr(long n, long r) {
		long result = 1L;
		result *= factorial(n);
		result %= 1234567891;
		result *= power(factorial(n-r), 1234567889); 
		result %= 1234567891;
		result *= power(factorial(r), 1234567889); 
		result %= 1234567891;
		return result;
	}
	
	
	private static long factorial(long n) { // for문으로 factorial구하는메서드
		long result = 1L;
		for(int i =1; i<=n ;i++) {
			result *= i;
			result %= 1234567891;
		}
		return result;
	}
	
	private static long power(long x, long y) { 
		long result = 1L;
		while(y>0) {
			if(y%2 == 1) { // 홀수일 경우에만
				result *= x; // 결과값 증가되고
				result %= 1234567891;
			}
			x *= x; // a값은 계속 커짐(페르마소정리 : a^p=a(mod p))
			x %= 1234567891;
			y /= 2; // 제곱했으니 나누기 2
		}
		return result%1234567891;
	}
}
