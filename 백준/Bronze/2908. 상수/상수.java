import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();

        StringTokenizer st = new StringTokenizer(Line);

        String i = st.nextToken();
        String j = st.nextToken();

        String answer = "";
        for(int k = 2; k>=0; k--){
            int I = i.charAt(k)-'0';
            int J = j.charAt(k)-'0';

            if(I>J){
                answer = i;
                break;
            }
            else if(I<J){
                answer = j;
                break;
            }
        }
        for(int a =2; a>=0; a--){
            System.out.print(answer.charAt(a));
        }
    }
}
