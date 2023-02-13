package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BJ_2309_일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> arr = new HashSet<>();
		for(int i = 0; i<9;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		List<Integer> newArr = new LinkedList<>(arr);
		Collections.sort(newArr);
		for(int i : newArr) System.out.println(i);
		
	}

}
