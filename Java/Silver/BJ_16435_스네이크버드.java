package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16435_스네이크버드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		List<Integer> fruits = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<n ; i++) {
			fruits.add( Integer.parseInt(st.nextToken()));
		}
		Collections.sort(fruits); // 정렬해서 작은거부터 먹어
		for(int fruit : fruits) {
			if( fruit <= l) l++; // 나보다 작으면 먹고 크기 증가
			else break; // 더이상못먹으면 탈출
		}
		System.out.println(l); //출력
		
	}
}
