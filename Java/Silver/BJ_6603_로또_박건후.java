import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_6603_로또_박건후 {
	static BufferedWriter bw;
	static int[] s;
	static int k;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals("0")) break; 
			StringTokenizer st = new StringTokenizer(tmp);
			k = Integer.parseInt(st.nextToken());
			s = new int[k+1];
			visited = new boolean[k+1];
			
			for(int i = 0 ; i<k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			dfs("", 1,0);
			bw.write("\n");
			
		}
		bw.flush();
		
	}
	
	private static void dfs(String str, int idx, int depth) throws Exception{
		if(depth == 6) {
			bw.write(str+"\n");
			return;
		}
		for(int i = idx; i<= k; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(str+s[i-1]+" ", i+1, depth+1);
			visited[i] = false;
		}
	}

}
