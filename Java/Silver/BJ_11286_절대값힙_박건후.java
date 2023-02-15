import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**1. 풀이방법
 * PriorityQueue 설정해주고 절대값 정렬 설정하기
 * 
 * @author 박건후
 *
 */
public class BJ_11286_절대값힙_박건후 {
	static PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if( Math.abs(o1)== Math.abs(o2)) return o1-o2; // 절대값같으면 오름차순
			return Math.abs(o1)-Math.abs(o2); // 절대값 오른차순
		}
	});
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i  < n ; i++) {
			int cur = Integer.parseInt(br.readLine());  // 입력 저장
			if( cur != 0 ) q.add(cur); // 0이 아니면 큐에 저장
			else { // 0이면 출력
				if(q.size() == 0) System.out.println(0); // size가 0이면 0출력
				else System.out.println(q.poll()); // 아니면 가장 작은 값 뽑고 출력
			}
		}
		
	}

}
