package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 큐에 때려박고
 * 맨 밑 자식부터 자식두개를 부모노드 계산가능하면 계산하여 부모노드에 덮어쓴다
 * 계산이 불가능하면 탈출한다
 * @author SSAFY
 *
 */
public class D4_1233_사칙연산유효성검사_박건후 {
	static class Node{
		String val;
		int left=0, right=0;
		public Node(String obj) {
			this.val = obj;
		}
		public Node(String object, int l, int r ) {
			this.left = l;
			this.right = r;
			this.val = object;
		}
		public Node(String object, int l ) {
			this.left = l;
			this.val = object;
		}
		public boolean isCal() {
			switch(val) {
			case "+":
			case "-":
			case "*":
			case "/": return true;
			}
			return false;
		}
	}
	static Queue<Node> tree;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10 ; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if( n % 2 != 0) {
				tree = new ArrayDeque<Node>();
				for(int i = 1 ; i <= n ; i++) {
					String[] tmp = br.readLine().split(" ");
					if( tmp.length == 4) { // 정점이 아니므로
						tree.add(new Node(tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3])));
					}else if(tmp.length == 3){
						tree.add(new Node(tmp[1], Integer.parseInt(tmp[2]))); // val, left만 넣어줌
					}
					else {
						tree.add(new Node(tmp[1])); // 값만 넣어줌
					}
				}
				if(bfs()) {
					System.out.println("#"+test_case+" 1");
				}else {
					System.out.println("#"+test_case+" 0");
				}				
			}else {
				for(int i = 1 ; i <= n ; i++) {
					br.readLine().split(" "); // 입력만 받고 끝.
				}
				System.out.println("#"+test_case+" 0");
			}
		}
	}
	private static boolean bfs() {
		while(!tree.isEmpty()) {
			Node parent = tree.poll();
			if( parent.isCal()) { // 반약 부모노드가 연산이라면, 자식노드가 둘 다 존재해야 한다.
				if( parent.left==0 || parent.right==0) { // 자식이 없으면
					return false;
				}
			}else { // 부모노드가 연산이 아니라 숫자라면, 정점이어야만 한다.
				if(parent.left != 0 || parent.right != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
