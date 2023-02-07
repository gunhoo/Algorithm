package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10974_모든순열 {
	static int n;
	static boolean[] visited;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		permutation("", 0);
		bw.flush();
	}
	private static void permutation(String str, int cnt) throws IOException {
		if (cnt == n) {
			bw.write(str+ "\n");
			return;
		}
		for(int i = 1; i<=n ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			permutation(str + i + " ", cnt+1);
			visited[i] = false;
		}
	}

}
