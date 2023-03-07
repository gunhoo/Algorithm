package SWTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @author gunhoo
 *
 */
public class SW_5658_보물상자비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc<= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String input = br.readLine();
			String t1 = input+input.substring(0, N/4-1);
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String hex = t1.substring(i, i+N/4);
				int num = Integer.parseInt(hex,16);
				if(!list.contains(num))list.add(num);
			}
			Collections.sort(list ,Collections.reverseOrder());
			System.out.println("#"+tc+" "+list.get(K-1));
		}
	}
}
