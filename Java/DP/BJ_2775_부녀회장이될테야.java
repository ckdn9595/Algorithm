import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2775_부녀회장이될테야 {
    static int [][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        dp = new int[15][15];
        for(int i = 1; i < 15; i++){
            dp[0][i] = i;
        }
        setting();
        while(T-->0){
            int r = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[r][n]).append("\n");
        }
        System.out.println(sb);
    }
    public static void setting(){
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    }
}
