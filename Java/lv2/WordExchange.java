import java.util.*;

class Solution {
    private int answer = 0;
    public int solution(String begin, String target, String[] words) {
        bfs(begin, target, words);
        return answer;
    }
    private void bfs(String begin, String target, String[] words) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(begin, 0));
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(p.distance > words.length) return;
            for(int i=0; i<words.length; i++) {
                if(words[i].equals(p.name)) continue;
                else if(p.name.equals(target)) {
                    answer = p.distance;
                    return;
                }else {
                    if(check(p.name, words[i])){
                        q.add(new Point(words[i], p.distance+1));    
                    }
                }
            }
        }
    }
    
    private boolean check(String a, String b) {
        int sum = 0;
        for(int i=0; i<b.length(); i++){
            if(a.charAt(i) != b.charAt(i)) sum++;
        }
        if(sum == 1) return true;
        return false;
    }
    
    class Point {
        String name;
        int distance;
        
        public Point(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }
}