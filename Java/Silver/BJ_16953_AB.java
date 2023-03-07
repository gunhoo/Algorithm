package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16953_AB {
	static long a, b;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Long> q = new ArrayDeque<>();
		q.add(a);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i =0; i < size; i++) {
				long tmp = q.poll();
				if( tmp == b) return cnt+1;
				
				if( tmp *2 <= b) q.add(tmp*2);
				if(tmp*10+1<=b) q.add(tmp*10+1);
			}
			cnt++;
		}
		return -1;
	}

}
