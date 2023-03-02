package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최단경로
 * Dijkstra사용해보자~
 * 2차원 배열을 사용할 경우 V 20000, E300000으로 메모리초과, 시간초과가 날 수 있다.
 * 따라서 PQ 사용해서 구현해야한다.
 * 
 * @author 박건후
 *
 */
public class BJ_1753_최단경로 {
	static class Edge implements Comparable<Edge>{
		int node, weight;

		public Edge(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) { // 가중치 우선 정렬
			return this.weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<Edge>[] edgeList = new ArrayList[V+1]; // 연결정보를 담는 list배열 생성
		for(int i = 0 ; i<= V ;i++) {
			edgeList[i] = new ArrayList<Edge>(); // 초기화
		}
		final int INF = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < E ; i++) {
			st =new StringTokenizer(br.readLine());
			// from / to / weight
			edgeList[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean visited[] = new boolean[V+1]; // 방문체크위한 변수
		Edge[] D = new Edge[V+1]; // 처음부터 각 노드까지 거리 저장위한 Edge 배열
		
		for(int i = 1; i <= V; i++) {
			if( i == K) {
				D[i] = new Edge(i, 0); // 시작점이면 0으로 초기화
			}else {
				D[i] = new Edge(i, INF); // 나머지는 max값으로 초기화
			}
			pq.add(D[i]); // pq에 넣어줘, 이때 pq는 comparator로 인해 weight 정렬
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(edge.weight == INF) break; // 무한대면 갈 수 없으니 탈출
			for(Edge next : edgeList[edge.node]) { // 모든 edge들에  대해
				if(visited[next.node]) continue; // 이미 방문한 노드면 최솟값을 구한 노드이므로 패스
				if(D[next.node].weight > D[edge.node].weight + next.weight) { //최솟값이 생기면
					D[next.node].weight = D[edge.node].weight + next.weight; // 업데이트
					pq.remove(D[next.node]); // pq에서 제거하고, 
					pq.add(D[next.node]); // 다시 갱신될 수 있으므로 맨뒤에 추가
				}
			}
			visited[edge.node] = true; // 해당 노드 방문처리
		
		}

		for(int i = 1; i <= V; i++) {
			if(D[i].weight == INF) System.out.println("INF");
			else System.out.println(D[i].weight);
		}
	}

}
