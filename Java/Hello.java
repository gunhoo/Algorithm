import java.util.*;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ctrl+shft+l	단축기 전체 목록보기
		// ctrl + - 폰트크기 증가/감소
		// ctrl D 한줄 삭제
		// ctrl+alt+down 행단위 복사
		// alt+shft+A 멀티컬럼 편집
		// alt+up, dwon 행단위 이동
		// ctrl+i 자동 들여쓰기
		// ctrl+space 자동완성 sysout 
		System.out.println();
		System.out.println("Helloabc world");
		System.out.println("Helloabc world");
		System.out.println("Helloabc world");
		int a = 1;
		float f = 3.14f;
		double d = 3.14f;
		System.out.println(d);
		char ch = 'a';
		String s = "ABC";
		
//		Scanner scanner = new Scanner(System.in);
//		int num = scanner.nextInt();
//		int num2 = scanner.nextInt();
//		String num3 = scanner.nextLine();
		
//		System.out.println(num+num2);
//		System.out.println(num3);
		
		String[] members = new String[3];
		String[] newMembers = {"Jason", "Hugh", "Lee"};

		for (String e : newMembers) {
			System.out.println(e+"이");
		}
		
	}

}
