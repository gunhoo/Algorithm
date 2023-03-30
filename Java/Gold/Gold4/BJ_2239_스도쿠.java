package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2239_스도쿠 {
	private static int[][] board;
	private static final int SIZE = 9;
	private static final int EMPTY = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		
		for(int i=0; i < 9 ; i++) {
			String string = br.readLine();
			for(int j=0; j<9; j++) {
				board[i][j] = string.charAt(j)-'0'; // input
			}
		}
		solve(); // 풀고
        printBoard(); // 출력
	}

    public static boolean solve() {
        int row = 0;
        int col = 0;
        boolean isEmpty = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) { // 만약 빈칸 존재하면
                    row = i; // 좌푯값 떠
                    col = j;
                    isEmpty = false; // flag 표시
                    break; // 탈출
                }
            }
            if (!isEmpty) break; // 탈출
        }

        if (isEmpty) return true; // 빈 칸 없으면 스도쿠 완성

        for (int num = 1; num <= SIZE; num++) {  // 가능한 숫자 삽입
            if (isValid(row, col, num)) { // 가능여부 체크, 가능다하면
                board[row][col] = num; // 채워보고 
                if (solve()) return true; // 재귀 돌면서 가능하면 true 반환
                board[row][col] = EMPTY; // 아니면 원복
            }
        }
        return false; // 모두 끝날동안 안되면 false
    }

    private static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) { // 크기만큼
            if (board[row][i] == num) return false; // 같은 행에 중복된 숫자가 있으면 false
        }
        
        for (int i = 0; i < SIZE; i++) { // 크기만큼
            if (board[i][col] == num) return false; // 같은 열에 중복된 숫자가 있으면 false
        }

        // 3x3 영역 검사
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false; // 숫자 같으면 false
            }
        }
        return true; // 모두 통과면 true
    }

    public static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
