package daily;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 유형 : BFS/DFS
 * 2. 그냥 반복문으로도 풀릴 것 같다.
 * 
 * @author 박건후
 *
 */
public class D3_9229_한빈이와SpotMart_박건후 {
	static int n, m;
	static int[] snacks;
	static int answer ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= t ; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			snacks = new int[n];
			answer = 0; // 초기화
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< n ; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0 ; i< n; i++) { // 처음부터 끝까지
				for(int j = i+1; j<n;j++) { // 처음 고른얘 다음부터 끝까지
					if(snacks[i]+snacks[j] >= answer && snacks[i]+snacks[j] <= m) { // 만약 기존값보다 크고, 맥시멈값(m)보다 작으면
						answer = snacks[i]+snacks[j]; // 업데이트
						if(answer == m) break; // 만약 찾았으면 break;
					}
				}
				if(answer == m) break;
			}
			answer = answer!=0?answer:-1; // -1을 출력하기 위한 
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
