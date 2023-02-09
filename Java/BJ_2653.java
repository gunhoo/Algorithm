import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * <pre>
 * 1. 문제 풀이 방법
        - DFS?
        - BACKTRACKING?

 * 2. 문제 복기

 * 
 * </pre>
 * @author 박건후
 * 
 */
public class BJ_2653 {
    static int[][] map;
    static int n;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();
    static boolean isStable = true;
    static int ans = 0;
    static ArrayList<Integer> group = new ArrayList<>();
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시간 줄이기 위한 조건
        
        for(int i = 1; i<= n ; i++){
        	int tmp = 0;
            for(int j = 1; j<= n ; j++){
                tmp += map[i][j];
            }
            
            if(tmp <= 1) {
            	isStable = false;
            	break;
            }
        } 

        dfs();
        
        for( int i = 0 ; i< candidates.size(); i++){
            if(candidates.get(i).size() < 1){
                isStable = false;
                break;
            }
        }
        if(isStable){
            System.out.println(ans);
            for( int i = 0; i < group.size(); i++){
            	System.out.print(group.get(i) + " ");
            	for( int j : candidates.get(i)) {
            		System.out.print(j+" ");
            	}
            	System.out.println();
            }
        }else{
            System.out.println(0);
        }
    }

    private static void dfs(){
        for(int i = 1; i<= n; i++){
            if(visited[i]) continue;
            visited[i] = true; //일단 true로 바꾸고
            ans++;
            candidates.add(new ArrayList<>(i));
            for(int j = 1; j<=n; j++){
                if( map[i][j] != 0 || i == j) continue;
                candidates.get(ans-1).add(j);
            	if( !group.contains(ans)) 
            		group.add(ans);
                visited[j] = true;
            }
        }
    }
    
}
