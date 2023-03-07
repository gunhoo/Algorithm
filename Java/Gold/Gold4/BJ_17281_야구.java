package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1번타자가 무조건 4번타자로 가야해
 * @author 박건후
 *
 */
public class BJ_17281_야구 {
	static int N;
	static int[][] info;
	static int numbers[] = {0,1,2,3,4,5,6,7,8};
	static int score = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		info = new int[N][9];
		for(int i =0; i < N ;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j =0 ; j < 9 ; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		do {
			if(numbers[3] == 0) { // 4번타자가 첫번째일때만
				play(numbers);
			}
		}while(np(numbers));
		System.out.println(score);
	}
	
	private static void play(int[] numbers) {
		int tmpScore = 0; // 이 np로 골랐을 때 플레이했을 때 나오는 점수 기록
		int taja = 0; // 타자 번호
		for(int i =0 ; i < N ; i++) { // N이닝만큼
			int outCnt = 0; // outcount
			int[] roo = new int[3]; // 1,2,3루 타자 저장
			
			while(outCnt < 3) { // 아웃은 3번까지 가능
				switch(info[i][numbers[taja]]) {
				case 0: // 아웃당하면
					outCnt++; // 카운트 증가
					break;
				case 1: // 1루타
					if(roo[2] == 1) { // 3루에 주자 있음
						tmpScore++; // 점수 증가
					}
					roo[2] = roo[1]; // 한칸씩
					roo[1] = roo[0]; // 전진
					roo[0] = 1; // 1루에는 타자 진루
					break;
				case 2: // 2루타
					if(roo[2] == 1) { // 3루에 있으면 
						tmpScore++; // 득점
					}
					if(roo[1] == 1) { // 2루에 있어도
						tmpScore++; // 득점
					}
					if( roo[0] == 1) roo[2] =1; // 1루에 있으면 3루로 진루
					else roo[2] = 0; // 아니면 3루 초기화
					roo[1] = 1; // 2루로 진루
					roo[0] = 0; // 1루는 비어
					break;
				case 3: // 3루타
					if(roo[2] == 1) { // 3루에 있으면
						tmpScore++; // 득점
					}
					if(roo[1] == 1) { // 2루에 있으면
						tmpScore++; // 득점
						roo[1] = 0; // 2루엔 주자 없어
					}
					if(roo[0] == 1) { // 1루에 있으면
						tmpScore++; // 득점
						roo[0] = 0; // 1루엔 주자 없어
					}
					roo[2] = 1; // 3루타니까 주자는 3루에 밖에 없어
					break;
				case 4: // 홈런
					if(roo[2] == 1) {//3루주자
						tmpScore++; // 득점
						roo[2] = 0; // 초기화
					}
					if(roo[1] == 1) { // 2루주자
						tmpScore++;//득점
						roo[1] = 0; // 초기화
					}
					if(roo[0] == 1) {//1루주자
						tmpScore++;//득점
						roo[0] = 0;//초기화
					}
					tmpScore++;//본인도 득점
					break;
				}
				taja++; // 타자번호증가
				taja %= 9; // 8번타자까지 치면 0번으로와야지
			}
		}
		score = Math.max(score, tmpScore); // 맥스값 갱신
	}
	
	private static boolean np(int[] input) { // 순서를 골라주는 메서드
		int n =  input.length;
		
		// step 1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i == 0) return false;
		
		// step2. 꼭대기 바로 앞(i-1) 자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n-1;
		while(input[i-1] >= input[j]) --j;
		
		// step3. 꼭대기 바로 앞 (i-1) 자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
		swap(input, i-1, j);
		
		// step4. 꼭대비부터 맨 뒤까지 오름차순 정렬 
		int k = n-1;
		while(i < k) {
			swap(input, i++, k--);
		}
		return true;
	}
	private static void swap(int[] input, int i , int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
