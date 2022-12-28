package Bronze;
import java.io.*;
import java.util.*;

public class B2455 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int e = scanner.nextInt();
		int f = scanner.nextInt();
		int g = scanner.nextInt();
		int h = scanner.nextInt();
		int arrays[] = {0-a+b, 0-a+b-c+d, 0-a+b-c+d-e+f, 0-a+b-c+d-e+f-g+h};
		Arrays.sort(arrays);
		System.out.println(arrays[3]);

	}

}
