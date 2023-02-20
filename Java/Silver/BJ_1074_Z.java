package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BJ 1074 Z
 * 4분할하여 판단
 * 
 * @author 박건후
 *
 */
public class BJ_1074_Z {
	static int n;
	static int rr, cc;
	static int number = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		int size = (int) (Math.pow(2, n));
		rr = Integer.parseInt(input[1]);
		cc = Integer.parseInt(input[2]);
		cut(0, 0, size);	// 재귀 호출 함수
		System.out.println(number);
	}
	private static void cut(int r, int c, int size) {
		if( r == rr & c == cc) return; // 종료 조건
		int half = (size)/2; // 절반으로 쪼개
		if( rr < r + half) { // 위쪽인경우
			if( cc < c+half) { // 왼쪽 위 인경우
				cut(r, c, half); 
			}else { // 오른쪽 위인 경우
				number += half*half; // 1번 섹션더해주고 시작
				cut(r, c+half, half);
			}
		}else { // 아래쪽인경우
			if( cc < c+half) { // 왼쪽 아래쪽 인경우
				number += 2*half*half; // 1,2 번섹션더해주고 시작
				cut(r+half, c, half);
			}else { // 오른쪽 아래쪽인 경우
				number += 3*half*half; // 1,2,3번 섹션 더해주고 시작
				cut(r+half, c+half, half);
			}
		}
	}

}
