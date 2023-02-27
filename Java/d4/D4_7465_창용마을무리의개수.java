package d4;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수 {
	static int N;
	static int[] parents;
	static boolean[] visited;
	static int cnt;
	
	static void count() {
	    for (int i = 0; i < N; i++) {
	        if(!visited[findSet(i)]) { // 부모가 가리키는 곳을 방문하지 않았다면
	            cnt++; // 갯수 증가
	            visited[findSet(i)]=true; // 방문처리
	        }
	    }
	}
	
	// 최소 단위 집합 생성
	static void makeSet() {
	    for (int i = 0; i < N; i++) {
	        parents[i] = i;
	    }
	}
	//집합의 루트 번호 찾기
	static int findSet(int a) {
	    if (parents[a] == a)
	        return a;
	    return parents[a] = findSet(parents[a]);
	}
	
	// 두 집합 합치기
	static void union(int a, int b) {
	    int aRoot = findSet(a);
	    int bRoot = findSet(b);
	    parents[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	
	    // T 입력
	    int T = parseInt(br.readLine());
	    // 테케 반복
	    for (int tc = 1; tc <= T; tc++) {
	        sb.append("#"+tc+" ");
	        st = new StringTokenizer(br.readLine());
	        //사람 수 입력
	        N = parseInt(st.nextToken());
	        parents = new int[N];
	        visited = new boolean[N];
	        cnt = 0;
	        
	        // 집합 초기화
	        makeSet();
	
	        // 사람 관계
	        int m = parseInt(st.nextToken());
	
	        // 연산자 입력 받기
	        for (int cnn = 0; cnn < m; cnn++) {
	            st = new StringTokenizer(br.readLine());
	            int a = parseInt(st.nextToken()) - 1;
	            int b = parseInt(st.nextToken()) - 1;
	            union(a, b); // 합쳐
	        }
	        count(); // 갯수 세는 메서드
	        sb.append(cnt+"\n");
	    }
	    System.out.println(sb.toString());
	}
}