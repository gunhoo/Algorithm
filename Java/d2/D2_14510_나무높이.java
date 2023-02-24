package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개 나무&키
 * 하루에 한 나무 물줘 > 
 * 물 준 나무는 홀수 1자라고 짝수날 2씩 자라
 * 모든 나무의 키가 처음에 가장 키가 컸던 나무와 같아지도록 할 수 있는 최소날짜수
 * 각 나무마다 짝수홀수 몇번씩해야하는지 구해
 * 1부터 odd+even까지 보면서 하나씩 빼줘 > 하루씩 늘려
 * 
 * @author 박건후
 *
 */
public class D2_14510_나무높이 {
	static int N;
	static int[] trees;
	static int max =0;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t ; test_case++) {
			N = Integer.parseInt(br.readLine());
			trees =new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0 ; i < N ; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(trees[i] > max) max = trees[i]; // max값 갱신
			}
			
			
		}
	}

}
