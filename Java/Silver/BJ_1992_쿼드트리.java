package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i =0 ; i < n; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ; j< n ; j++) map[i][j] = Integer.parseInt(input[j]);
		}
		
		quadTree(0,0,n); // 4분할 쪼개는 메서드
		System.out.println(sb); // 결과값 출력
	}
	private static void quadTree(int r, int c, int size) { // 시작 행, 열, 크기 받음
		int sum = 0; // 섞여있는지 판별하기 위한 메서드
		for(int i =r ; i < r+size; i++) { // 크기만큼
			for(int j = c; j<c+size; j++) {
				sum += map[i][j]; // 크기 내 값 모두 더해
			}
		}
		if(sum == 0) { // 전부 0이면
			sb.append("0"); // 0만 더하고 끝
		}else if( sum == size*size) { // 전부 1이면
			sb.append("1"); // 1로만 있는거니깐 1더하고 끝
		}else { //혼합되어있을경우
			sb.append("("); // ( 붙여주고
			int half = size/2; // 크기 4분할위한 1/2등분
			quadTree(r, c, half); // 1사분할
			quadTree(r, c+half, half); // 2사분할
			quadTree(r+half, c, half); // 4사분할
			quadTree(r+half, c+half, half); // 3사분할
			sb.append(")"); // 종료 후 닫아주기
			
		}
	}

}
