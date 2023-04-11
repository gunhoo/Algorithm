package Gold.Gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136_색종이붙이기 {
	static int map[][] = new int[10][10];
	static int remain[] = {5,5,5,5,5};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		for(int i =0 ; i < 10; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0 ; j < 10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	private static void dfs(int x, int y, int cnt) {
		if(x == 9 && y >9 ) { // 마지막칸으로 갔다면
			answer = Math.min(answer, cnt); // 비교 갱신
			return; // 종료조건
		}
		if(answer <= cnt) return;//종료조건
		
		if( y > 9 ) { // 오른쪽끝에 갔다면
			dfs(x+1, 0, cnt); // 한칸 아래 시작
			return; // 종료조건
		}
		
		if(map[x][y] == 1) { // 색종이 붙일 수 있는 후보
			for(int size = 5; size >= 1; size--) { // 크기 큰것부터 붙여야 최솟값
				if(remain[size-1] > 0 && canAttach(x,y,size)) { // 붙일수 있는 종이가 남았고, 색종이 붙일 수 있으면
					remain[size-1]--; // 붙인 색종이 줄이고 
					attach(x, y, size, 0); // 붙여보고(0으로 만듦)
					dfs(x, y+size, cnt+1); // size만큼이동해보고
					remain[size-1]++; // 원복
					attach(x, y, size, 1); //원복 
				}
			}
		}else { // 붙일 수 없으면 넘어가
			dfs(x, y+1, cnt);
		}
	}
	
	private static void attach(int x, int y, int size, int state) {
		for(int i= x; i < x+size ; i++) {
			for(int j= y; j < y+size ; j++) {
				map[i][j] = state;
			}
		}
	}
	private static boolean canAttach(int x, int y, int size) {
		for(int i= x; i < x+size ; i++) {
			for(int j= y; j < y+size ; j++) {
				if(i < 0 || i>= 10 || j < 0 || j >= 10 || map[i][j] != 1) return false;
			}
		}
		return true;
	}
}
