package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 물 먼저 채우기 > 비버 이동하기
 * 물 * 돌 X 비버 D 고슴 S
 * @author 박건후
 *
 */
public class BJ_3055_탈출 {
	static char[][] map, tmap;
	static int N, M, answer = Integer.MAX_VALUE;
	static boolean[][] visited;
	static Point gsdc;
	private static int direction[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		tmap = new char[N][M];
		visited = new boolean[N][M];
		for(int i =0;i < N;i++) {
			String input = br.readLine();
			for(int j =0 ; j <M ;j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'S') {
					gsdc = new Point(i,j, 0); // 처음 고슴도치 위치
				}
			}
		}
		move();
		System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer); // 갱신안됐으면 불가능 / 아니면 정답출력
	}
	
	private static void sinking() { // 물이 차는 메서드
		for(int i =0;i < N;i++) {
			tmap[i] = Arrays.copyOf(map[i], map[i].length); // 임시배열 생성 
		}
		for(int i =0 ;i < N ; i++) { // 완탐하면서
			for(int j = 0; j < M ; j++) {
				if(map[i][j] == '.') { // 땅인데
					for(int k =0 ; k < 4; k++) { // 주변에
						int nx = i+direction[k][0]; // 이동하면서
						int ny = j+direction[k][1];
						if(0<=nx && nx < N && 0<= ny && ny < M && map[nx][ny] == '*') { // 물이있으면
							tmap[i][j] = '*'; // 물이 찬다
							break; // 시간단축
						}
					}
				}
			}
		}
		for(int i =0;i < N;i++)  map[i] = Arrays.copyOf(tmap[i], tmap[i].length); // 물이 찬 맵으로 갱신
	}
	
	private static void move() {
		Queue<Point> q = new ArrayDeque<>(); // bfs위한 queue생성
		q.offer(gsdc); // 처음장소
		visited[gsdc.x][gsdc.y] = true; // 방문체크
		int depth = 0; // 거리
		while(!q.isEmpty()) { // bfs조건
			Point point = q.poll(); // 계속 뽑아
			if(depth == point.dis) { // 가능한 조건 체크
				depth++; // 시간 추가
				sinking(); // 물이 차오른다
			}
			if(map[point.x][point.y] == '*') continue; // 만약 그곳이 물이 차올라서 물이됐으면 continue
			for(int i =0 ; i < 4; i++) { // 4방탐색
				int nx = point.x + direction[i][0];
				int ny = point.y + direction[i][1];
				if( 0<= nx && nx < N && ny>=0 && ny<M && !visited[nx][ny]) { // 그곳이 범위안에있고, 방문하지 않았다면
					if(map[nx][ny] == '.' ) { // 근데 그곳이 갈 수 있는 곳이라면
						visited[nx][ny] = true; // 방문
						map[nx][ny] = 'S'; // 고슴도치가 간다
						map[point.x][point.y] = '.'; // 기존은 다시 . 으로
						q.offer(new Point(nx, ny, point.dis+1)); // 큐에 넣어줘
					}else if(map[nx][ny] =='D') { // 만약 동굴찾았다면
						answer = point.dis+1; // 갱신
						return; // 바로 끝낼 수 있어,  왜냐면 bfs 니깐(너비우선이니까)
					}
				}
			}
		}
	}

	static class Point{
		int x, y, dis;
		public Point(int x, int y, int dis) {
			this.x =x;
			this.y =y;
			this.dis = dis;
		}
	}

}
