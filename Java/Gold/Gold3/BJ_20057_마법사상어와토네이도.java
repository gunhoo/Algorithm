package Gold.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어떻게 가운데 부터 회전?
 * - N은 홀수니까, 1부터 N-1까지2번씩하고, 마지막은 한번더
 * 격자 밖으로 나갈 수도 있다. => 격자 밖으로 나간 모래의 양을 구해라
 * => 격자밖으로 나가면 answer에 더해줘 
 *     or 처음 모래양 total 구하고 - 토네이도 끝나고 남은 total모래양
 * @author 건후
 *
 */
public class BJ_20057_마법사상어와토네이도 {
	static int N;
	static int[][] map;
	static int dir = 1; // 오->왼(1), 상->하(2), 좌->우(3), 하-상(4)
	static int[] dirX = {0,1,0,-1};
	static int[] dirY = {-1,0,1,0};
	
	// 오->왼 : 1, 1, 2, 2, 7, 7, 10, 10, 5, 나머지
	static int direction1[][]  = {{-1,1}, {1,1}, {-2,0}, {2,0}, {-1,0}, {1,0}, {-1,-1}, {1,-1}, {0,-2},{0,-1}};
	// 상->하 : 1 1 2 2 7 7 10 10 5 나머지
	static int direction2[][] = {{-1,-1}, {-1,1}, {0,-2}, {0,2}, {0,-1}, {0,1}, {1,-1}, {1,1}, {2,0}, {1,0}};
	// 좌->우 : 1 1 2 2 7  10 10 5 나머지
	static int direction3[][] = {{-1,-1}, {1,-1}, {-2,0}, {2,0}, {-1,0}, {1,0}, {-1,1}, {1, 1}, {0,2}, {0,1} };
	// 하->상 : 1 1 2 2 7  10 10 5 나머지
	static int direction4[][] = {{1,-1}, {1,1}, {0,-2}, {0,2}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {-2,0}, {-1,0}};
	static int ratio[] = {1,1,2,2,7,7,10,10,5};
	static int answer =0 ;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i =0 ;i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tornado();
		System.out.println(answer);
	}
	static int size =1;
	static int sizeCond = 0;
	static int turn = 0;
	
	private static void tornado() {
		int x = N/2;
		int y = N/2-1;
		int[][] direction;
		while(y!=-1) {
			direction = getDir();
			int dust = map[x][y]; // 이동한 곳의 먼지량
			if(dust != 0) { // 그곳에 먼지 있으면
				int movingDust[] = new int[10]; // 10군데로퍼져
				for(int i =0 ;i < 10; i++) {
					int nx = x+direction[i][0];
					int ny = y+direction[i][1];
					if (i < 9) movingDust[i] = dust * ratio[i] / 100;
					else {
						movingDust[9] = dust;
						for(int tmp = 0; tmp < 9 ; tmp++) {
							movingDust[9] -= movingDust[tmp];
						}
					}
					if(movingDust[i] == 0) continue;
					if( 0>nx || nx>=N || 0>ny || ny>=N) { // 범위 밖으로 나가면
						answer += movingDust[i];
					}else { // 범위안이면
						map[nx][ny] += movingDust[i];
					}
				}
				map[x][y] = 0; // 토네이도 끝났으면 그자리는 0
			}			
			// x좌표, y좌표 이동해야해
			// 이동하는거만들어야하고, 몇칸이동하는지도 만들어아해
			sizeCond++;
			if(sizeCond == size) { // 크기만큼 돌았으면
				sizeCond =0; // 컨디션 조건 초기화
				turn++; // 턴 조건추가
				dir = (dir+1)%4; // 방향전환
			}
			if(turn == 2) {
				turn =0;
				size++;
			}
			if(dir == 1) {
				y-=1;
			}else if(dir == 2) {
				x +=1;
			}else if(dir == 3) {
				y += 1;
			}else {
				x -=1;
			}
		}		
	}
	private static int[][] getDir(){
		switch(dir) {
		case 1:
			return direction1;
		case 2:
			return direction2;
		case 3:
			return direction3;
		}
		return direction4;
	}

}
