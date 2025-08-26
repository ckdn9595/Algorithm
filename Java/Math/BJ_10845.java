import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10845 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Q q = new Q(N);
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" -> q.push(Integer.parseInt(st.nextToken()));
                case "pop" -> sb.append(q.pop()).append("\n");
                case "size" -> sb.append(q.size()).append("\n");
                case "empty" -> sb.append(q.isEmpty()).append("\n");
                case "front" -> sb.append(q.front()).append("\n");
                case "back" -> sb.append(q.back()).append("\n");
            }
        }
        System.out.println(sb);
    }
    static class Q{
        int[] arr;
        int offset;
        int i;

        public Q(int size) {
            arr = new int[size];
            offset = 0;
            i = 0;
        }
        protected void push(int x){
            arr[i++] = x;
        }
        protected int pop(){
            if(isEmpty() == 1)
                return -1;
            return arr[offset++];
        }
        protected int size(){
            return i - offset;
        }
        protected int isEmpty(){
            if(size() == 0)
                return 1;
            return 0;
        }
        protected int front(){
            if(isEmpty() == 1)
                return -1;
            return arr[offset];
        }
        protected int back(){
            if(isEmpty() == 1)
                return -1;
            return arr[i-1];
        }
    }
}
