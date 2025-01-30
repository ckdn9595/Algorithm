import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_30802 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int num = 0;
        int x = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 6; i++){
            num += nums[i] / x;
            if(nums[i] % x == 0){
                continue;
            }
            num += 1;
        }
        System.out.println(num);
        int y = Integer.parseInt(st.nextToken());
        System.out.printf("%s %s", n/y, n%y);
    }
}
