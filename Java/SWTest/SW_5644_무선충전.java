package SWTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5644_무선충전 {
	static int[] moveA, moveB;
	static AP[] APList;
	static Info[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			int A = Integer.parseInt(st.nextToken()); // AP개수
			moveA = new int[M];
			moveB = new int[M];
			APList = new AP[A];
			map = new Info[11][11];
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<M; i++ ) moveA[i] =Integer.parseInt(st.nextToken()); // 사용자 A의 이동정버
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<M; i++ ) moveB[i] =Integer.parseInt(st.nextToken()); // 사용자 B의 이동정보 

			for(int i =0 ; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				APList[i] = new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			
			System.out.println("#"+test_case +" ");
		}
	}
	static class AP{
		int x, y;
		int c, p;
		public AP(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	
	static class Info{
		int apNum, cap;
		public Info(int ap, int cap) {
			this.apNum = ap;
			this.cap = cap;
		}
	}
}
