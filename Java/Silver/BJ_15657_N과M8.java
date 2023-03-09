package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657_N과M8 {
	static int N, M;
	static int[] input, numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		numbers = new int[M];
		
		for(int i = 0; i<N ;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		permutation(0);
	}
	private static void permutation(int cnt) {
		if(cnt == M ){
			for(int i =0 ; i < M ;i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 0 ; i< N; i++) {
			if(cnt == 0)
				numbers[cnt] = input[i];
			else {
				if( numbers[cnt-1] <= input[i]) {
					numbers[cnt] = input[i];
				}else {
					continue;
				}
			}
			permutation(cnt+1);
		}
	}
}
