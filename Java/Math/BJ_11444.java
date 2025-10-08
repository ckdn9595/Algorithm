import java.io.IOException;

public class BJ_11444 {
    static final int MOD = 1_000_000_007;
    static final long [][]origin = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine());

        if (N == 0 ) {
            System.out.println(0);
            return;
        }
        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }
        long[][] result = pow(origin, N - 2);
        System.out.println((result[0][0] + result[1][0])% MOD);
    }

    static long[][] pow(long[][] matrix, long n){
        if(n == 1) return origin;

        long[][] temp = pow(matrix, n / 2);
        if(n % 2 == 0) return multiply(temp, temp);
        else return multiply(multiply(temp, temp), origin);
    }

    static long[][] multiply(long[][] a, long[][] b){
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return result;
    }


}
