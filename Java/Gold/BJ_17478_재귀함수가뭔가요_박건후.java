package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_17478_재귀함수가뭔가요_박건후 {
	static BufferedWriter bw;
	private static String underBar = "____";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		printString(n+1, 0); // 재귀함수를 위한 메서드
		bw.flush(); // bufferedWriter flush
	}
	
	private static void printString(int n, int count) throws Exception {
		StringBuilder totalUnderBar = new StringBuilder("");
		for(int i = 0 ; i< count ; i++) {
			totalUnderBar.append(underBar);
		}
		if(n == 1) { // 재귀함수 탈출 조건
			bw.write(totalUnderBar+"\"재귀함수가 뭔가요?\"\n");
			bw.write(totalUnderBar+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			bw.write(totalUnderBar+"라고 답변하였지.\n");
			return;
		}
		bw.write(totalUnderBar+"\"재귀함수가 뭔가요?\"\n");
		bw.write(totalUnderBar+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		bw.write(totalUnderBar+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		bw.write(totalUnderBar+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		printString(n-1, ++count); // 재귀함수 호출
		bw.write(totalUnderBar+"라고 답변하였지.\n");
		
	}
}
