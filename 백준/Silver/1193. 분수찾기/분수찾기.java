import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.parseInt(br.readLine()); //입력숫자 9
        int n = N;
        int T = 1;  // 몇번째 대각선인지
        int sum = 0;
        int bunja;
        int bunmo;

        while(true){
            if(n-T <= 0){
                break;
            }
            n = n-T;
            sum += T;
            T++;
        }

        if(T % 2 == 0){
            bunmo = T;
            bunja = 1;
            for(int i = 1; i<N-sum; i++){
                bunmo -= 1;
                bunja += 1;
            }
            System.out.println(bunja + "/" + bunmo);
        }
        if(T % 2 == 1){
            bunja = T; 
            bunmo = 1;
           
            for(int i = 1; i<N-sum; i++){
                bunja -= 1;
                bunmo += 1;
            }
            System.out.println(bunja + "/" + bunmo);
        }
    }
}