package d4;
/*
1
3 3
1 2 1
2 3 2
1 3 3
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3124_최소스패닝트리_프림 {
	
	static int V, E; // 정점수, edge수
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine().trim());
		for(int test_case =1 ; test_case <= t ; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int[][] input = new int[V][V];
	        // 신장트리에 선택된 여부 체킹 배열
	        boolean[] visited = new boolean[V];
	        // 타 정점에서 자신으로의 간선비용 중 최소비용 저장 배열
	        int[] minEdge = new int[V];
	        
	        for (int i = 0; i < E; i++) {
	        	// 라인단위 인접행렬 정보 가져오기
	            st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken())-1;
            	int b= Integer.parseInt(st.nextToken())-1;
            	int c= Integer.parseInt(st.nextToken());
                input[a][b] = input[b][a] = c;
	            // 충분히 큰값으로 최솟값을 초기화
	        } // i노드에서 j노드까지의 비용을 모두 배열에 저장 완료
	        for(int i =0 ; i < V ; i++)
	            minEdge[i] = Integer.MAX_VALUE;
	        // ---- input debug point
	        long result = 0; // MST(최소신장트리) 비용
	        minEdge[0] = 0; // 임의시작점 0번 
	        // N개의 정점을 반복함ㄴ서 모두 연결
			for(int c = 0 ; c < V; c++){ 
				int min = Integer.MAX_VALUE; // 최솟값을 찾아야하니 충분히 큰 값으로 최솟값 초기화
	            int minVertex = 0; // 최솟값을 찾는 정점
	            
	            // 신장트리에서 아직 연결되지 않은 정점중에서 가장 유리한 간선비용의 정점을 선택
	            for(int i=0; i<V; ++i) { 
	            	// 아직 신장트리에 포함되지 않은 정점이면서 && 자신으로 다른 정점에서 오는 최소 간선비용(minEgde[i]) min 보다 작다면(최소)
	            	if(!visited[i] &&  
	            			min > minEdge[i] ) {
	            		min = minEdge[i]; // 최소비용 갱신
	            		minVertex = i; 	  // 선택된 가장 유리한 최소정점 설정 
	            	}
	            }	
	            // 선택된 정점을 신장트리에 포함시킴
	            visited[minVertex] = true;
	            // 신장트리에 포함되었으니 최소비용에 누적
	            result += min; 
	            
	            for (int i = 0; i < V; i++) { 
	                if (!visited[i] && // 아직 방문하지 않았고(신장트리에 포함되지 않았고)
	                		input[minVertex][i] != 0 &&   // 인접해있고 
	                		minEdge[i] > input[minVertex][i]  ) { // 비용이 minEdge 보다 작으면
	                	minEdge[i] = input[minVertex][i]; // minEdge 갱신
	                	// -- debug
//	                	System.out.printf("i=%d, minVertex=%d, minEdge[]=%d, input[][] = %d\n", i, minVertex, minEdge[i], input[minVertex][i]);
	                }
	            }
			}
			System.out.println("#"+test_case + " "+result);
		}
	}

}
