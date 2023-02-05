package Gold;

import java.util.Scanner;

public class BJ_9663 {
	private static int n;
	private static int[] arr;
	private static int count =0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		
		backtracking(0);
		System.out.println(count);
	}

	private static void backtracking(int depth) {
		if(depth == n) {
			count++;
			return;
		}
		
		for(int i=0; i< n; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				backtracking(depth+1);
			}
		}
	}
	
	private static boolean possible(int col) {
		for (int i = 0; i< col; i++) {
			if(arr[i] == arr[col]) {
				return false;
			}
			else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
				return false;
			}
		}
		return true;
	}
}
