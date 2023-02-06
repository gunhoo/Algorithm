import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10872_팩토리얼_박건후 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 1;
		if(n >= 1)
			for(int i = 1; i<=n;i++)
				sum *= i; 
		System.out.println(sum);
	}
}
