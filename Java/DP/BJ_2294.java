import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2294 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] log = new int [k+1];
        Arrays.fill(log, 10001);
        log[0] = 0;

        Set<Integer> nums = new HashSet<>();
        while(n-->0){
            nums.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> list = new ArrayList<>(nums);

        for (int i : list) {
            if(i > k) continue;
            for(int j = 0; j <= k - i; j++){
                if(log[j] == -1 ) continue;
                log[j+i] = Math.min(log[j] + 1, log[j+i]);
            }
        }
        if(log[k] == 10001){
            System.out.println(-1);
            return;
        }
        System.out.println(log[k]);
    }
}
