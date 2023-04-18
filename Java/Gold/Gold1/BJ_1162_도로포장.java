package Gold.Gold1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * K개의 weight를 0으로 만들 수 있다
 * 그때 1에서 N까지 가는 dist[N]의 최솟값 구해야해
 * 
 * @author Gunhoo
 *
 */
public class BJ_1162_도로포장 {
	private static int N, M, K, distance[];
	private static final int INF=Integer.MAX_VALUE;
	private static ArrayList<Node> graph[];
	
	static class Node implements Comparable<Node>{
		int node, weight;
		public Node(int n, int w) {
			this.node = n;
			this.weight = w;
			
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		init();
		dijkstra(0);
	}
	
	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[1] = 0;
		
		for(int i =0 ; i < N+1; i++) graph[i] = new ArrayList<>();
		
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i =0 ;i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
	}
	
	private static boolean[] visited; 
	private static void dijkstra(int cnt ) {
		if(cnt == K) {
			
			return;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(1, 0));
		while(!pq.isEmpty()) {
			int curNode = pq.poll().node;
			
			for(Node next : graph[curNode]) {
				if(distance[next.node] > distance[curNode] + next.weight) {
					distance[next.node] = distance[curNode] + next.weight;
					pq.offer(new Node(next.node, distance[next.node]));
				}
			}
			
		}
	}

}
