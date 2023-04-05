package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15961_회전초밥 {
	static int N, d, k , c, map[], visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[N];
		visited = new int[d+1];
		for(int i =0 ;i < N ;i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(slidingWindow());
	}
	private static int slidingWindow() {
		int slide = 0;
		int chance;
		for(int i = 0 ; i < k ; i++) {
			if(visited[map[i]]==0) slide++;
			visited[map[i]]++;
		}
		chance = slide;
		for (int i = 1; i < N; i++) {
            if (chance <= slide) {
                if (visited[c] == 0) chance = slide+1;
                else chance = slide;
            }
            visited[map[i-1]]--;
            if (visited[map[i-1]]==0) slide--;
            if (visited[map[(i+k-1)%N]]==0)slide++;
            visited[map[(i+k-1)%N]]++;
        }
		return chance;
	}

}
