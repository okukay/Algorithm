import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();
        int T = Integer.parseInt(br.readLine());
        
        int answer = 0;
        StringTokenizer st = new StringTokenizer(num);
        
        for(int i = 0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if (T == a){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
