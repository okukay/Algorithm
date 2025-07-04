import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //거스름돈 항상 $5 이하
        // $0.25 $0.1 $0.05 $0.01 
        int N = Integer.parseInt(br.readLine());
        int[] change = {25, 10, 5, 1};
        int[] result = new int[4];

        for(int i = 0; i<N; i++){
            int money = Integer.parseInt(br.readLine());

            for(int j = 0; j<4; j++){
                result[j] = (money / change[j]); //몫
                money = money % change[j];
            }
            for(int r = 0; r<result.length; r++){
                System.out.print(result[r]+ " ");
            }
        }
    }
}