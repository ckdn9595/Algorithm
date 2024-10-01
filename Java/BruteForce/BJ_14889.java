import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889 {
    public static int MIN_DIFF = Integer.MAX_VALUE;
    public static int N;
    public static int[][] w;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(1, new boolean[N+1], 0);
        System.out.println(MIN_DIFF);
    }

    private static void combination(int idx, boolean[] team, int cnt) {
        if(cnt == N/2){
            MIN_DIFF = Math.min(MIN_DIFF, calc(team));
            return;
        }
        if(idx > N) return;
        team[idx] = true;
        combination(idx+1, team, cnt+1);
        team[idx] = false;
        combination(idx+1, team, cnt);
    }

    private static int calc(boolean[] team) {
        int left=0, right=0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) continue;

                if(team[i] && team[j]){
                    left += w[i][j];
                }
                if(!team[i] && !team[j]){
                    right += w[i][j];
                }
            }
        }
        return Math.abs( left - right );
    }
}
