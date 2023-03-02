package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499_주사위굴리기 {
	static int N, M;
	static int x, y;
	static int[][] map;
	static int[] dice = new int[6];
	static int[] diceIdx = {0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i =0  ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < K ; i++) {
			execute(Integer.parseInt(st.nextToken()));
		}
	}
	private static void execute(int command) {
		switch(command) {
		case 1:
			if( y != M) {
				y += 1;
				roll(1);
				if(map[x][y] == 0) {
					map[x][y] = dice[diceIdx[1]];
				}
			}
			
		case 2:
		case 3:
		case 4:
		}
	}
	private static void roll(int num) {
		switch(num) {
		case 1: // 오른쪽으로 회전
			switch(diceIdx[0]){
			case 0: // 맨밑이 0일때
				if(diceIdx[1] == 1 ) { // 오른쪽이 1이면
					diceIdx[0] = 1;
					diceIdx[1] = 5;
				}else if( diceIdx[1] == 4) { // 오른쪽이 4면
					diceIdx[0] = 4;
					diceIdx[1] = 5;
				}else if( diceIdx[1] == 2) {
					diceIdx[0] = 2;
					diceIdx[1] = 5;
				}else if(diceIdx[1] == 3) {
					diceIdx[0] = 3;
					diceIdx[1] = 5;
				}
			case 2:
			case 5:
			case 4:
				diceIdx = 1;
				break;
			case 1:
				diceIdx = 6;
				break;
			case 3:
				
			}
			break;
		case 2:
		case 3:
		case 4:
		}
	}
}
