package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_4999_아 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		if(a.charAt(0) == 'h' && b.length() != 1) {
			System.out.println("no");
		}else {
			if( a.length() >= b.length()) {
				System.out.println("go");
			}else {
				System.out.println("no");
			}
		}
	}

}
