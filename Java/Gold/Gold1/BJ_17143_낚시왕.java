package Gold.Gold1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 낚시왕
 * - 구현, 시뮬레이션
 * - 상어 class만들어서 2차원 상어배열 만드는 방식으로 접근
 * 
 * @author 박건후
 *
 */
public class BJ_17143_낚시왕 {
	
	static int R, C, M;
	static Shark[][] map;
	static Shark[][] tmpMap;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R+1][C+1];
		tmpMap = new Shark[R+1][C+1];
		
		for(int i =0  ; i < M ; i++) {
			st= new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] 
					= new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		for(int i = 1 ; i <= C ; i++) {
			for(int j = 1; j <= R ; j++) {
				if(map[j][i] != null) { // 상어가 존재하면
					answer += map[j][i].z; // 상어 낚시 성공!
					map[j][i] = null; // 낚인 상어는 없어져
					break; // 해당 열에 대해서 낚시 끝
				}
			}
			moveShark(); // 상어 움직이는 메서드 호출
		}
		System.out.println(answer);
	}

	private static void moveShark() {
		int nx, ny;
		tmpMap = new Shark[R+1][C+1]; // 새로운 지도
		int d; // 거리
		int di = 1; // 방향가리키는 idx
		for(int i = 1; i <= R; i++) { // 모든 칸을 탐색하면서
			for(int j = 1; j<=C ; j++) { 
				if(map[i][j] != null) { // 상어가 있으면
					switch(map[i][j].direction) { // 방향에 따라 로직
					case 1: // 위로가는경우
						nx = i;
						ny = j;
						di = -1; // 위로가는 경우 행이 줄어들어야하니까 -1로 시작
						d = map[i][j].speed;
						while( d > 0) { // 다 움직일 때 까지
							nx += di; // 1칸 이동
							if( nx == 0 ) { // 맨 윗칸보다 더 가면
								nx = 2; // 잘못간것이므로 2칸으로 설정
								di *= -1; // 방향은 이제 아래로 틀어( -1 > 1)
							}else if( nx == R+1) { // 맨 밑칸보다 한칸 더 가면
								nx = R-1; // 잘못간것이므로 R-1로 설정
								di *= -1; // 방향은 이제 위로 틀어( 1 > -1)
							}
							d--; // 한칸 이동했으니 -1
						}
						if( di == 1) map[i][j].direction = 2; // 방향idx가 동일하지 않다면, direction 바꿔줘(위>아래)
						if(tmpMap[nx][ny] == null) { // 비어있다면
							tmpMap[nx][ny] = map[i][j]; // 넣어줘
						}else { // 이미 상어 존재하면
							if( tmpMap[nx][ny].z < map[i][j].z) { //기존상어가 새로들어온 상어보다 작으면
								tmpMap[nx][ny] = map[i][j]; // 넣어줘
							}
						}
						break;
					case 2: // 아래로 가는 경우
						nx = i;
						ny = j;
						di = 1; //아래로 가는 경우는 증가해야하므로 1로 시작
						d = map[i][j].speed;
						while( d > 0) { // 거리만큼
							nx += di; // nx값 1씩 옮겨
							if( nx == 0 ) { // 맨 위면
								nx = 2; // 아래로 2칸
								di *= -1; // 방향 틀어줘
							}else if( nx == R+1) { // 맨 밑이면
								nx = R-1; // 위로 2칸
								di *= -1; // 방향 틀어줘
							}
							d--; // 거리 1소모
						}
						if( di == -1) map[i][j].direction = 1; // 방향 바뀌었다면 direction바꿔줘(아래>위)
						if(tmpMap[nx][ny] == null) { // 비어있다면
							tmpMap[nx][ny] = map[i][j]; // 넣어줘
						}else { // 이미 상어 존재하면
							if( tmpMap[nx][ny].z < map[i][j].z) { //기존상어가 새로들어온 상어보다 작으면
								tmpMap[nx][ny] = map[i][j]; // 넣어줘
							}
						}
						break;
					case 3: // 오른쪽으로 가는 경으
						nx = i;
						ny = j;
						d = map[i][j].speed;
						di = 1;
						while(d > 0) { //거리만큼 이동
							ny += di; // 한칸씩 이동
							if( ny == 0) { // 맨 왼쪽보다 1칸 더 가면
								ny = 2; // 오른쪽으로 2칸
								di *= -1;//방향틀어줘
							}else if( ny == C+1) { // 맨 오른쪽보다 1칸 더가면
								ny = C-1; // 맨 오른쪽에서 -1칸
								di *= -1; // 방향 틀어줘
							}
							d--; // 거리 소모
						}
						if( di == -1) map[i][j].direction = 4; // 방향이 바뀌었다면(1>-1), direction 바꿔줘(3>4)
						if(tmpMap[nx][ny] == null) { // 비어있다면
							tmpMap[nx][ny] = map[i][j]; // 넣어줘
						}else { // 이미 상어 존재하면
							if( tmpMap[nx][ny].z < map[i][j].z) { //기존상어가 새로들어온 상어보다 작으면
								tmpMap[nx][ny] = map[i][j]; // 넣어줘
							}
						}
						break;
					case 4: // d왼쪽으로 가는 경우
						nx = i;
						ny = j;
						d = map[i][j].speed;
						di = -1; // 왼쪽으로가는 경우 열값 1씩 줄여야해
						while(d > 0) { // 거리만큼
							ny += di; // 한칸씩 이동
							if( ny == 0) { // 맨 왼쪽보다 1칸 더가면
								ny = 2; // 맨왼쪽에서 2번째로 설정
								di *= -1; // 방향 전환
							}else if( ny == C+1) { // 맨 오른쪽보다 1칸 더가면
								ny = C-1; // 맨 우측에서 -1칸으로 설정
								di *= -1; // 방향 전환
							}
							d--; // 거리 소모
						}
						if( di == 1) map[i][j].direction = 3; // 방향이 바뀌었다면(-1>1), direction바꿔줘 (우>좌, 4>3)
						if(tmpMap[nx][ny] == null) { // 비어있다면
							tmpMap[nx][ny] = map[i][j]; // 넣어줘
						}else { // 이미 상어 존재하면
							if( tmpMap[nx][ny].z < map[i][j].z) { //기존상어가 새로들어온 상어보다 작으면
								tmpMap[nx][ny] = map[i][j]; // 넣어줘
							}
						}
						break;
					}
				}
			}
		}

		map = tmpMap; // 갱신
	}
	
	static class Shark{
		int speed, direction, z;

		public Shark( int speed, int direction, int z) {
			super();
			this.speed = speed;
			this.direction = direction;
			this.z = z;
		}
		
	}

}
