package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_10867_중복빼고정렬하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> arr = new HashSet<>();
		
		for(int i = 0 ; i < n ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr.add(tmp);
		}
		List<Integer> newArr = new ArrayList<>(arr);
		Collections.sort(newArr);
		for(int i = 0 ; i< newArr.size(); i++) System.out.print(newArr.get(i)+" ");
	}

}
