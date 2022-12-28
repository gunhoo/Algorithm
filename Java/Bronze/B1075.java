package Bronze;
import java.util.*;
import java.io.*;

public class B1075 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int newNum = n/100 * 100;
		int f = Integer.parseInt(br.readLine());
		for(int i=0; i<100; i++) {
			if((newNum+i)%f==0) {
				System.out.format("%02d", i);
				break;
			}
		}
	}
}
