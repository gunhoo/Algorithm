import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2447_별찍기10_박건후 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		printStar(0,0, n); // 재귀함수 호출
		
		for(int i = 0; i< n; i++) {
			for(int j = 0 ; j<n ; j++) {
				if(map[i][j] != '\0') bw.write(map[i][j]); // 빈공간이 아니면 값 출력
				else bw.write(" "); // 빈공간이면 공백 출력
			}
			bw.write("\n");
		}
		bw.flush();
	}
	private static void printStar(int x, int y, int n){
		if( n == 1) { // 종료조건
			map[x][y] = '*';
			return;
		}
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0; j< 3 ; j++) {
				if(i != 1 || j != 1) { // 가운데 공간이 아니면
					printStar(x+i*(n/3), y+j*(n/3), n/3); // 재귀로 들어가서 * 찍기
				}
			}
		}
	}
}
