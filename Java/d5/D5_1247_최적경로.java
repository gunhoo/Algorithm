package d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 출발지점과 끝지점 주어지고,
 * 출발지에서 시작하여 map의 특정 지점들을 모두 탐색하고 도착지점까지 가는 최소 거리 
 * @author Gunhoo
 *
 */
public class D5_1247_최적경로 {
	static int n;
	static boolean[] isSelected;
	static int startX, startY, endX, endY;
	static int distance;
	static int[] input, numbers;
	static int[][] homes; 
			
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= t ; test_case++) {
			n = Integer.parseInt(br.readLine());
			isSelected = new boolean[n];
			homes = new int[n][2];
			input = new int[n];
			numbers = new int[n];
			for(int i =0  ; i < n ; i++) {
				input[i] = i;
			}
			distance = Integer.MAX_VALUE;
			st  = new StringTokenizer(br.readLine());
			startX =Integer.parseInt(st.nextToken()); 
			startY =Integer.parseInt(st.nextToken()); 
			endX =Integer.parseInt(st.nextToken()); 
			endY =Integer.parseInt(st.nextToken());
			for(int i = 0 ; i < n ; i++) {
				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());
				homes[i][0] = tmp1;
				homes[i][1] = tmp2;
			}
			permutation(0);
			System.out.println("#"+test_case+" "+distance);
		}
	}
	
	private static void permutation(int cnt) {
		if (cnt == n) {
			calculate(numbers);
			return;
		}
		for (int i = 0; i< n ; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static void calculate(int[] orders) {
		int sum = Math.abs(homes[orders[0]][0] - startX) + Math.abs(homes[orders[0]][1]-startY);
		for(int i = 1 ; i< orders.length; i++) {
			int tmp = Math.abs(homes[orders[i]][0] - homes[orders[i-1]][0]) 
					+ Math.abs(homes[orders[i]][1] - homes[orders[i-1]][1]);
			sum += tmp;
		}
		sum += Math.abs(homes[orders[n-1]][0] - endX) + Math.abs(homes[orders[n-1]][1]-endY);
		distance = Math.min(distance, sum);
	}
	
}
