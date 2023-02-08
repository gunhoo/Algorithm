package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SW_1954_달팽이숫자_박건후 {
	static int[][] map;
	static int n;
	// 상 우 하 좌
	static int[] dx = {0, 1, 0,-1};
	static int[] dy = {1, 0, -1,0};
	static int start = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int test_case =1 ; test_case <= t; test_case++) {
			start =0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			map[0][0] = 1;
			bfs(0,0, 0);
			
			bw.write("#"+test_case+"\n");
			for(int i = 0; i< n ; i++) {
				for(int j = 0 ; j< n ; j++) {
					bw.write(map[i][j]+" ");
				}
				bw.newLine();
			}
		}
		bw.flush();
	}
	
	private static void bfs(int a, int b, int direction) {
		for(int i = 1; i< n*n+1; i++) {
			map[a][b] = i;
			a += dx[direction];
			b += dy[direction];
				
			if(0>a || a>=n || 0>b || b>=n || map[a][b] != 0) {
				a -= dx[direction];
				b -= dy[direction];
				direction = (direction+1)%4;
				a += dx[direction];
				b += dy[direction];
			}
		}
	}

}
