import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11729_하노이탑이동순서_박건후 {
	private static int total = 0;
	private static StringBuilder str = new StringBuilder("");
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		hanoi(n, 1, 2, 3);
		System.out.println(total);
		System.out.print(str);
	}
	private static void hanoi(int n, int a, int b, int c) {
		if(n == 1) {
			total++;
			str.append(a+" "+c+"\n");
			return;
		}
		hanoi(n-1, a, c, b);
		total++;
		str.append(a+" "+c+"\n");
		hanoi(n-1, b, a, c);
	}
}
