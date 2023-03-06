package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_곱셈 {
	private static long fibo(long num) {
		if(num == 1) return a%c;
		long k = fibo(num/2)%c;
		if( num % 2 ==0 ) return k*k%c;
		return k*k%c * a%c;
	}
	static long a, b, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		a= Long.parseLong(st.nextToken());
		b= Long.parseLong(st.nextToken());
		c= Long.parseLong(st.nextToken());
		long sum = fibo(b);
		System.out.println(sum%c);
	}

}
