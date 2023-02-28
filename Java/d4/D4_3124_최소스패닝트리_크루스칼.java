package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3124_최소스패닝트리_크루스칼 {
	static class Edge implements Comparable<Edge>{
		int from, to , weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) { // 오름차순 정렬
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E; // 정점수, edge수
	static Edge[] edgeList; // edgelist
	static int[] parents; // 대표자를 나타내는 배열
	
	static void makeSet() { // 1부터 V(정점)까지 각자 그룹으로 생성
		parents = new int[V+1];
		for(int i= 1; i <= V ; i++) {
			parents[i] = i;	
		}
	}
	
	static int findSet(int a) { // 부모를 찾아주는 메서드
		if(parents[a] == a) return a; 
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) { // b의 부모를 a의 브모로 설정하는 메서드
		int aRoot = findSet(a); // a의 부모
		int bRoot = findSet(b); // b의 부모
		
		if(aRoot == bRoot) return false; // 같으면 같은집단이니 false
		parents[bRoot] = aRoot; // 아니면 b의 부모를 a의부모로 덮어써
		return true; // return
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int test_case =1 ; test_case <= t ; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E]; // edgelist초기화
			for(int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(edgeList); // 정렬되어있어야 작동하므로 arrays.sort
			makeSet(); // 집단 만들어준다
			
			long result = 0, count =0 ; // 결과값 도출하기 위한 변수
			for (Edge edge : edgeList) { // 모든 edge에 대해 
				if(union(edge.from, edge.to)) { // a->b
					result += edge.weight; // 가중치 합
					if(++count == V-1) break; // 모두 탐색했으면 탈출
				}
			}
			System.out.println("#"+test_case+" "+result);
			
		}
	}

}
