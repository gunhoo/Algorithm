package Gold.Gold1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * MST
 * 간적크/간만프
 * 간선이 적으므로 크루스칼 
 * 섬을 입력받고 bfs를 돌면서 섬의 번호 갱신
 * 1번 섬부터 다른 섬까지 간선을 만들어: from 1 to 2,3,4... weight: 맨하탄거리/1이면 2로 넣어줘
 * 
 * @author gunhoo
 *
 */
public class BJ_17472_다리만들기2 {
	static int N, M, map[][], parents[];
	static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int V = makeIsland(); // 섬의 번호 분리하는 bfs
		edgeList = new Edge[V*(V-1)];
		parents = new int[V+1];
		for(int i = 1; i< V+1; i++) {
			parents[i] = i;
		}
		int eNum =0;
		for(int i = 1; i <= V; i++ ) { // i부터 j까지 모든 다리길이 구해
			for(int j = i+1; j <= V ; j++) {
				makeBridges(eNum, i, j);
				eNum+=2;
			}
		}
		Arrays.sort(edgeList);
		int answer = 0, cnt = 0;
		for(Edge e : edgeList) {
			System.out.println(e.from+"->"+e.to+" : "+e.weight);
			if(!union(e.from, e.to)) {
				answer += e.weight;
				if(++cnt == V-1) break;
			}
		}
		System.out.println(answer);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static int makeIsland() {
		boolean visited[][] = new boolean[N][M];
		int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
		Queue<Point> q = new ArrayDeque<>();
		int islandNum = 0;
		for(int i =0;i < N; i++) {
			for(int j =0; j < M ;j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;
				islandNum++;
				q.offer(new Point(i,j));
				while(!q.isEmpty()) {
					Point point = q.poll();
					for(int k = 0; k < 4; k++) {
						int nx = point.x + dx[k];
						int ny = point.y + dy[k];
						if(0>nx || nx>=N || 0>ny || ny>=M || visited[nx][ny] || map[nx][ny] == 0) continue;
						visited[nx][ny] = true;
						map[nx][ny] = islandNum;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
		return islandNum;
	}
	
	private static void makeBridges(int e, int from, int to) {
		for(int i =0 ; i < N ;i++) {
			for(int  j =0; j< M ; j++) {
				if(map[i][j] == from) {
					int dis = 0;
					for(int a = 0; a < N ; a++) 
						for(int b = 0; b < M ; b++) 
							if(map[a][b] == to) dis = (Math.abs(a-i)+Math.abs(b-j)) == 1? 2: Math.abs(a-i)+Math.abs(b-j);
					edgeList[e] = new Edge(from, to, dis);
					edgeList[e+1] = new Edge(to, from, dis);

				}
			}
		}
	}
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	private static void print() {
		for(int i = 0;i < N ;i++) {
			for(int j =0 ; j < M ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
