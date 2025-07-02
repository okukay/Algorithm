import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //킹1 퀸1 룩2 비슙2 나이트2 폰8
        //(1,1,2,2,2,8)
        int[] standard = {1, 1, 2, 2, 2, 8};
        int[] result = new int[6];

        String Line = br.readLine();
        StringTokenizer st = new StringTokenizer(Line);
        for(int i = 0; i<6; i++){
            int a = Integer.parseInt(st.nextToken());
            
            result[i] = standard[i] - a;      
        }
        for(int j = 0; j<result.length; j++){

            System.out.print(result[j]+ " ");
        }


    }
}
