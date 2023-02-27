package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {
	// 최소단위 집합 생성
	static void makeSet(int N) {
		//  자신의 부모노드를 자신의 값으로 셋팅
		for(int i =1  ; i <= N ; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		// 자신의 부모와 자신이 같으면 자신이 대표자(짱)
		if( parents[a] == a) return a;
		//  pass compression : 내가 속한 root node(짱) 반환
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b){
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if( aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			sb.append("#").append(test_case).append(" ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			makeSet(n);
			for(int i = 0 ; i < m ; i++) {
				st =new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				if( c== 0) union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else {
					if (findSet(Integer.parseInt(st.nextToken())) == findSet(Integer.parseInt(st.nextToken()))) {
						sb.append(1);
					}else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
