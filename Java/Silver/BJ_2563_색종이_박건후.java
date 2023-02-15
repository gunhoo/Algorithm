package Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author Gunhoo Park
 */
public class BJ_2563_색종이_박건후 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_papers = Integer.parseInt(st.nextToken());
		int results = 0;
		int map[][] = new int[100][100];
				
		// input
		for (int idx=0; idx<no_papers; idx++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for(int i = x; i<x+10;i++) {
				for(int j=y; j<y+10; j++) {
					map[i][j] = 1; // 1로 만들어줌
				}
			}
		}
		for(int i = 0; i<100;i++) { // 전부 돌면서
			for(int j=0; j<100; j++) {
				results += map[i][j]; // 그 값을 더해준다
			}
		}
		
		System.out.println(results);
	}
}
