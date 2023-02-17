package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 가다가 마이너스 만나면 뒤에 다 묶어 다음 마이너스 나올때까지 묶어
 * @author 박건후
 *
 */
public class BJ_1541_잃어버린괄호 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int answer = 0;
		boolean tf = false;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< input.length(); i++) {
			if( input.charAt(i) == '-') {
				if(tf == false) // 앞에가 +만 있었다면
					answer += Integer.parseInt(sb.toString());
				else  // 바로 앞 연산자가 -였다면
					answer -= Integer.parseInt(sb.toString());
				tf = true;
				sb = new StringBuilder();
			}else if (input.charAt(i) == '+') {
				if (tf == true) { // 앞에 연산자가 - 였다면
					answer -= Integer.parseInt(sb.toString());
					tf = true;
				}
				else { // 앞 연산자가 + 였다면{
					answer += Integer.parseInt(sb.toString());
					tf = false;
				}
				sb = new StringBuilder();
			}else {
				sb.append(input.charAt(i));
			}
		}
		if(tf) answer -= Integer.parseInt(sb.toString());
		else answer += Integer.parseInt(sb.toString());
		System.out.println(answer);
	}

}
