import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] lines = new int[k];
        for(int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        long min = 0; long max = Integer.MAX_VALUE;
        long answer = 0;
        while(min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for(int i =0; i < k; i++) {
                count += lines[i] / mid;
            }

            if(count >= N){
                min = mid + 1;
                answer = mid;
            }else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
