import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int edges = wires.length;
        int nodes = 0;
        for(int i=0; i<edges; i++){
            for(int j : wires[i]){
                nodes = Math.max(j, nodes);
            }
        }
        int[][] map = new int[nodes][nodes];
        for(int[] edge : wires){ // draw the map
            map[edge[0]-1][edge[1]-1] = 1;
            map[edge[1]-1][edge[0]-1] = 1;
        }
        // brute-force 
        for(int i=0; i<edges; i++){
            int[][] tmpMap = new int[nodes][nodes];
            for(int j=0; j<nodes; j++) tmpMap[j] = Arrays.copyOf(map[j], nodes);
            tmpMap[wires[i][0]-1][wires[i][1]-1] = 0;
            tmpMap[wires[i][1]-1][wires[i][0]-1] = 0;
            int linkedNodes = bfs(tmpMap);
            
            answer = Math.min(Math.abs(nodes-linkedNodes*2), answer);
        }
        
        return answer;
    }
    
    private int bfs(int[][] map) {
        int linkedNodes = 1;
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0,0));
        boolean[] visited = new boolean[map.length];
        visited[0] =true;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<map.length; i++) {
                if(map[p.x][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(new Point(i, p.x));
                    linkedNodes++;
                }
            }
        }
        return linkedNodes;
    }
    
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}