package Gold.Gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cheeseCnt;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];

		int ans;
		for (ans = 0; isCheese(); ans++) {
			// 초기 세팅
			for (boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}
			visited[0][0] = true;
			cheeseCnt = 0;
			DFS(0, 0);
		}

		System.out.println(ans + "\n" + cheeseCnt + "\n");

	}

	public static boolean isCheese() {
		// map[i][j] = 2로 표시된 부분은 공기와 맞닿은 치즈이므로
		// 먼저 공기로 바꿔줘야 함.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}

		// 판 위에 치즈가 존재하는지 체크.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	// (0, 0)부터 시작해서 공기와 맞닿은 치즈를 찾음.
	public static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위를 벗어나는 경우
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				if (map[nx][ny] == 1) {
					map[nx][ny] = 2;
					cheeseCnt++; // 다음에 지워질 치즈의 개수
				} else {
					DFS(nx, ny);
				}
			}
		}
	}

}