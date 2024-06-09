import java.util.*;
import java.io.*;

public class BJ_1009_분산처리 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> arr = makeNumberList(a % 10);
            int idx = (b - 1) % arr.size();
            sb.append(arr.get(idx)).append("\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> makeNumberList(int a) {
        List<Integer> arr = new ArrayList<>();
        int first_num = a;
        do {
            if (a == 0) {
                arr.add(10);
            } else {
                arr.add(a);
            }

            a *= first_num;
            a %= 10;
        } while (first_num != a);
        return arr;
    }
}