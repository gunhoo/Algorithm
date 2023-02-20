package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * daily실습에서 했던 내용과 동일
 * devide and concur
 * @author 박건후
 *
 */
public class BJ_2630_색종이만들기 {
	static int n;
	static int[][] map;
	static int blue, white;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map= new int[n][n];
		for(int i = 0 ; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,n); // 자르기(재귀, 분할정복)
		System.out.println(white);
		System.out.println(blue);
	}
	
	private static void cut(int r, int c, int size) {
		int sum = 0;
		for(int i = r, rEnd = r+size; i<rEnd; i++) { // size만큼
			for(int j = c, cEnd = c+size; j<cEnd; j++) { // size만큼
				sum += map[i][j]; // 그 부분 모두 더해
			}
		}
		if(sum == size*size) { // 모두 1이면 파란색종이 영역 추가 
			blue++;
		}else if(sum == 0) { // 모두 0이면 하얀 색종이 영역 추가
			white++;
		}else { //섞여있으면
			int half = size/2;
			cut(r, c, half); // 왼쪽위
			cut(r, c+half, half); // 오른쪽 위
			cut(r+half, c, half); // 왼쪽 아래
			cut(r+half, c+half, half); // 오른쪽 아래
		}
	}
}
