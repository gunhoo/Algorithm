import java.util.*;

class Solution {
    private static boolean visited[];
    private static int answer = 0;
    
    public int solution(int n, int[][] computers) {    
        visited = new boolean[n];
        bfs(computers, n);
        return answer;
    }
    
    private static void bfs(int[][] computers, int n){
        for(int i =0 ;i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            answer++;
            while(!q.isEmpty()){
                int k = q.poll();
                for(int j = 0; j < n; j++){
                    if(k == j || computers[k][j] == 0 || visited[j]) continue;
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
        
    }
}