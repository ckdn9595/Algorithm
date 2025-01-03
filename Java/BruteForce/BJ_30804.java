import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_30804 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int max = 0;
        for (int r = 0; r < N; r++){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            while(map.size() > 2){
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        System.out.println(max);
    }
}
