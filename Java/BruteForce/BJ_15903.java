import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_15903 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int SUM = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pque = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while (N-- > 0){
            pque.add(Long.parseLong(st.nextToken()));
        }
        while (SUM-- > 0){
            long a = pque.poll() + pque.poll();
            pque.add(a);
            pque.add(a);
        }
        long sum = 0;
        while (!pque.isEmpty()){
            sum += pque.poll();
        }
        System.out.println(sum);
    }
}
