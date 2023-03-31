package Algorithm;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i =1; i <= N ; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[][] D = new int[N+1][W+1];
		
		// initialize
		for(int i = 1; i <= N ; i++) { // i : items
			for(int w =1; w<= W; w++) { // w : weights
				if(weights[i] > w) {
					D[i][w] = D[i-1][w];
				}else {
					D[i][w] = Math.max(D[i-1][w], profits[i]+D[i-1][w-weights[i]]);
				}
			}
		}
		System.out.println(D[N][W]);
	}

}
