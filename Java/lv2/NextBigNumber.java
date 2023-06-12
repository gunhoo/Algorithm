package lv2;

public class NextBigNumber {

	public static void main(String[] args) {
		int n = 78;
		String binary = Integer.toBinaryString(n);
		int oneCnt = 0;
		int answer = 0;
		for(int i =0 ;i < binary.length() ; i++) {
			if(binary.charAt(i) == '1') oneCnt++;
		}
		for(int i = n+1 ; i<=1000000; i++) {
			String newBinary = Integer.toBinaryString(i);
			int newOneCnt = 0;
			for(int j =0 ;j < newBinary.length() ; j++) {
				if(newBinary.charAt(j) == '1') newOneCnt++;
			}
			if(newOneCnt == oneCnt) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

}
