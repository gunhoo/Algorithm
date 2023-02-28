import java.util.Scanner;

public class Hello {

	
	public static void main2(String[] args) {
		Scanner sc =new Scanner(System.in);
		long n = sc.nextLong();
		long[] dp = {0,1};
		long sum = 1;
		if(n %2 == 0 ) {
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		long n = sc.nextLong();
		long[] dp = {0,1};
		long sum = 1;
		for(long i = 1; i < n ; i++) {
			long tmp = dp[0];
			dp[0] = dp[1];
			dp[1] = (tmp+dp[1]);
			sum = sum+(dp[1]*dp[1]);
			System.out.println(sum);
		}
		sum %= 1000000007;
		System.out.println(sum);
	}

}
