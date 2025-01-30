import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4153 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a, b, c;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a + b + c == 0) break;
            if (a >= b){
                solution(sb, a, b, c);
            }else{
                solution(sb, b, a, c);
            }
        }     s
        System.out.println(sb);
    }

    private static void solution(StringBuilder sb, int big, int small, int c) {
        if(big >= c){
            if(big * big == small * small + c * c){
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        } else {
            if(c * c == big * big + small * small){
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
    }
}
