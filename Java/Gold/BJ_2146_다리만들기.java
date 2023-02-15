package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 섬을 arraylist<Node>로 넘기고 tmpMap을 0으로 만들어줘 > arrayList에서 하나씩 뽑아서 map에 있는 1이랑 비교
 * (a-x + b-y -1) : 다리수
 * 다리수 1인거 찾으면 바로 탈출 : 시간단축 
 * @author gunhoo
 *
 */
public class BJ_2146_다리만들기 {
	static int n;
	static int[][] map;
	static int min;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		min = 2*n-3; // maximun 값으로 설정
		int lastX = 0, lastY = 0;
		for(int i = 0 ; i< n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if( map[i][j] == 1) {
					lastX = i;
					lastY = j;
				}
			}
		}
		// 입력 완료 //
		bfs(lastX, lastY); // 마지막 섬에서 시작
		System.out.println(min);
		
	}
	private static void bfs(int a, int b) {

		Queue<Node> island = new LinkedList<>(); // 마지막 섬 전체를 담는 arraylist이다
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a, b));
		island.add(new Node(a, b));
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0 ; i< 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if( 0<=nx && nx<n && 0<=ny && ny<n && map[nx][ny] == 1) {
					map[nx][ny] = 0; // 0으로 바꿔주는대신
					island.add(new Node(nx, ny)); // island 에 넣어줘
					q.add(new Node(nx, ny)); // 다음부터 탐색하기 위해
				}
			}
		}
		
		
		
		// island에 있는 얘들 중 고립된 얘 아니면 bfs 돌아서 최단거리 구해
		while(!island.isEmpty()) {
			Node node = island.poll();
			if (isolated(node))continue; // 고립된 얘면 pass
			int sum = 0;
			Queue<Node> tmp = new LinkedList<Node>();
			tmp.add(node);
			while(!tmp.isEmpty()) {
				for(int i = 0 ; i< 4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					if( 0<=nx && nx<n && 0<=ny && ny<n) {
						if( map[nx][ny] == 1) {
							min = Math.min(min, sum);
							break;
						}
						else if( map[nx][ny] == 0) {
							tmp.add(new Node(nx, ny)); // 다음부터 탐색하기 위해
							sum++; // 거리추가
						}
					}
					
				}
			}
			
		}
		
		
		
		
		/** ************************************************************ */
		// 마지막 섬에 대한 정보가 island에 다 들어가 있다.
		// 이걸 뽑아서 map과 비교하면 된다.

		// 비교 로직 > 최솟값 업데이트
		/*
		int numOfOne = 0;
		int nextIslandX=0, nextIslandY=0;
		for(Node node : island) {
			if(isolated(node)) continue; // 만약 고립된 거라면 볼필요 없음
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j< n ; j++) {
					if(map[i][j] == 1 && !isolated(new Node(i,j))) { // 1인데를 찾았고 그게 고립된게 아니면,
						numOfOne++;
						nextIslandX = i; // 남아있는 섬 좌표 업데이트
						nextIslandY = j; // 남아있는 섬 좌표 업데이트
						min = Math.min(min, Math.abs(node.x-i)+Math.abs(node.y-j)-1);
						if( min == 1 ) return; // 1이 최저값으로 찾았다면 바로 종료
					}
				}
			}
			if(numOfOne == 0) return; // 1의 개수가 없다면 다 찾은것이므로 종료
		}
		
		// 아직 남아있는 섬이 있으면 > 다시 bfs()돌려 
		if( nextIslandX != 0 && nextIslandY !=0) {
			bfs(nextIslandX, nextIslandY);
		}*/
	}
	private static boolean isolated(Node node) { // 사방탐색해서 하나라도 0발견되면 고립된게 아님
		if(map[node.x][node.y-1>=0?node.y-1:0] == 0) return false; // 왼쪽
		if(map[node.x][node.y+1<n?node.y+1:n-1] == 0) return false;
		if(map[node.x-1>=0?node.x-1:0][node.y] == 0) return false;
		if(map[node.x+1<n?node.x+1:n][node.y] == 0) return false;
		return true;
	}
	static class Node{
		int x, y;
		public Node(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}

}
