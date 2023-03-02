package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656_벽돌깨기 {
	static int n, w, h, res;
	static int[] s;
	static int[][] map, tmp;
	static int[] dx ={1,-1,0,0};
	static int[] dy ={0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			tmp = new int[h][w];
			s = new int[n];
			res = Integer.MAX_VALUE;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permutation(0);
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.print(sb);
	}

	public static void permutation(int cnt) {
    // 순열로 공을 넣는 위치를 정함
		if (cnt == n) {
			breakWall();
			return;
		}
		for (int i = 0; i < w; i++) {
			s[cnt] = i;
			permutation(cnt + 1);
		}
	}

	public static void breakWall() {
		for (int i = 0; i < h; i++) {
			tmp[i] = Arrays.copyOf(map[i], map[i].length);
		}
		
		for (int i = 0; i < n; i++) {
			int x = -1; // 행
			int y = s[i]; // 열
			for (int j = 0; j < h; j++) {
				if (tmp[j][y] != 0) {
					x = j;
					break;
				}
			}
			if (x == -1) continue;

			breaking(x, y, tmp);
			adjWall(tmp);
		}
		
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (tmp[i][j] > 0) cnt++;
			}
		}
		res = Math.min(cnt, res);
	}
	
	public static void breaking(int x, int y, int[][] tmp) {
		int n = tmp[x][y];

		tmp[x][y] = 0;
		if (n == 1) return;

		for (int i = 0; i < 4; i++) {
			int nx = x, ny = y;
			for (int nn = 0; nn < n - 1; nn++) { // 벽돌에 써있는 수만큼 반복
				nx += dx[i];
				ny += dy[i];
				if (0 > nx || 0 > ny || h <= nx || w <= ny) break;
				if (tmp[nx][ny] == 0) continue;
				if (tmp[nx][ny] == 1) tmp[nx][ny] = 0;
				else  breaking(nx, ny, tmp);
			}
		}
	}

	public static void adjWall(int[][] tmp) {
		Queue<Integer> q;
		for (int i = 0; i < w; i++) {
			q = new LinkedList<>();
			for (int j = h - 1; j >= 0; j--) {
				if (tmp[j][i] != 0) {
					q.add(tmp[j][i]);
					tmp[j][i] = 0;
				}
			}
			int x = h - 1;
			while (!q.isEmpty()) {
				tmp[x--][i] = q.poll();
			}
		}
		
	}
}