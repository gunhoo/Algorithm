package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;

/**
 * 1. 모든 온풍기에서 바람이 나옴(0빈 1좌 2우 3상 4하 5조사해야하는칸)
 * 2. 온도 조절(4방향으로 퍼짐)
 * 3. 가장 바깥족 4면 온도 감소
 * 4. answer += 1;
 * 5. 조사해야하는 칸이 K이상인지 검사 > K이상이거나 answer가 100이면 종료
 * 6. answer 출력 
 * @author 박건후
 *
 */
public class BJ_23289_온풍기안녕 {
	static int R, C, K, W, map[][];
	
	public static void main(String[] args) throws Exception{
		init();
	}
	
	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i =0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		W = Integer.parseInt(br.readLine());
		for(int i =0 ;i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
		}
	}

}
