import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13549 {
    static final int max = 10_0000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pque = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );
        int[] dijkstra = new int[max*2];
        Arrays.fill(dijkstra, max);
        if(N == K){
            System.out.println(0);
            return;
        }
        pque.add(new int []{N,0});
        dijkstra[N] = 0;
        while(!pque.isEmpty()){
            int[] now = pque.poll();
            int nowLoc = now[0];
            int cnt = now[1];

            if(nowLoc * 2 <= K + nowLoc/2  && cnt < dijkstra[nowLoc*2]){ // *2 구간
                dijkstra[nowLoc*2] = cnt;
                pque.offer(new int[]{nowLoc*2, cnt});
            }
            if(nowLoc > 0 && cnt+1 < dijkstra[nowLoc-1]){ // -1 구간
                dijkstra[nowLoc-1] = cnt + 1;
                pque.offer(new int[]{nowLoc-1, cnt+1});
            }
            if(nowLoc < K && cnt+1 < dijkstra[nowLoc+1]){ // +1 구간
                dijkstra[nowLoc+1] = cnt + 1;
                pque.offer(new int[]{nowLoc+1, cnt+1});
            }
        }
        System.out.println(dijkstra[K]);
    }
}
