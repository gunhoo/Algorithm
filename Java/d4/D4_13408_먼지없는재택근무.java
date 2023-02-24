package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_13408_먼지없는재택근무 {
	static int N;
	static int[][] map;
	static Node robot;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t ; test_case++) {
			N = Integer.parseInt(br.readLine());
			for(int i = 0 ; i< N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			robot.x = robot.y = 0; // 0,0에서부터 시작
			String[] commands = br.readLine().split("");
			for(String s : commands)
				execute(s.charAt(0));
		}
	}
	private static void execute(char command) {
		switch(command) {
		case 'R':
		case 'U':
		case 'D':
		case 'L':
		}
	}
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
