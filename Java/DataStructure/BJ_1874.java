import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N+1];
        int top = -1;
        int M = Integer.parseInt(br.readLine());
        stack[++top] = 1;
        sb.append("+\n");
        int input =2; int count = N;
        while (true) {
            if (top < 0 ||stack[top] < M) {
                stack[++top] = input++;
                sb.append("+\n");
            }
            else if (stack[top] == M) {
                top--;
                count--;
                sb.append("-\n");
                if(count == 0) break;
                M = Integer.parseInt(br.readLine());
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
