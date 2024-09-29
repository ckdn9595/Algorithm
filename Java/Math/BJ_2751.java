import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_2751 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        while(N-->0){
            pque.add(Integer.parseInt(br.readLine()));
        }
        while(!pque.isEmpty()){
            sb.append(pque.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
