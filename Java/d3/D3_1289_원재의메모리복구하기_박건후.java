import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1289_원재의메모리복구하기_박건후 {		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			int ans = 0; // 정답을 저장하기 위한 변수 ans
			String str = br.readLine(); // 입력받음
			char c = str.charAt(str.length()-1); // 문자 비교를 위해 마지막에 있는 char 가져온다.
			ans += str.charAt(0)-48; // 처음에 1이오면 전체를 한번 더 뒤집어 줘야 하므로 1을 더해준다.
			
			for(int i = str.length()-1; i>=0 ; i--) {
				if(str.charAt(i) != c){ // 마지막부터 시작하는데 그 이전 값들과 비교해서 달라지면,
					c = str.charAt(i); // c를 그 값으로 갱신하고
					ans += 1; // 바뀐 문자가 나왔으므로 1을 더해준다
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}		
}