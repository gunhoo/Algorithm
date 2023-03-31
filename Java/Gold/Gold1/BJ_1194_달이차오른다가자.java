package Gold.Gold1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1194_달이차오른다가자 {
	static int N, M;
	static Node[][] map;
	static int curX, curY;
	static int endX, endY;
	static boolean[] key = new boolean[6];
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map =new Node[N][M];
		for(int i =0 ; i < N; i++) {
			String[] input = br.readLine().split("");
			for(int j =0 ; j < M ; j ++) {
				map[i][j] = new Node(i, j, input[j]);
				if(map[i][j].room.equals("0")) {
					curX = i; curY = j;
				}else if(map[i][j].room.equals("1")) {
					endX = i; endY = j;
				}
			}
		}
		map[curX][curY].dis = 0;
		dfs(curX, curY, map);
		print();
//		System.out.println(map[endX][endY].dis == Integer.MAX_VALUE? -1 : map[endX][endY].dis);
		System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	private static void dfs(int posX, int posY, Node[][] map) {
//		print();
		if(canFinish(map[posX][posY].room)) return;
		if(map[posX][posY].room.equals("1")) {
			answer = Math.min(answer, map[posX][posY].dis);
//			System.out.println("answer: " + answer);
			return;
		}
		for(int i =0 ;i < 4; i++) {
			int nx = posX + dx[i];
			int ny = posY + dy[i];
			if( 0<= nx && nx < N  && ny < M && 0<= ny && !map[nx][ny].room.equals("#") && !map[nx][ny].visited) {
				if(!canOpen(map[nx][ny].room)) continue;
				if(addKey(map[nx][ny].room)) {
					System.out.println("hi"+map[nx][ny].room);
					for(int j =0 ; j < N ; j++) {
						for(int k = 0; k < M ; k++) {
							map[j][k].visited = false;
						}
					}
				}
//				addKey(map[nx][ny].room);
				map[nx][ny].dis = map[posX][posY].dis+1;
				map[nx][ny].visited = true;
				dfs(nx, ny, map);
				map[nx][ny].visited = false;
				map[nx][ny].dis = map[posX][posY].dis-1;
				removeKey(map[nx][ny].room);
			}
		}
	}
	private static boolean addKey(String input) {
		switch(input) {
		case "a":
			key[0] = true;
			return true;
		case "b":
			key[1] = true;
			return true;
		case "c":
			key[2] = true;
			return true;
		case "d":
			key[3] = true;
			return true;
		case "e":
			key[4] = true;
			return true;
		case "f":
			key[5] = true;
			return true;
		}
		return false;
	}
	
	private static void removeKey(String input) {
		switch(input) {
		case "a":
			key[0] = false;
			break;
		case "b":
			key[1] = false;
			break;
		case "c":
			key[2] = false;
			break;
		case "d":
			key[3] = false;
			break;
		case "e":
			key[4] = false;
			break;
		case "f":
			key[5] = false;
			break;
		}
	}
	
	private static boolean canOpen(String input) {
		int keyNum = -1;
		switch(input) {
		case "A":
			keyNum =0;
			break;
		case "B":
			keyNum =1;
			break;
		case "C":
			keyNum =2;
			break;
		case "D":
			keyNum =3;
			break;
		case "E":
			keyNum =4;
			break;
		case "F":
			keyNum =5;
			break;
		default:
			return true;
		}
		return key[keyNum];
	}
	private static boolean canFinish(String input) {
		int keyNum = -1;
		switch(input) {
		case "A":
			keyNum =0;
			break;
		case "B":
			keyNum =1;
			break;
		case "C":
			keyNum =2;
			break;
		case "D":
			keyNum =3;
			break;
		case "E":
			keyNum =4;
			break;
		case "F":
			keyNum =5;
			break;
		default:
			return false;
		}
		return key[keyNum];
	}
	private static void print() {
		for(int i =0; i < N ;i++) {
			for(int j = 0 ; j < M ; j++) {
				System.out.print(map[i][j].visited+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static class Node{
		int x, y, dis;
		String room;
		boolean visited;
		
		public Node(int x, int y, String s) {
			this.x = x;
			this.y = y;
			this.room = s;
			this.dis = Integer.MAX_VALUE;
		}
		public Node(int x, int y, String s, int dis) {
			this.x = x;
			this.y = y;
			this.room = s;
			this.dis = dis;
			this.dis = Integer.MAX_VALUE;
		}
	}
	
	
}
