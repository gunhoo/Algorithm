package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4_박건후 {
	static class Info {
		int r, c, s;
		int startY, startX, endY, endX;
		public Info(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.startY = r - s;
			this.startX = c - s;
			this.endY = r + s;
			this.endX = c + s;
		}
	}
	public static Info[] infoArr;
	public static int n, m, k, r, c, s, answer;
	public static boolean[] isSelected;
	public static int[] sequence;
	public static int[][] map, tmpMap;
	public static int[] dy = {1, 0, -1, 0};
	public static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		sequence = new int[k];
		isSelected = new boolean[k];
		map = new int[n][m];
		infoArr = new Info[k];
		answer = 5000; // M max : 50 * val max : 100
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			infoArr[i] = new Info(Integer.parseInt(st.nextToken()) - 1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
		}
		
		permutation(0); // 순열
		System.out.println(answer);
	}
	
	private static void permutation(int cnt) {
		if (cnt == k) {
			// 회전 순서에 따른 최소값을 구해야하므로 원본 배열은 유지가 되야한다.
			tmpMap = new int[n][m];
			for(int i = 0 ; i< map.length ; i++) { // 현재 map을 복사한다 
	            tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
	        }
			
			for (int i = 0; i < k; ++i) {
				int startY = infoArr[sequence[i]].startY;
				int startX = infoArr[sequence[i]].startX;
				int endY = infoArr[sequence[i]].endY;
				int endX = infoArr[sequence[i]].endX;
				
				while (startY < endY && startX < endX) { // 시작지점과 다를 때까지 반복
					rotation(startY++, startX++, endY--, endX--); // 회전
				}
			}
			updateMin(); // min 값 계싼
			return; // 종료
		}
		
		for (int i = 0; i < k; ++i) {
			if (isSelected[i]) continue;
			isSelected[i] = true; // 방문했다고 하고
			sequence[cnt] = i; // 선택해주고
			permutation(cnt + 1); // 재귀
			isSelected[i] = false; //  방문해제
		}
	}
	
	
	private static void rotation(int startY, int startX, int endY, int endX) {
		int y = startY;
		int x = startX;
		int direction = 0;
		int temp = tmpMap[y][x];
		
		while (direction < 4) { // 하좌상우
			int ny = y + dy[direction]; 
			int nx = x + dx[direction];
			if (ny == startY && nx == startX) { // 시작점이면
				tmpMap[y][x] = temp; // 교체하고 
				return; // 종료
			}

			if (ny < startY || nx < startX || ny > endY || nx > endX) {// 만약 갈 수 없으면
				direction++; // 방향전환
				continue; // 다시시작
			}
			tmpMap[y][x] = tmpMap[ny][nx]; // 갱신
			x = nx;
			y = ny;
		}
	}
		
	private static void updateMin() {
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum = 0;
			for(int j = 0; j < m ; j++) {
				sum += tmpMap[i][j];
			}
			answer = Math.min(answer, sum);
		}
	}
}