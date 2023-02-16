package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박건후
 *
 */
public class D3_6808_규영이와인영이의카드게임 {
	static int[] kyu, in;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test_case =1 ; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			kyu = new int[9];
			in = new int[9];
			int win = 0;
			int lose = 0;
			for(int i = 0; i< 9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
			}
						
			dfs();
			System.out.println("#"+test_case + " " + win + " "+ lose);
 		}
	
	}
	private static void dfs() {
		
	}

}
