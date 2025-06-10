import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10814 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Person> pQue = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            pQue.offer(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
        while(!pQue.isEmpty()){
            Person p = pQue.poll();
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);
    }
    static class Person implements Comparable<Person>{
        int age;
        String name;
        int registerNum;

        public Person(int age, String name, int registerNum) {
            this.age = age;
            this.name = name;
            this.registerNum = registerNum;
        }

        @Override
        public int compareTo(Person o) {
            if(this.age == o.age){
                return this.registerNum - o.registerNum;
            }
            return this.age - o.age;
        }
    }

}
