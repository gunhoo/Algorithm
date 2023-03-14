package Gold.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 브루트포스로 완탐
 * 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값
 * @author Gunhoo
 *
 */
public class BJ_17779_게리맨더링2 {
	static int N;
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i =0 ;i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}

}
