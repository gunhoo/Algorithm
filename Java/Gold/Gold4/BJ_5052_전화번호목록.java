package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_5052_전화번호목록 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			Map<String, String> map = new HashMap<>();
			String[] phone = new String[n];
			
			for(int i =0;i < n ;i++) {
				phone[i] = br.readLine().replaceAll(" ", "");
				map.put(phone[i], "");
			}
			boolean tf = false;
			out: for(String phoneNum : phone) {
				for(int i = 1; i < phoneNum.length(); i++) {
					if(map.containsKey(phoneNum.substring(0, i))) {
						tf = true;
						break out;
					}
				}
			}
			
			if(tf) System.out.println("NO");
			else System.out.println("YES");
		}
	}

}
