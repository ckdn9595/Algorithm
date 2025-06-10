import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_10816 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0;
        while(N-->0){
            num = Integer.parseInt(st.nextToken());
            map.put(num, map.get(num)==null ? 1 : map.get(num) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M-->0){
            num = Integer.parseInt(st.nextToken());
            sb.append(map.get(num) == null ? 0 : map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
