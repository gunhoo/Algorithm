package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ_15663_N과M9 {
	static int N, M;
	static boolean[] visited;
	static int[] input, numbers;
	static LinkedHashSet<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());

		input = new int[N];
		numbers = new int[M];
		visited = new boolean[N];
		list = new LinkedHashSet<String>();
		
		for(int i = 0 ;i < N ;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		permutation(0);
		list.forEach(System.out::println);
	}
	
	private static void permutation(int cnt) {
		if(cnt == M ){
			String tmp1 = "";
			for(int i =0 ; i < M ;i++) {
				tmp1 += numbers[i]+" ";
			}
			list.add(tmp1);
			return;
		}
		for(int i = 0 ; i< N; i++) {
			if(visited[i]) continue;
			numbers[cnt] = input[i];
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;
		}
	}

}
