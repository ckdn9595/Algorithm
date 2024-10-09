import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9655_돌게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (isOdd(Integer.parseInt(br.readLine()))){
            case 1:
                System.out.println("SK");
                break;
            default:
                System.out.println("CY");
        }
    }

    private static int isOdd(int num) {
        return num % 2;
    }

}
