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
            System.out.println(1);
            System.out.println(A);
        }
        boolean GDC = false;
        while(!GDC){
            GDC = A % mod == 0 && B % mod == 0;
            mod -= 1;
        }
        mod += 1;
        System.out.println(mod);
        System.out.println(A * B / mod);
    }
}
