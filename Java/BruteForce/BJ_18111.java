import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111 {
    static final int digging = 2;
    static final int stacking = 1;
    static int map[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        int max = 0;
        int min = 256;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                max = Math.max(max, h);
                min = Math.min(min, h);
            }
        }
        int answer = Integer.MAX_VALUE;
        int height = 0;
        for(int i = max; i >= min; i--){
            int time = getSpendTime(r, c, b, i);
            if(time < answer){
                answer = time;
                height = i;
            }
        }
        System.out.printf("%d %d", answer, height);
    }

    private static int getSpendTime(int r, int c, int block, int height) {
        int time = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if (map[i][j] > height){
                    time += (map[i][j] - height) * digging;
                    block += (map[i][j] - height);
                } else {
                    time += (height - map[i][j]) * stacking;
                    block -= (height - map[i][j]);
                }
            }
        }
        if (block < 0){
            return Integer.MAX_VALUE;
        }
        return time;
    }
}
