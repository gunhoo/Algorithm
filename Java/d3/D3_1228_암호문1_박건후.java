import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * SWEA D3 1228 암호문1
 * 
 * @author 박건후
 *
 */
public class D3_1228_암호문1_박건후 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10 ; test_case++) {
			int length = Integer.parseInt(br.readLine()); // n입력
			LinkedList<Integer> arr = new LinkedList<>(); // 원래 암호문
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i< length ; i++)  arr.add(Integer.parseInt(st.nextToken()));
			
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< cnt ; i++) { // 명령어 수만큼 
				if(! st.nextToken().equals("I")) { // 예외케이스 
					break;
				}
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken());
				if( x >=10 ) { // 시간단축용 : 10까지만 출력하기 때문에 10 이후에 넣는건 안해줘도 된다
					for(int j = 0; j< y; j++)  st.nextToken(); // arr에 add안해주고 그냥 탈출
				}else {
					for(int j = 0 ; j< y; j++) {
						arr.add(x++, Integer.parseInt(st.nextToken())); // 값 추가
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i = 0 ; i< 10 ; i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			
		}
	}

}
