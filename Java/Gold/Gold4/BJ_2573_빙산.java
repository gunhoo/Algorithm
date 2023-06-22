package Gold.Gold4;

import java.awt.*;
import java.util.*;
import java.io.*;

public class BJ_2573_빙산 {
	private static int N, M, map[][], year = 0, totalIsland, direction[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	private static Point island;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true){
			sink();
			year++;
			if(totalIsland == 0 || checkSeperation()) break;
		}
		if(totalIsland == 0) year = 0;
        System.out.println(year);
	}

	private static void sink(){
		totalIsland = 0;
		int[][] tmpMap = new int[N][M];
		for(int i =0 ;i < N ; i++){
			tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		for(int i = 0 ; i < N; i++){
			for(int j =0 ; j < M ; j++){
				if(map[i][j] != 0) {
					int remain = tmpMap[i][j] - sumOcean(i, j);
					tmpMap[i][j] = remain < 0? 0 : remain; // i,j에 인접한 바다 면적 빼줌
					if(tmpMap[i][j] != 0) {
						totalIsland++;
						island = new Point(i, j);
					}
				}
			}
		}
		for(int i =0 ;i < N ; i++){
			map[i] = Arrays.copyOf(tmpMap[i], tmpMap[i].length);
		}
	}

	private static int sumOcean(int x, int y){
		int size =0 ;
		if(map[x-1][y] == 0) size++;
		if(map[x+1][y] == 0) size++;
		if(map[x][y-1] == 0) size++;
		if(map[x][y+1] == 0) size++;
		return size;
	}

	private static boolean checkSeperation(){
		int sum  = 1;
		visited = new boolean[N][M];
		Queue<Point> q = new ArrayDeque<>();
		q.add(island);
		visited[island.x][island.y] = true;
		while(!q.isEmpty()){
			Point point = q.poll();
			for(int i = 0 ; i < 4; i++){
				int nx = point.x + direction[i][0];
				int ny = point.y + direction[i][1];
				if( 0>nx || nx >= N || 0>ny || ny>=M || visited[nx][ny] || map[nx][ny] == 0) continue;
				q.add(new Point(nx, ny));
				visited[nx][ny] = true;
				sum++;
			}
		}
		if(sum != totalIsland) return true;
		return false;
	}
}
