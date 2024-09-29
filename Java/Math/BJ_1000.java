import java.io.*;
import java.util.StringTokenizer;

public class BJ_1000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while(st.hasMoreTokens()){
            answer+= Integer.parseInt(st.nextToken());
        }
        System.out.println(answer);
    }
}
