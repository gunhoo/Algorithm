package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * ^v 했을 때 
 * 
 * ^^이거나, x^v이면 odd++
 * ^v이면 even++
 * 
 * @author 박건후
 *
 */
public class BJ_14865_곡선자르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int odd = 1,even =0;
		ArrayList<Node> list = new ArrayList<>();
		boolean increasing = true;
		st = new StringTokenizer(br.readLine());
		int prevX = Integer.parseInt(st.nextToken());
		int prevY = Integer.parseInt(st.nextToken());
		for(int i=0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int nextX = Integer.parseInt(st.nextToken());
			int nextY = Integer.parseInt(st.nextToken());

			if( nextX > prevX ) increasing = true;
			else if(nextX < prevX) increasing = false;

			if( nextY-prevY > 0 && Math.max(nextY, prevY)>0) {
				if(increasing) list.add(new Node(nextX, '+')); // 양수면 솟아오르는 놈
				else list.add(new Node(nextX, '-'));
			}
			else if(nextY-prevY<0&& Math.max(nextY, prevY)>0) {
				if(increasing) list.add(new Node(nextX, '-')); // 음수면 내려오는놈
				else list.add(new Node(nextX, '+'));
			}
			prevX = nextX;
			prevY = nextY;
		}
		Collections.sort(list, new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o1.x-o2.x; // 오름차순 정렬
			}
			
		});
//		while(!list.isEmpty()) {
//			System.out.println(list.remove(0).toString());
//		}
		if(list.size() == 2) even = 1;
		else{
			Node prevNode = list.remove(0);
			LinkedList<Integer> stack = new LinkedList<Integer>();
			while(!list.isEmpty()) {
				stack.add(prevNode.x);
				Node nextNode = list.remove(0);
				if(nextNode.c == '+'){
					if(stack.size() >= 1){
						even++;
					}else{
						odd++;
					}
					stack.add(nextNode.x);
				} else if(nextNode.c == '-'){
					stack.poll();
				}
				prevNode = nextNode;
			}
		}
		
		System.out.println(odd+ " " + even);
		
	}
	
	
	static class Node {
		int x;
		char c;
		public Node(int x, char c) {
			this.x = x;
			this.c = c;
		}
		@Override
		public String toString() {
			return ""+x+c;
		}
	}

}
