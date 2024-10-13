import javax.lang.model.type.IntersectionType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int [N+1];
        int [] t = new int [N];
        int [] p = new int [N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for (int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
            int end_t = i + t[i];
            if(end_t <= N)
                dp[end_t] = Math.max(dp[end_t], max + p[i]);
        }

        System.out.println(Math.max(dp[N], max));
    }
}
