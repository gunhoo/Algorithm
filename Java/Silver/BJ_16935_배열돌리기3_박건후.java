package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BJ_16935 배열돌리기3
 * @author 박건후
 *
 */
public class BJ_16935_배열돌리기3_박건후 {
	static class Node{
		int x,y;
		int val;
		public Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.val = v;
		}
	}
	static int n,m, r;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		String[] commands = br.readLine().split(" ");
		for(int i = 0; i<commands.length; i++) {
			execute(commands[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int j = 0 ; j<map.length; j++) {
			for(int k = 0; k<map[0].length ; k++) {
				sb.append(map[j][k]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}
	
	private static void execute(String command) {
		int[] tmp;
		int[][] tmpMap;
		switch(command) {
		case "1"://상하반전
			n = map.length;
			m =map[0].length;
			tmp = new int[m];
			for(int i=0;i<n/2;i++) {
				tmp = map[i];
				map[i] = map[n-1-i];
				map[n-1-i] = tmp;
			}
			break;
		case "2": // 좌우반전
			n = map.length;
			m = map[0].length;
			tmp = new int[n];
			for(int i=0;i<m/2;i++) {
				for(int j=0;j<n;j++) {
					tmp[j] = map[j][i];
					map[j][i] = map[j][m-1-i];
					map[j][m-1-i] = tmp[j];
				}
			}
			break;
		case "3": // 오른쪽 90 도 회전
			n = map.length;
			m = map[0].length;
			tmpMap = new int[m][n];
			for(int i = 0 ; i< n ; i++) {
				for(int j = 0 ; j< m ; j++) {
					tmpMap[j][i] = map[n-1-i][j];
				}
			}
			map = tmpMap;//Arrays.copyOf(tmpMap, tmpMap.length);
			break;
		case "4": // 왼쪽으로 90도 회전
			n = map.length;
			m = map[0].length;
			tmpMap = new int[m][n]; //가로 세로 반전
			
			for(int i=0;i<n;i++) {
				int cnt = 0;
				tmp = map[i]; //본래 배열의 첫번째 가로줄
				for(int j=m-1;j>=0;j--) {
					tmpMap[j][i] = tmp[cnt++];
				}
			}//배열 생성 끝
			
			map = new int[m][n]; //새로 생성 해주기
			for(int i=0;i<m;i++)
				map[i] = tmpMap[i];
			break;
		case "5": // 섹션별 시계방향 회전
			//배열을 4구획으로 나눈 후 옮기기ㅣ
			n = map.length;
			m = map[0].length;
			tmpMap =new int[n][m];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(i<=(n/2-1) && j<=(m/2-1))
						tmpMap[i][j] = map[i+(n/2)][j];//1번 구역에는 4번 넣어주기
					else if(i<=(n/2-1) && j>=(m/2))
						tmpMap[i][j] = map[i][j-(m/2)];//2번 구역에는 1번 넣어주기
					else if(i>=(n/2) && j<=(m/2-1))
						tmpMap[i][j] = map[i][j+(m/2)];//4번 구역에는 3번 넣어주기
					else if(i>=(n/2) && j>=(m/2))
						tmpMap[i][j] = map[i-(n/2)][j];//3번 구역에는 2번 넣어주기
				}
			}
			for(int i=0;i<n;i++)
				map[i] = tmpMap[i];
			break;
		case "6": // 섹션별 회전인데 반시계방향 회전
			n = map.length;
			m = map[0].length;
			tmpMap =new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(i<=(n/2-1) && j<=(m/2-1))
						tmpMap[i][j] = map[i][j+(m/2)];//1번 구역에는 2번 넣어주기
					else if(i<=(n/2-1) && j>=(m/2))
						tmpMap[i][j] = map[i+(n/2)][j];//2번 구역에는 3번 넣어주기
					else if(i>=(n/2) && j<=(m/2-1))
						tmpMap[i][j] = map[i-(n/2)][j];//4번 구역에는 1번 넣어주기
					else if(i>=(n/2) && j>=(m/2))
						tmpMap[i][j] = map[i][j-(m/2)];//3번 구역에는 4번 넣어주기
						
				}
			}
			for(int i=0;i<n;i++)
				map[i] = tmpMap[i];
			break;
		}
	}

}
