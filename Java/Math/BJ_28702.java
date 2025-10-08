import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_28702 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        for(int i = 0; i < 3 ; i++){
            try{
                int a = Integer.parseInt(br.readLine());
                num = a + 3 - i;
                break;
            }catch(Exception e){}
        }
        if(num % 3 == 0 && num % 5 == 0){
            System.out.println("FizzBuzz");
        }else if(num % 3 == 0 ){
            System.out.println("Fizz");
        }else if(num % 5 == 0){
            System.out.println("Buzz");
        }else {
            System.out.println(num);
        }
    }
}
