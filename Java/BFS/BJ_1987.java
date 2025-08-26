import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1987 {
    static char[][] field;
    static int R, C;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str= br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        field = new char[R][C];
        for(int i = 0 ; i < R; i++){
            field[i] = br.readLine().toCharArray();
        }
        cnt = 0;
        sol(0,0,"");
        System.out.println(cnt);
    }
    static int[] dirY = new int[]{-1,1,0,0};
    static int[] dirX = new int[]{0,0,-1,1};
    public static void sol(int y, int x, String cho){
        if(
            (    y == -1
                ||y == R
                ||x == -1
                ||x == C
            )
            ||
            cho.contains(field[y][x]+"")
        ){
            cnt = Math.max(cnt, cho.length());
            return;
        }
        cho += field[y][x];

        for(int i = 0 ; i < 4; i++){
            sol(y+dirY[i], x+dirX[i], cho);
        }
    }
}
