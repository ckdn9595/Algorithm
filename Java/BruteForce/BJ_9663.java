import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_9663 {
    static int[] cor;
    static int max;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;
        cor = new int[N];
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int r) {
        if (r == N){
            max++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if (positive(r, i)){
                cor[r] = i;
                dfs(r+1);
            }
        }
    }

    private static boolean positive(int r, int c) {
        boolean flag = true;
        for(int i = 0; i < r; i++){
            if(cor[i] == c || Math.abs(cor[i] - c) == Math.abs(i - r)){
                flag = false;
                break;
            }
        }
        return flag;
    }


}
