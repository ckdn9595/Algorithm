import java.util.*;
import java.io.*;

public class BOJ_11000_강의실배정 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pque = new PriorityQueue<>((n1, n2) -> {
            if ((n1[1] == n2[1]))
                return Integer.compare(n1[0], n2[0]);
            return Integer.compare(n1[1], n2[1]);
        });
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            pque.offer(new int[] { 1, Integer.parseInt(st.nextToken()) });
            pque.offer(new int[] { -1, Integer.parseInt(st.nextToken()) });
        }
        int max = 0;
        int cnt = 0;
        while (!pque.isEmpty()) {
            int[] now = pque.poll();
            if (now[0] == 1) {
                cnt++;
                max = Math.max(max, cnt);
                continue;
            }
            cnt--;
        }
        System.out.println(max);
    }
}