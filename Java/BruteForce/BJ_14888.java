import java.util.*;
import java.io.*;
public class BJ_14888 {
    static int[] num;
    static int N;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }
    private static void dfs (int r, int number){
        if(r == N){
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }
        if(operator[0] > 0){
            operator[0]--;
            dfs(r+1, plus(number, num[r]));
            operator[0]++;
        }
        if(operator[1] > 0){
            operator[1]--;
            dfs(r+1, minus(number, num[r]));
            operator[1]++;
        }
        if(operator[2] > 0){
            operator[2]--;
            dfs(r+1, times(number, num[r]));
            operator[2]++;
        }
        if(operator[3] > 0){
            operator[3]--;
            dfs(r+1, divide(number, num[r]));
            operator[3]++;
        }
    }
    public static int plus(int a, int b){ return a+b;}
    public static int minus(int a, int b){ return a-b;}
    public static int times(int a, int b){ return a*b;}
    public static int divide(int a, int b){ return a/b;}
}

