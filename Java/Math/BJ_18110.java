import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_18110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[31];
        for (int i = 0; i < N; i++){
            nums[Integer.parseInt(br.readLine())]++;
        }
        int per = (int) Math.round(N * 0.15);
        while(per --> 0){
            for(int i = 1; i < 31; i++){
                if (nums[i] > 0){
                    nums[i]--;
                    break;
                }
            }
            for(int i = 30; i > 0; i--){
                if (nums[i] > 0){
                    nums[i]--;
                    break;
                }
            }
        }
        int count = 0;
        int sum = 0;
        for(int i = 1; i < 31; i++){
            count += nums[i];
            sum += i * nums[i];
        }
        System.out.println(count == 0 ? 0 : Math.round((double) sum/ count));
    }
}
