package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 다익스트라인데...
 * 비용처리를 어케한담? 2차원 dp배열
 * 
 * @author SSAFY
 *
 */
public class BJ_10217_KCMTravel {
	private static int N, M, K;
	static class Node implements Comparator<Node>{
		int to, cost, distance;

		public Node(int to, int cost, int distance) {
			super();
			this.to = to;
			this.cost = cost;
			this.distance = distance;
		}

		@Override
		public int compare(Node o1, Node o2) {
			return o1.distance-o2.distance;
		}
		
	}
	private static ArrayList<Node> graph[];
	private static int[][] dp, cost;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc<=t ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			dp = new int[N+1][N+1];
			cost = new int[N+1][N+1];
			graph = new ArrayList[N+1];
			for(int i = 0; i < N+1; i++) {
				graph[i] = new ArrayList<>();
				for(int j =0 ; j < N+1; j++) {
					dp[i][j] = Integer.MAX_VALUE;
					cost[i][j] = 0;
				}
			}
			
			for(int i = 0; i < K ;i++) {
				st= new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph[u].add(new Node(v, c, d));
			}
			
			dijkstra();
			System.out.println(); // dp[?][N]==Integer.MAX_VALUE?"Poor KCM":dp[?][N]
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0, 0));
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			for(Node next : graph[curNode.to]) {
				
			}
		}
	}

}
