package Gold.Gold4;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링 {
	static class City{
		int num;
		int pop;
		public City(int num, int pop) {
			this.num = num;
			this.pop = pop;
		}
	}

	static int N;
	static City[] city;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		city = new City[N+1];
		list = new ArrayList<>();
		for(int i =0  ; i <= N ; i++) {
			list.add(new ArrayList<>());
		}
		for(int i =1  ; i <= N ; i++) {
			city[i] = new City(i, Integer.parseInt(st.nextToken()));
		} 
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int size = parseInt(st.nextToken());
			for(int j =0 ; j < size; j++) {
				int ci = parseInt(st.nextToken());
				list.get(i).add(ci);
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
		if (r==0) {
			devide(tmp);
			return;
		}
		for (int i = start; i<= N ; i++) {
			tmp.add(i);
			permutation(i+1, N, r-1, tmp);
			tmp.remove(tmp.size()-1);
		}
	}
	
	private static void devide(ArrayList<Integer> tmp) {
		// numbers에 합쳐질 노드 정보 들어와
		if(!check(city[tmp.get(0)].num, tmp, tmp.size())) {
			return;
		}
		ArrayList<Integer> tmp2 = new ArrayList<>();
		for(int i = 1; i <= N ; i++) {
			if(tmp.contains(i)) continue;
			tmp2.add(i);
		}
		
		if(!check(city[tmp2.get(0)].num, tmp2, tmp2.size())) return;
		int sum1 = 0, sum2 =0;
		for(int i= 0; i < tmp.size() ; i++) {
			sum1 += city[tmp.get(i)].pop;
		}
		for(int i =0; i < tmp2.size() ; i++) {
			sum2 += city[tmp2.get(i)].pop;
		}
		
		
		answer = Math.min(answer, Math.abs(sum1-sum2));
	}
	
	private static boolean check(int num, ArrayList<Integer> arr, int size) {
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
