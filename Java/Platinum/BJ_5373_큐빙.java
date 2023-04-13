package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5373_큐빙 {
	static char[] back, front, left, right, up, down;
	static int N;
	static String[] input;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc ; t++) {
			init();
			N = Integer.parseInt(br.readLine());
//			input = new String[N];
			input = br.readLine().split(" ");
			rotation();
			printCube();
		}
		
	}
	
	
	private static void rotation() {
		for(int i =0 ; i < input.length; i++) {
			char dir = input[i].charAt(1);
			switch(input[i].charAt(0)) {
			case 'U':
			case 'D':
			case 'F':
			case 'B':
			case 'L':
			case 'R':
			}
		}
	}
	
	
	private static void init() {
		back = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o','o','o'};
		front = new char[]{'r', 'r', 'r', 'r', 'r', 'r', 'r','r','r'};
		left = new char[] {'g', 'g', 'g', 'g', 'g', 'g', 'g','g','g'};
		right = new char[]{'b', 'b', 'b', 'b', 'b', 'b', 'b','b','b'};
		up = new char[]   {'w', 'w', 'w', 'w', 'w', 'w', 'w','w','w'};
		down = new char[] {'y', 'y', 'y', 'y', 'y', 'y', 'y','y','y'};
	}
	
	private static void printCube() {
		for(int i =0 ;i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(up[3*i+j]);
			}
			System.out.println();
		}
	}

}
