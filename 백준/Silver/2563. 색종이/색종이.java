import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[100][100];
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int k = 0; k<N; k++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int n = Integer.parseInt(st.nextToken()); //3
            int m = Integer.parseInt(st.nextToken()); //7

            for(int i =0; i<10; i++){
                for(int j = 0; j<10; j++){
                    map[m+i][n+j] = 1;
                }
            }
        }
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(map[i][j] == 1){
                    result += 1;
                }
            }
        }
        System.out.println(result);
  
    }
}