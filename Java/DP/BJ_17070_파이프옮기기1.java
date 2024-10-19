import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
    static int N;
    static int[][] map;
    static int[][][] dp;
    enum MoveType{
        NONE(0),
        RIGHT(1),
        DOWN(2),
        DIAGONAL(3);

        private final int value;
        MoveType(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
        public static MoveType fromValue(int value){
            for(MoveType type: values()){
                if (type.value == value){
                    return type;
                }
            }
            return MoveType.NONE;
        }
        public boolean equals (MoveType type){
            return value == type.value;
        }
    }
    private static boolean canMove (int r, int c, MoveType prev, MoveType next){
        // next 즉 현재 옮기는 방식을 허융하는 prev 이전 이동 방식인지, -> 결국 이렇게 이동할 수 있는 경우들의 묶음인지. + 장애물도 확인.
        return !switch (next) {
            case NONE -> true;
            case RIGHT -> checkOutOfIndexException(r, c-1) || prev.equals(MoveType.DOWN) || map[r][c] == 1;
            case DOWN -> checkOutOfIndexException(r-1, c) || prev.equals(MoveType.RIGHT) || map[r][c] == 1;
            case DIAGONAL -> checkOutOfIndexException(r-1, c-1) || map[r][c] == 1 || map[r - 1][c] == 1 || map[r][c - 1] == 1;
        };
    }

    private static boolean checkOutOfIndexException(int r, int c){
        return r < 0 || c < 0 || r >= N || c >= N;
    }
    private static int getPrevValue(int r, int c, MoveType prev, MoveType next) {
        return switch (next){
            case NONE -> 0;
            case RIGHT -> dp[r][c-1][prev.value];
            case DOWN -> dp[r-1][c][prev.value];
            case DIAGONAL -> dp[r-1][c-1][prev.value];
        };
    }
    private static int getSum(int r, int c){
        return dp[r][c][1] + dp[r][c][2] + dp[r][c][3];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N][4];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][MoveType.RIGHT.value] = 1;
        for(int i = 0; i < N; i++){
            for(int j = 1; j < N; j++){
                for(int next = 1; next <= 3; next++){
                    for(int prev = 1; prev <= 3; prev++){
                        if(canMove(i, j, MoveType.fromValue(prev), MoveType.fromValue(next)))
                            dp[i][j][next] += getPrevValue(i, j, MoveType.fromValue(prev), MoveType.fromValue(next));
                    }
                }
            }
        }
        System.out.println(getSum(N-1, N-1));
    }


}
