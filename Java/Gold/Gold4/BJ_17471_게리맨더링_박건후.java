package Gold.Gold4;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링 {
	static class City{ // 지역 정보를 담는 클래스
		int num; // 번호
		int pop; // 인구수
		public City(int num, int pop) {
			this.num = num;
			this.pop = pop;
		}
	}

	static int N; // 총 도시 수
	static City[] city; // 도시 배열
	static int answer = Integer.MAX_VALUE; 
	static ArrayList<ArrayList<Integer>> list; // 2차원 ArrayList생성
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		city = new City[N+1];
		list = new ArrayList<>();
		for(int i =0  ; i <= N ; i++) {
			list.add(new ArrayList<>()); // N개의 arraylist생성
		}
		for(int i =1  ; i <= N ; i++) {
			city[i] = new City(i, Integer.parseInt(st.nextToken())); // city정보 추가
		} 
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int size = parseInt(st.nextToken());
			for(int j =0 ; j < size; j++) {
				int ci = parseInt(st.nextToken()); // 도시수만큼
				list.get(i).add(ci); // 연결된 간선 넣기
			}
		}
		
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i = 1; i <= N/2 ; i++) {
			permutation(1, N, i, tmp);
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1: answer);
	}
	
	
	static int[] numbers;
	
	private static void permutation(int start, int N, int r, ArrayList<Integer> tmp) {
		if (r==0) { // 종료조건
			devide(tmp); // 도시 쪼개는 메서드 호출
			return; // 종료
		}
		for (int i = start; i<= N ; i++) {
			tmp.add(i); // 숫자 고르고,
			permutation(i+1, N, r-1, tmp); // 조합 추가
			tmp.remove(tmp.size()-1); // 맨 뒤 제거
		}
	}
	
	private static void devide(ArrayList<Integer> tmp) {
		// numbers에 합쳐질 노드 정보 들어와
		if(!bfs(city[tmp.get(0)].num, tmp, tmp.size())) { // 
			return;
		}
		ArrayList<Integer> tmp2 = new ArrayList<>(); // 선택되지 않은 다른 도시들 담기 위한 arrayList
		for(int i = 1; i <= N ; i++) {
			if(tmp.contains(i)) continue; // 이미 선택된 지역이면 pass
			tmp2.add(i); // 넣어주기
		}
		
		if(!bfs(city[tmp2.get(0)].num, tmp2, tmp2.size())) return;
		int sum1 = 0, sum2 =0; // 지역별 인구수 저장 위한 변수
		for(int i= 0; i < tmp.size() ; i++) {
			sum1 += city[tmp.get(i)].pop; // tmp에서 뽑고
		}
		for(int i =0; i < tmp2.size() ; i++) {
			sum2 += city[tmp2.get(i)].pop; // tmp2에서 뽑아
		}
		
		
		answer = Math.min(answer, Math.abs(sum1-sum2));
	}
	// bfs로 돌면서 연결되어있는지 확인
	private static boolean bfs(int num, ArrayList<Integer> arr, int size) {
		boolean []isVisited =new boolean[N+1];
		isVisited[num] = true;
		Queue<Integer> q= new LinkedList<>();
		q.offer(num);
		
		int count = 1;
		while(!q.isEmpty()) {
			int start = q.poll();
			for(int i : list.get(start)) {
				if(isVisited[i] == false && arr.contains(i)) {
					isVisited[i] = true;
					count++;
					q.offer(i);
				}
			}
		}
		if(count == size) return true;
		return false;
	}
	

}
