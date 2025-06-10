import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int mod = Math.abs(A - B);
        if(mod == 0 ){
            System.out.println(A);
            System.out.println(A);
            return;
        }
        if(A < B){
            int tmp = A;
            A = B;
            B = tmp;
        }
        int gcd = gcd(A, B);
        System.out.println(gcd);
        System.out.println(A * B / gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    private static int gcd2(int b, int s) {
        int gcd = 0;
        int tmp = 0;
        while (true){
            tmp = b % s;
            if(tmp == 0){
                gcd = s;
                break;
            }
            b = s;
            s = tmp;
        }
        return gcd;
    }
}
