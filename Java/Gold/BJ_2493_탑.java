package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BJ 2483 탑 문제
 * 1.자신보다 왼쪽을 가면서 자신의 높이보다 큰게 나오면 그 값 저장
 * @author 박건후
 *
 */
public class BJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] buildings = new int[n+1];
		int[] answer = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i<=n ; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> ans = new Stack<>();		
        for(int i = n ; i>0 ;i--) {
        	if( buildings[i-1] < buildings[i]) ans.add(buildings[i]); // 뒤에서부터 보는데 그 앞이 자기보다 작으면 레이저 맞을 수 없으므로 stack에 넣어준다
        	else{ // 나보다 앞에 있는 송신탑이 더 크면 
        		int tmp = i; // 현재 위치를 담는 임시 tmp
        		answer[i] = i-1; // 자신의 정답은 앞의 위치
        		while(!ans.isEmpty() && ans.peek() <= buildings[i-1]) { // 스택에 쌓여있는 얘가 앞 송신탑보다 작으면
        			if(answer[++tmp] == 0) { // 이미 결정이 안났으면
        				ans.pop(); // 스택에서 제거
        				answer[tmp] = i-1; // 정답업데이트
        			}
        		}
        	}
        }
		for(int i = 1 ; i<=n ; i++)System.out.print(answer[i]+" ");
    }
}
