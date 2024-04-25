package Java.BruteForce;
import java.util.*;
import java.io.*;

public class AlgoSpot_Boggle {
    static class Words {
        String name;
        boolean canMake;

        public Words(String name, boolean canMake) {
            this.name = name;
            this.canMake = canMake;
        }

        public String write() {
            return String.format("%s %s", this.name, this.canMake ? "YES" : "NO");
        }
    }

    static char[][] map;
    static int[] dx = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dy = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                String str = br.readLine();
                map[i] = str.toCharArray();
            }
            int K = Integer.parseInt(br.readLine());
            Words[] wds = new Words[K];
            for (int i = 0; i < K; i++) {
                wds[i] = new Words(br.readLine(), false);
            }
            for (Words w : wds) {
                char c = w.name.charAt(0);
                loop: for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (map[i][j] == c) {
                            w.canMake = dfs(w.name, i, j);
                            if (w.canMake)
                                break loop;
                        }
                    }
                }
                sb.append(w.write()).append("\n");
            }
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public static boolean dfs(String str, int r, int c) {
        if (str.length() == 0)
            return true;
        char cc = str.charAt(0);
        int ny, nx;
        for (int d = 0; d < 8; d++) {
            ny = r + dy[d];
            nx = c + dx[d];
            if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && map[ny][nx] == cc) {
                if (dfs(str.substring(1), ny, nx)) {
                    return true;
                }
            }
        }

        return false;
    }
}