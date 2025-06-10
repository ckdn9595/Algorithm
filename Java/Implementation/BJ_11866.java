import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int interval = Integer.parseInt(st.nextToken());

        List<Integer> list = new java.util.ArrayList<>();
        for(int i = 1; i<= N; i++) list.add(i);
        sb.append("<");
        int idx = 0;
        int cnt = 0;
        while(list.size() > 1){
            cnt++;

            if(idx >= list.size()) idx = 0;

            if(cnt == interval){
                cnt = 0;
                int x = list.remove(idx);
                sb.append(x).append(", ");
            }else {
                idx++;
            }
        }
        sb.append(list.get(0)).append(">");

        System.out.println(sb);
    }

}
