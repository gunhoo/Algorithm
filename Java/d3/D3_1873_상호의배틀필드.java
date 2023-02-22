package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Integer;
public class D3_1873_상호의배틀필드 {
	static int H, W;
	static char[][] map;
	static int tankX, tankY;
	static int direction; // 0:상 1:우 2:하 3:좌
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int i = 0 ; i < H; i++) {
				String[] str = br.readLine().split("");
				for(int j =0; j < W; j++) {
					map[i][j] = str[j].charAt(0);
					if(map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
						tankX = i;
						tankY = j;
						switch(map[i][j]) { // 모양에 따라 바라보는 방향 다르게 해줘
						case '>': direction=1;
						break;
						case '^' : direction = 0;
						break;
						case 'v' : direction = 2;
						break;
						case '<' : direction = 3;
						break;
						}
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			for(int i =0 ; i< N; i++) {
				action(str[i].charAt(0));
			}
			System.out.print("#"+test_case+" ");
			print(); // 지도 출력 메서드
		}
	}
	private static void print() { // 자도 출력 메서드
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	private static void action(char command) {
		switch(command) {
		case 'U': // 위로 이동
			direction = 0;// 바라보는 방향 바꾸고
			if(map[tankX-1>=0?tankX-1:0][tankY] == '.') { // 평지면
				tankX -= 1; // 이동
				map[tankX+1][tankY] = '.';// 기존위치 평지로 바꿈
			}
			map[tankX][tankY] = '^';// 모양 변경
			break;
		case 'D':
			direction = 2;// 바라보는 방향 바꾸고
			if(map[tankX+1<H?tankX+1:tankX][tankY] == '.') { // 평지면
				tankX += 1; // 이동
				map[tankX-1][tankY] = '.';// 기존위치 평지로 바꿈
			}
			map[tankX][tankY] = 'v';// 모양 변경
			break;
		case 'L':
			direction = 3;// 바라보는 방향 바꾸고
			if(map[tankX][tankY-1>=0?tankY-1:0] == '.') { // 평지면
				tankY -= 1; // 이동
				map[tankX][tankY+1] = '.';// 기존위치 평지로 바꿈
			}
			map[tankX][tankY] = '<';// 모양 변경
			break;
		case 'R': // 오른쪽으로 이동
			direction = 1; // 바라보는 방향 바꾸고
			if(map[tankX][tankY+1<W?tankY+1:W-1] == '.') { //평지면 
				tankY += 1; // 한칸전진
				map[tankX][tankY-1] = '.'; // 기존위치 평지로 바꿈
			}
			map[tankX][tankY] = '>'; // 모양 변경
			break;
		case 'S': // shoot
			switch(direction) {
			case 0: // 위로 슛
				if(tankX != 0 ) { // 맨위가 아니면
					for(int i = tankX-1 ; i >= 0 ; i-- ) {
						if(map[i][tankY] == '-' || map[i][tankY] == '.') continue;
						else if(map[i][tankY] == '#') break; // 강철벽만나면 그냥 끝내
						else if(map[i][tankY] == '*') {
							map[i][tankY] = '.'; // 평지로만들고
							break; //탈출
						}
					}
				}
				break;
			case 1: // 오른쪽으로 슛
				if(tankY != W-1 ) { // 맨오른쪽이 아니면
					for(int i = tankY+1 ; i < W ; i++ ) {
						if(map[tankX][i] == '-' || map[tankX][i] == '.') continue;
						else if(map[tankX][i] == '#') break; // 강철벽만나면 그냥 끝내
						else if(map[tankX][i] == '*') {
							map[tankX][i] = '.'; // 평지로만들고
							break; //탈출
						}
					}
				}
				break;
			case 2: // 아래로 슛
				if(tankX != H-1 ) { // 맨아래가 아니면
					for(int i = tankX+1 ; i < H ; i++ ) {
						if(map[i][tankY] == '-' || map[i][tankY] == '.') continue;
						else if(map[i][tankY] == '#') break; // 강철벽만나면 그냥 끝내
						else if(map[i][tankY] == '*') {
							map[i][tankY] = '.'; // 평지로만들고
							break; //탈출
						}
					}
				}
				break;
			case 3: // 왼쪽으로 슛
				if(tankY != 0 ) { // 맨왼쪽이 아니면
					for(int i = tankY-1 ; i >= 0 ; i-- ) {
						if(map[tankX][i] == '-' || map[tankX][i] == '.') continue;
						else if(map[tankX][i] == '#') break; // 강철벽만나면 그냥 끝내
						else if(map[tankX][i] == '*') {
							map[tankX][i] = '.'; // 평지로만들고
							break; //탈출
						}
					}
				}
				break; 
			}
			break; // 명령 실행 후 탈출
		}
	}

}
