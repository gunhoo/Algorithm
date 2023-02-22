package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BJ 15685 드래곤 커브
 * 100x100 배열 만들고, 드래곤 커브 정보 받아서 입력
 * - 드래곤 커브는 어케 입력? 
 * 		- 재귀로 불러서 이어 붙이기?
 * 정답 - 0,0부터 99,99까지 보면서 [i][j],[i][j+1],[i+1][j],[i+1][j+1] 모두 1이면 정답++
 *  0세대 : 0
 *  1세대 : 01
 *  2세대 : 0121
 *  3세대 : 01212321
 *  
 * @author Gunhoo
 *
 */
public class BJ_15685_드래곤커브 {
	static int[][] map = new int[101][101]; // map정보
	// 주의 !!! : x는 오른쪽으로 증가, y 는 아래쪽으로 증가
	static int[][] direction = {{0, 1}, {-1,0}, {0,-1}, {1,0}};
	
	static int[] dx = {1,0,-1,0}; // 우상좌하(0123)
	static int[] dy = {0,-1,0,1};
	static ArrayList<Curv> curvs= new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] dragonCurvs = new int[n][4];
		for(int i = 0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			dragonCurvs[i][0]= Integer.parseInt(st.nextToken());
			dragonCurvs[i][1]= Integer.parseInt(st.nextToken());
			dragonCurvs[i][2]= Integer.parseInt(st.nextToken());
			dragonCurvs[i][3]= Integer.parseInt(st.nextToken());
			makeCurv(dragonCurvs[i]);
		}
		
		 // curv 그려주는 함수
//		System.out.println(count()); // 정답 출력
	}
	
	private static void makeCurv(int[] dragonCurvs) { // 입력에 대해
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.add(dragonCurvs[2]); // 방향을 넣어줘
		/**
		 * 스택에 있는거를 뒤에서부터 꺼내서 (+1)%4 해주고 기존스택 뒤에 더해줘
		 */
		for(int i = 0; i<= dragonCurvs[3]; i++) { // 세대수까지 반복
			ArrayDeque<Integer> newStack = new ArrayDeque<>();
			while(!stack.isEmpty()) {
				int tmp = stack.removeLast();
				newStack.offerLast((tmp+1)%4);
				newStack.offerFirst(tmp);
			}
			stack = newStack;
		}
		for(int i = 0 ; i< stack.size(); i++) {
			System.out.println("stack: " +stack.removeFirst());
		}
	}
	
	private static void drawCurv() {// 1번그리고 2번 넘겨주고, 2번그리고 3번 넘겨주고, 번호 같으면 종료
		
	}
	
	private static int count() { // dragon curv 세주는 함수
		int sum = 0;
		for(int i = 0; i< 99; i++) { // 모든 곳 탐색하면서
			for(int j = 0; j< 00 ; j++) { // 크기가 1인 정사각형에 모든 값이 1이면 정답 증가
				if(map[i][j] == 1&& map[i][j+1] == 1&& map[i+1][j] == 1 && map[i+1][j+1] == 1) {
					sum++;
				}
			}
		}
		return sum;
	}
	static class Curv{
		int x, y, dir, gen;
		public Curv(int x, int y, int dir, int gen) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.gen = gen;
		}
	}
}
