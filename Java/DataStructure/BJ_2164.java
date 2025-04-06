import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

public class BJ_2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new java.util.LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
        int answer = 0;
        while(!queue.isEmpty()){
            answer = queue.poll();
            if(queue.isEmpty()) break;
            queue.add(queue.poll());
        }
        System.out.println(answer);
    }
}
