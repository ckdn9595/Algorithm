import java.util.*;
import java.io.*;
public class BOJ_포닉스의문단속{
    static String str;
    static StringBuilder sb;
    static int M;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = br.readLine();
        sb = new StringBuilder(str);
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N-1; i++){
            if(M == 0){
                break;
            }
            if(canMakeA(i)){
                sb.setCharAt(i, 'A');
            }
        }
        sb.setCharAt(N-1, (char)(((int)(str.charAt(N-1) - 'A' + M)%26) + 'A'));
        System.out.println(sb.toString());
    }
    public static boolean canMakeA(int idx){
        char c = str.charAt(idx);
        if(c == 'A') return false;
        if('[' - c <= M){
            M -= ('[' - c);
            return true;
        }
        return false;
    }
}