package d2;
import java.util.Arrays;
import java.io.*;

public class d2_1204 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			int t_num = Integer.parseInt(br.readLine());
			int max_cnt = 0, answer = 0;
			String[] math_scores = br.readLine().split(" ");
			// 개수 확인을 위해 정렬하기
			Arrays.sort(math_scores);
			// math_scores 내 모든 index에 대해
			for(String i : math_scores) {
				// i값의 가장 뒤 index 값과 가장 처음 index값을 빼고 +1을 해주면 그 tuple값의 개수
				int new_max_cnt = Arrays.asList(math_scores).lastIndexOf(i) - Arrays.asList(math_scores).indexOf(i)+1;
				// 만약 그게 max값이면
				if (new_max_cnt >= max_cnt) {
					// max 값 초기화 해주고
					max_cnt = new_max_cnt;
					// 그 tuple이 정답이 된다
					answer = Integer.parseInt(i);
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
}
