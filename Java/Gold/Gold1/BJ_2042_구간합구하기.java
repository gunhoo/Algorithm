package Gold.Gold1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2042_구간합구하기 {
	static int N, M, K, a,b,c;
	static long arr[], tree[];
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new long[N+1];
		tree = new long[N*4];
		for(int i=1 ;i <= N ; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1,N,1);
		
		while(true) {
			st= new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if( a == 1) {
				arr[b] = c;
			}else {
				K--;
				long sum = 0;
				for(int i = b-1 ; i <= c-1; i++) {
					sum += arr[i];
				}
				System.out.println(sum);
				if(K == 0) break;
			}
		}
		
	}
	
	private static long init(int start, int end, int node) {
		if(start == end) return tree[node] = arr[start];
		int mid = (start+end)/2;
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	private static void update(int start, int end, int node, int idx, long dif) {
		if(idx < start || idx > end) return;
		tree[node] += dif;
		if(start == end) return;
		int mid = (start+end)/2;
		update(start, mid, node*2, idx, dif);
		update(mid+1, end, node*2+1, idx, dif);
	}

}
