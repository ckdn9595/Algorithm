import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2798 {
    static int[] num;
    static int N, M;
    static int max;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[N];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        combi(0,0,new int[3]);
        System.out.println(max);
    }

    private static void combi(int n, int r, int[] arr) {
        if(n == 3){
            int sum = Arrays.stream(arr).sum();
            if(sum <= M){
                max = Math.max(max, sum);
            }
            return;
        }
        if(r == N) return;
        arr[n] = num[r];
        combi(n+1, r+1, arr);
        combi(n, r+1, arr);
    }
}
