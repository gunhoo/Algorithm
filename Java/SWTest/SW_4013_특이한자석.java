package SWTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 4개쓰고 각 시계마다 idx 만들어 idx =0 
 * 시계방향이면 idx+2 % 8 
 * 반시계방향이면 idx-2 >= 0? idx-2: 6+idx 
 *   
 * @author SSAFY
 *
 */
public class SW_4013_특이한자석 {
	static int[][] mag;
	static int[] pointers; // 맨위부분 가리키는 메서드
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t ; test_case++) {
			mag = new int[4][8]; // 4개 자석을 8칸으로 
			pointers = new int[4]; // 맨 위를 가르키는
			int K = Integer.parseInt(br.readLine()); // 자석을 회전시킬 횟수
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				rotation(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), -1);
//				print(); // 테스트 위한 메서드
			}
			
			System.out.println("#"+test_case + " "+ count());
		}
	}
	
	/**
	 * 
	 * @param num :몇번을 돌려야하는지
	 * @param dir : 방향
	 * @param second : 어디에서 온건지
	 */
	private static void rotation(int num, int dir, int second) { 
		switch(num) {
		case 0: // 0이면 오른쪽 봐야해
			// 0번 자석의 오른쪽(+2)가 1번 자석의 왼쪽(-2)랑 다르면 
			if(mag[0][(pointers[0]+2) % 8] != mag[1][pointers[1]-2>=0?pointers[1]-2:6+pointers[1]]) { // 두개가 서로 다르면  
				rotation(1, 0-dir, 0);  // 1번 자석도 돌려야해 
			}
			pointers[0] -= dir; // 0번의 가리키는 곳 돌려줘 (증가 또는 감소)
			if(pointers[0] < 0) pointers[0] = 7; // 음수면 마지막으로
			else if(pointers[0] > 7) pointers[0] = 0; // 범위초과면 0으로
			break;
		case 1: // 1이면 양 옆 봐야해 
			if(second == 0) { // 만약 0에서 넘어온 거라면, 오른쪽으로만 보면 돼   
				// 1의 오른쪽(+2)와 2의(-2)를 비교해서 다르면
				if(mag[1][(pointers[1]+2)%8] != mag[2][pointers[2]-2>=0?pointers[2]-2:6+pointers[2]]) { // 두개가 서로 다르면  
					rotation(2, 0-dir, 1);  // 2번 자석도 돌려야해, 방향은 역순이고, 1번에서 출발해 
				}
				pointers[1] -= dir; // 0번에서 영향을 받았으니 1번의 가리키는 곳 돌려줘 (증가 또는 감소)
				if(pointers[1] < 0) pointers[1] = 7; // 음수면 마지막으로
				else if(pointers[1] > 7) pointers[1] = 0; // 범위초과면 0으로
			}
			else if(second == 2){ // 만약 2에서 넘어온 거라면 0만 비교해서 바꾸면 돼
				// 0의 오른쪽(+2)랑 1의왼쪽(-2) 랑 비교해서 다르면
				if(mag[0][(pointers[0]+2)%8] != mag[1][pointers[1]-2>=0?pointers[1]-2:6+pointers[1]]) { // 두개가 서로 다르면  
					pointers[0] += dir; // 0번의 가리키는 곳 돌려줘 (증가 또는 감소)
					if(pointers[0] < 0) pointers[0] = 7; // 음수면 마지막으로
					else if(pointers[0] > 7) pointers[0] = 0; // 범위초과면 0으로 
				}
				pointers[1] -= dir; // 2번에서 영향을 받았으니 1번의 가리키는 곳 돌려줘 (증가 또는 감소)
				if(pointers[1] < 0) pointers[1] = 7; // 음수면 마지막으로
				else if(pointers[1] > 7) pointers[1] = 0; // 범위초과면 0으로
			}
			else { // 처음부터 1이였다면 0과 2 비교해서 넘어가야 해
				// 1, 0두개가 서로 다르면
				if(mag[0][(pointers[0]+2)%8] != mag[1][pointers[1]-2>=0?pointers[1]-2:6+pointers[1]]) {
					pointers[0] += dir; // 가리키는 곳 돌려줘 (증가 또는 감소)
					if(pointers[0] < 0) pointers[0] = 7; // 음수면 마지막으로
					else if(pointers[0] > 7) pointers[0] = 0; // 범위초과면 0으로 
					
				}
				// 1, 2 두개가 서로 다르면
				if(mag[1][(pointers[1]+2)%8] != mag[2][pointers[2]-2>=0?pointers[2]-2:6+pointers[2]]) { // 두개가 서로 다르면  
					rotation(2, 0-dir, 1);  // 2번 자석도 돌려야해 
				}
				pointers[1] -= dir; // 가리키는 곳 돌려줘 (증가 또는 감소)
				if(pointers[1] < 0) pointers[1] = 7; // 음수면 마지막으로
				else if(pointers[1] > 7) pointers[1] = 0; // 범위초과면 0으로
			}
			
			break;
		case 2:
			if(second == 1) { // 만약 1에서 넘어온 거라면  
				if(mag[2][(pointers[2]+2) % 8] != mag[3][pointers[3]-2>=0?pointers[3]-2:6+pointers[3]]) { // 두개가 서로 다르면  
					pointers[3] += dir; // 가리키는 곳 돌려줘 (증가 또는 감소)
					if(pointers[3] < 0) pointers[3] = 7; // 음수면 마지막으로
					else if(pointers[3] > 7) pointers[3] = 0; // 범위초과면 0으로
				}
				pointers[2] -= dir; // 가리키는 곳 돌려줘 (증가 또는 감소)
				if(pointers[2] < 0) pointers[2] = 7; // 음수면 마지막으로
				else if(pointers[2] > 7) pointers[2] = 0; // 범위초과면 0으로
			}else if(second == 3){ // 만약 3에서 넘어온 거라면 1로만 가면 돼
				if(mag[1][(pointers[1]+2) % 8] != mag[2][pointers[2]-2>=0?pointers[2]-2:6+pointers[2]]) { // 두개가 서로 다르면  
					rotation(1, 0-dir, 2);
				}
				pointers[2] -= dir; // 일단 가리키는 곳 돌려줘 (증가 또는 감소)
				if(pointers[2] < 0) pointers[2] = 7; // 음수면 마지막으로
				else if(pointers[2] > 7) pointers[2] = 0; // 범위초과면 0으로
			}else { // 처음부터 2였다면
				// 1, 2두개가 서로 다르면
				if(mag[1][(pointers[1]+2)%8] != mag[2][pointers[2]-2>=0?pointers[2]-2:6+pointers[2]]) {
					rotation(1, 0-dir, 2);  // 1번 자석도 돌려야해 
				}
				// 2, 3 두개가 서로 다르면
				if(mag[2][(pointers[2]+2)%8] != mag[3][pointers[3]-2>=0?pointers[3]-2:6+pointers[3]]) { // 두개가 서로 다르면  
					pointers[3] += dir; // 가리키는 곳 돌려줘 (증가 또는 감소)
					if(pointers[3] < 0) pointers[3] = 7; // 음수면 마지막으로
					else if(pointers[3] > 7) pointers[3] = 0; // 범위초과면 0으로
				}
				pointers[2] -= dir; // 가리키는 곳 돌려줘 (증가 또는 감소)
				if(pointers[2] < 0) pointers[2] = 7; // 음수면 마지막으로
				else if(pointers[2] > 7) pointers[2] = 0; // 범위초과면 0으로
			}
			break;
		case 3: // 3이면 왼쪽만 봐
			if(mag[2][(pointers[2]+2)%8] != mag[3][pointers[3]-2>=0?pointers[3]-2:6+pointers[3]]) { // 두개가 서로 다르면  
				rotation(2, 0-dir, 3);  // 2번 자석도 돌려야해 
			}
			pointers[3] -= dir; // 가리키는 곳 돌려줘 (증가 또는 감소)
			if(pointers[3] < 0) pointers[3] = 7; // 음수면 마지막으로
			else if(pointers[3] > 7) pointers[3] = 0; // 범위초과면 0으로
			break;
		}
	}
	
	private static int count() {
		int sum = 0;
		for(int i =0 ; i < 4; i++) {
			if(mag[i][pointers[i]] == 1) {
				sum += (int)Math.pow(2, i);
			}
		}
		return sum;
	}
	
//	private static void print() {
//		for(int i =0 ; i < 4 ; i++) {
//			for(int j=0 ; j < 8 ; j++) {
//				System.out.print(mag[i][j]+" ");
//			}
//			System.out.println(pointers[i]);
//		}
//		System.out.println();
//	}

}
