package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 풀이시간 11:00 ~ 11:30 ?? 구현x
 * 
 * @author Gunhoo
 *
 */
public class BJ_3020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int h = Integer.parseInt(line[0]);
		int[] sucksoon = new int[n/2];
		int[] jongyoo = new int[n/2];
		int wall = n;
		int cnt = 0;
		
		for(int t = 0; t<n/2; t++) {
			sucksoon[t] = Integer.parseInt(br.readLine());
			jongyoo[t] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(sucksoon);
		Arrays.sort(jongyoo);
		
		for(int i = 0; i< n/2;i++) {
			if(sucksoon[i]+jongyoo[i] < h) {
				cnt = h-(sucksoon[i]+jongyoo[i]);
				continue;
			}else {
				
			}
		}
		System.out.println(cnt);
	}

}
