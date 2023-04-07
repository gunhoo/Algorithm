package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점화식으로 풀어보고 점화식을 사용하지 않는 방법과 비교
 * 점화식으로 풀지 않고 재귀를 할 경우 숫자가 매우 클 경우 stack memory overflow가 발생한다.
 * @author 박건후
 *
 */
public class D4_5604_구간합 {
	static long A, B, ans[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= t; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			if( A == 0) A =1L;
			B = Long.parseLong(st.nextToken());
			ans = new long[10];
//			recurrence(A, B, 1L);
//			long answer =0;
//			for(int i=1; i < 10; i++) {
//				answer += ans[i]*i;
//			}
//			System.out.println("#"+tc+" "+answer);
			System.out.println("#"+tc+" "+notRecurrence());
		}
		
	}
	
	private static void recurrence(long start, long end, long ten) { // 재귀 호출방법
		while (A % 10 != 0 && A <= B) {
	        calc(A,ten);
	        A += 1;
	    }
	    if (A > B) return;
	    while (B % 10 != 9 && A <= B) {
	        calc(B,ten);
	        B -= 1;
	    }
	    long cnt = (B/10 - A/10 + 1);
	    for (int i=0; i<=9; i++) {
	        ans[i] += cnt*ten;
	    }
	    recurrence(A/10, B/10, ten*10L);
	}
	
	private static long notRecurrence() {
		long sum =0;
		long ten = 1L;
		while(A <= B) {
			while (A % 10 != 0 && A <= B) {
	            calc(A, ten);
	            A += 1;
	        }
	        if (A > B) break;
	        while (B % 10 != 9 && A <= B) {
	            calc(B, ten);
	            B -= 1;
	        }
	        long cnt = (B/10 - A/10 + 1);
	        for (int i=0; i<=9; i++) {
	            ans[i] += cnt*ten;
	        }
	        A = A / 10;
	        B = B / 10;
	        ten = ten*10L;
		}
		for(int i = 1; i < 10; i++) {
			sum += ans[i]*i;
		}
		return sum;
	}
	
	private static void calc(long n, long ten) {
		while(n>0) {
			ans[(int) (n%10)]+=ten;
			n = n/10;
		}
	}

}
