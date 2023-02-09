package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/**
 * SWEA D2 파리퇴치
 * 
 * @author 박건후
 *
 */
public class SW_2001_파리퇴치_박건후 {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int ans = Integer.MIN_VALUE;
            int[][] map = new int[n+1][n+1];
            int[][] sum = new int[n+1][n+1];
            for(int i = 1; i<= n ; i++) { // 입력 for문
                st = new StringTokenizer(br.readLine());
                for(int j = 1 ; j<= n ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 1 ; i <= n ; i++) { // DP를 위한 sum 배열 생성
                for(int j = 1 ; j <= n ; j++) {
                    sum[i][j] = map[i][j] +sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1]; // (행-1sum) + (열-1sum) - (행-1열-1sum) 해주면 sum값 나타낸다
                }
            }
             
            for(int i = m; i<=n;i++) {
                for(int j = m; j<=n; j++) {
                    ans = Math.max(ans, (sum[i][j] - sum[i-m][j] - sum[i][j-m] + sum[i-m][j-m]));// max값 갱신
                }
                 
            }
            System.out.println("#"+test_case+" "+ans);
             
        }
    }
 
}