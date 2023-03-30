package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2239_스도쿠 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		int[][] nmap = new int[9][9];
		
		for(int i=0; i < 9 ; i++) {
			String string = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = string.charAt(j)-'0';
			}
		}
		
		
		
	}

}
