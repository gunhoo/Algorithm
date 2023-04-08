package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
/**
 * 요세푸스 문제
 * 1. linkedList로 만들고, 끝이면(다음이없으면) 다시 0부터 시작하게끔 만들어보기
 * @author 박건후 
 *
 */
public class BJ_1158_요세푸스문제_박건후 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int k = Integer.parseInt(tmp[1]);
		LinkedList<Integer> arr = new LinkedList<>();
		for(int i = 1; i<=n ; i++) arr.add(i); // add data
		System.out.print("<");
		int tmpIdx = -1; // 0부터 시작하니까 더하기 해주기 위해 -1부터 시작
		while(!arr.isEmpty()) {
			tmpIdx += k; // k만큼 이동
			while( tmpIdx >= n) { // n보다 크면 0부터 시작하게 끔
				tmpIdx -= n;
			}
			if(arr.size() != 1) 
				System.out.print(arr.remove(tmpIdx--)+", "); // 중간 출력형식
			else System.out.print(arr.remove(tmpIdx--));// 마지막 출력형식
			n--; // 하나 제거했으니 n감소
		}
		System.out.println(">");

	}

}
