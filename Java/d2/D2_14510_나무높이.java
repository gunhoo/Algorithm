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
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] trees;
		int N;
		for(int test_case = 1; test_case <= t ; test_case++) {
			N = Integer.parseInt(br.readLine());
			int max =0, result =0;
			trees =new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0 ; i < N ; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(trees[i] > max) max = trees[i]; // max값 갱신
			}
			int odd =0, even = 0;
			for(int i = 0 ; i < N ; i++) {
				even += (max - trees[i]) / 2;
				odd += (max - trees[i]) % 2;
			}
			
			if( even > odd) { // 만약 짝수증가일이 더 많으면,
				while(Math.abs(even - odd) > 1) { // 둘의 개수차이가 1이하일때까지 
					even--; // 짝수는 하루 빼주고
					odd += 2; // 홀수는 2씩 증가
				}
			}
			
			if(odd > even) result = odd * 2 - 1; // 홀수일이 더 많으면 
			else if(even > odd) result = even * 2; // 짝수일이 더 많으면
			else result = odd + even; // 둘이 같으면  
			
			System.out.println("#" + test_case + " " + result);
			
		}
	}

}
