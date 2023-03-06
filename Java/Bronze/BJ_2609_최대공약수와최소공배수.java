package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		int gcb = 0;
		if( Math.min(a, b) == 1) {
			System.out.println(1);
			System.out.println(Math.max(a, b));
		}else {
			for(int i = 1; i <= Math.min(a, b); i++) {
				if( a % i == 0 && b % i == 0) {
					gcb = i;
				}
			}
			System.out.println(gcb);
			System.out.println((a*b)/gcb);
		}
		
	}

}
