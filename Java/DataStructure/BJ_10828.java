import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10828 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack stack = new Stack();
        while(N-- >0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
                default: throw new Exception("Invalid command: " + command);
            }
        }
        System.out.print(sb);

    }

}
class Stack{
    int[] array = new int[10000];
    int size = 0;

    public void push(int v){
        array[size] = v;
        size++;
    }

    public int pop() {
        if(size == 0) return -1;
        size--;
        return array[size];
    }

    public int size(){
        return size;
    }

    public int empty(){
        if(size > 0) return 0;
        return 1;
    }

    public int top(){
        if(size == 0) return -1;
        return array[size - 1];
    }

}


