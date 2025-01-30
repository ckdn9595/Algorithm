import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n ;i++){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            max = Math.max(max, num);
        }

        System.out.println((double)sum / max * 100 / n);
    }
}
