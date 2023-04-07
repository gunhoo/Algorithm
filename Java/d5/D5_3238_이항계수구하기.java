package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_3238_이항계수구하기 {    
	
	public static int iT=0;
	public static long n,r;
	public static int p;
	public static long[] nCr;
	//각 테스트 케이스마다 첫 번째 줄에 세 자연수 n, r, p (0 ≤ r ≤ n ≤ 10^18, 2 ≤ p ≤ 10^5, p는 소수)가 공백으로 구분되어 주어진다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		iT=Integer.parseInt(br.readLine().trim());
		nCr=new long[p+1];

		for (int T = 1; T <= iT; T++) {
			st=new StringTokenizer(br.readLine().trim());
			n=Long.parseLong(st.nextToken().trim());
			r=Long.parseLong(st.nextToken().trim());
			p=Integer.parseInt(st.nextToken().trim());
			System.out.printf("#%d %d\n",T,nCr(n,r,p));
		}
		
	}
	static long power(long x, long y, long p)  { 
		long res = 1L; 
        x = x % p; 
        //=> 3^7 > 7 3 1   3^7 --> 3^1*3^2*3^4             
        while (y > 0) {    
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        } 
        return res; 
    } 
    static long modInverse(long n, long p) { 
        return power(n, p-2, p); 
    } 

    static long nCr(long n, long r, int p) { 
        if (r == 0) 
            return 1L; 
        long[] fac=new long[p];
        fac[0]=1;
		for (int i = 1; i < fac.length; i++) {
			fac[i]=i*fac[i-1]%p;
		}
        if(n<p) {
        	return (fac[(int)n]* modInverse(fac[(int)r], p) 
                    % p * modInverse(fac[(int)(n-r)], p) 
                                        % p) % p; 
        }else {
        	long ret=1;
            while(n>0 || r>0){
                long a=n%p;
                long b=r%p;
                if(a<b) ret=0;
                if(ret==0) break;
                ret*=fac[(int)a];
                ret%=p;
                ret*=modInverse((fac[(int)b]*fac[(int)a-(int)b])%p, p);
                ret%=p;
                n/=p;
                r/=p;
            }
            return ret;
        }
        
    } 
}
