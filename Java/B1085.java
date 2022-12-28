
import java.io.*;
import java.util.*;

public class B1085 {

	public static void main(String[] args)throws IOException {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int w = scanner.nextInt();
		int h = scanner.nextInt();
		int arrays[] = {x-0, y-0, w-x, h-y};
		Arrays.sort(arrays);
		System.out.println(arrays[0]);

	}

}
