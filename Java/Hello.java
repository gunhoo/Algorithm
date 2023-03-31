import java.util.*;

public class Hello {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        int prevCheeseCnt = 0;

        while (true) {
            int cheeseCnt = countCheese();

            if (cheeseCnt == 0) {
                System.out.println(time);
                System.out.println(prevCheeseCnt);
                break;
            }

            prevCheeseCnt = cheeseCnt;

            bfs();

            time++;
        }

        sc.close();
    }

    static int countCheese() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            // 가장 자리에 위치한 치즈인 경우, 치즈가 녹는 상태로 변경
            if (board[x][y] == 1 && isEdge(x, y)) {
                board[x][y] = 2;
            }

            // 주변 칸을 검사하며 치즈가 녹는 상태로 변경
            if (board[x][y] == 2) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isValid(nx, ny) && !visited[nx][ny]) {
                        if (board[nx][ny] == 1) {
                            board[nx][ny] = 2;
                        } else {
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            } else {
                // 치즈가 아니라면, 큐에 주변 칸을 추가
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isValid(nx, ny) && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // BFS 수행 후, 방문 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == n - 1 || y == m - 1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
}

        		