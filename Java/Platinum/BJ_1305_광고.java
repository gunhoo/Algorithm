package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1305_광고 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		char[] text = br.readLine().toCharArray();
		char[] pattern = Arrays.copyOf(text, i);
		int[] pi = new int[i];
		
		for(int j = 1, k = 0; j < i ; j++) {
			while(k > 0 && pattern[j] != pattern[k]) k = pi[k-1];
			if(pattern[j] == pattern[k]) pi[j] = ++k;
			else pi[j] = 0;
		}
		System.out.println(i-pi[i-1]);
	}

}
