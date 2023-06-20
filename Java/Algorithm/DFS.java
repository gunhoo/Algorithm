package Algorithm;

class DFS {
    private static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int cnt, int sum){
        if(cnt == numbers.length){
            if(target == sum) answer++;
            return;
        }
        int plus = sum + numbers[cnt];
        dfs(numbers, target, cnt+1, plus);
        int minus = sum - numbers[cnt];
        dfs(numbers, target, cnt+1, minus);
    }
}