package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16919_봄버맨2 {
	static int R,C,N;
	static int map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i =0 ;i < R; i++) {
			String input = br.readLine();
			for(int j =0 ; j < C; j++) {
				map[i][j] = input.charAt(j)=='.'?-1:0;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(N %2 == 0) {
			for(int i =0 ;i < R; i++) {
				for(int j =0 ; j <C;j ++) {
					sb.append("O");
				}
				sb.append("\n");
			}
		}else if(N == 1){
			for(int i =0 ;i < R; i++) {
				for(int j =0 ; j < C;j ++) {
					sb.append(map[i][j]==-1?'.':'O');
				}
				sb.append("\n");
			}
		}else {
			N = N%4 + 4;
			for(int i = 2; i <= N ; i++) {
				if( i % 2 == 0) change(true,i);
				else change(false, i);
			}
			for(int i=0 ; i <R; i++) {
				for(int j =0; j < C; j++) {
					sb.append(map[i][j]==-1?'.':'O');
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void change(boolean mode, int time) {
		if(mode) {
			for(int i = 0; i < R; i++) {
				for(int j =0 ; j < C; j++) {
					if(map[i][j] == -1) map[i][j] = time;
				}
			}
		}else {
			for(int i = 0; i < R; i++) {
				for(int j =0 ; j < C; j++) {
					if(map[i][j] == time-3) bomb(i, j, time-3);
				}
			}
		}
	}
	private static void bomb(int x, int y, int time) {
		map[x][y] = -1;
		if(y<C-1 && map[x][y+1]!=time) map[x][y+1] = -1;
		if(y>0 && map[x][y-1]!=time) map[x][y-1] = -1;
		if(x < R-1 && map[x+1][y]!=time) map[x+1][y] = -1;
		if(x>0 &&map[x-1][y]!=time) map[x-1][y] = -1;
	}
}
