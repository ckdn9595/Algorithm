import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[1001];
        filterPrimeNum(prime);
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while(st.hasMoreTokens()){
            if(prime[Integer.parseInt(st.nextToken())]){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void filterPrimeNum(boolean[] prime) {
        Arrays.fill(prime, true);

        prime[1] = false;
        int y = 0;
        for(int x = 2; x < 501; x++){
            y = x + x;
            while (y < 1001){
                prime[y] = false;
                y += x;
            }
        }
    }
}
