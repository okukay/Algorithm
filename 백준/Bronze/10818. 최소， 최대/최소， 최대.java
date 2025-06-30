import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String L = br.readLine();
        StringTokenizer st = new StringTokenizer(L);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i< N; i++){
            int a = Integer.parseInt(st.nextToken());
           
            if(a > max){
                max = a;
            }
            if(a < min){
                min = a;
            }
        }
        System.out.println(min+ " " + max);
    }
}
