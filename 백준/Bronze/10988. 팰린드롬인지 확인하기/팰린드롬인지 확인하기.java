import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();
        int len = Line.length();
        int answer = 1;

        for(int i = 0; i<len/2; i++){
            if(Line.charAt(i) != Line.charAt(len-i-1)){
              answer = 0;
            }

        }
        System.out.println(answer);
    }
}
