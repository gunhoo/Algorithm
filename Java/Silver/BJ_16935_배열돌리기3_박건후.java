package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BJ_16935 배열돌리기3
 * 
 *  
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
			for(int k = 0; k<map[j].length ; k++) {
				sb.append(map[j][k]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static void execute(String command) {
		switch(command) {
		case "1"://상하반전
			for(int i = 0; i< map.length/2 ; i++) {
				int[] tmp = map[i];
				map[i] = map[map.length-1-i];
				map[map.length-1-i] = tmp;
			}
			break;
		case "2": // 좌우반전
			for(int i = 0 ; i< map.length ; i++) {
				for(int j = 0;j<map[0].length/2 ; j++) {
					int tmp = map[i][j];
					map[i][j] = map[i][map[0].length-1-j]; 
					map[i][map[0].length-1-j] = tmp;
				}
			}
			break;
		case "3": // 오른쪽 90 도 회전
			int [][] tmpMap = new int[map[0].length][map.length];
			for(int i = 0 ; i< map.length ; i++) {
				for(int j = 0 ; j< map[0].length ; j++) {
					tmpMap[j][i] = map[map.length-1-i][j];
				}
			}
			map = tmpMap;//Arrays.copyOf(tmpMap, tmpMap.length);
			break;
		case "4": // 왼쪽으로 90도 회전
			int [][] tmpMap2 = new int[map[0].length][map.length];
			for(int i = 0 ; i< map.length ; i++) {
				for(int j = 0 ; j< map[0].length ; j++) {
					tmpMap2[j][i] = map[i][map[0].length-1-j];
				}
			}
			map = tmpMap2;//Arrays.copyOf(tmpMap2, tmpMap2.length);
			break;
		case "5": // 섹션별 시계방향 회전
			Queue<Integer> tmp = new LinkedList<>();
			// 1번 섹션을 4번섹션으로 덮는다
			for(int i = 0 ; i< map.length/2 ; i++) {
				for(int j = 0 ; j< map[i].length/2 ; j++) {
					tmp.add(map[i][j]);
					map[i][j] = map[i+map.length/2][j];
				}
			}
			// 2번섹션을 1번섹션(tmp에 있는 값)으로 덮고, tmp에 2번섹션을 넣어준다
			for(int i = 0 ; i< map.length/2 ; i++) {
				for(int j = map[i].length/2+map[i].length%2 ; j<map[i].length ; j++) {
					tmp.add(map[i][j]);
					map[i][j] = tmp.poll();
				}
			}
			// 3번섹션을 2번섹션(tmp에 있는 값)으로 덮고, tmp에 3번섹션을 넣어준다.
			for(int i =  map.length/2+map.length%2; i< map.length; i++) {
				for(int j = map[i].length/2+map[i].length%2 ; j<map[i].length ; j++) {
					tmp.add(map[i][j]);
					map[i][j] = tmp.poll();
				}
			}
			// 4번섹션을 3번섹션(tmp에 있는 값)으로 덮는다.
			for(int i = map.length/2+map.length%2; i< n; i++) {
				for(int j = 0 ; j<map[i].length/2 ; j++) {
					map[i][j] = tmp.poll();
				}
			}
			break;
		case "6": // 섹션별 회전인데 반시계방향 회전
			Queue<Integer> tmp2 = new LinkedList<>();
			// 1번 섹션을 tmp에 넣어주고 2번섹션으로 덮는다  
			for(int i = 0 ; i< map.length/2 ; i++) {
				for(int j = 0 ; j< map[i].length/2 ; j++) {
					tmp2.add(map[i][j]);
					map[i][j] = map[i][j+map[i].length/2];
				}
			}
			// 4번섹션을 1번섹션(tmp에 있는 값)으로 덮는다.
			for(int i = map.length/2+map.length%2; i< map.length; i++) {
				for(int j = 0 ; j<map[i].length/2 ; j++) {
					tmp2.add(map[i][j]);
					map[i][j] = tmp2.poll();
				}
			}
			
			// 3번섹션을 4번섹션(tmp에 있는 값)으로 덮고, tmp에 3번섹션을 넣어준다.
			for(int i = map.length/2+map.length%2; i< map.length; i++) {
				for(int j = map[i].length/2+map[i].length%2 ; j<map[i].length ; j++) {
					tmp2.add(map[i][j]);
					map[i][j] = tmp2.poll();
				}
			}
			// 2번섹션을 3번섹션(tmp에 있는 값)으로 덮는다
			for(int i = 0 ; i< map.length/2 ; i++) {
				for(int j = map[i].length/2+map[i].length%2 ; j<map[i].length ; j++) {
					map[i][j] = tmp2.poll();
				}
			}
			break;
		}
	}

}
