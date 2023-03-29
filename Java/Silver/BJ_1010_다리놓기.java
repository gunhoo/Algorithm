package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * mCn 구하는 문제
 * m! / n!(m-n)!
 * @author 박건후
 *
 */
public class BJ_1010_다리놓기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		for(int tc = 0; tc<t ; tc++) {
			st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			BigInteger[] dp = new BigInteger[M+1]; // 30!은 long범위를 넘어가므로 BigInteger로 설정
			dp[0] = BigInteger.ONE; // 초값은 1
			
			for(int i =1 ;i <= M ;i++) { // 길이가 M인 배열 생성후, 그 값은 전dp값 * 현재값
				dp[i] = dp[i-1].multiply(BigInteger.valueOf(i)); 
			}
			System.out.println(dp[M].divide((dp[M-N])).divide(dp[N]));
		}
	}
}
