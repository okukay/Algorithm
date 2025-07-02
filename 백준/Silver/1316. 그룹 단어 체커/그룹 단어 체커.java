import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean[] used = new boolean[26]; 
            boolean isGroup = true;

            char prev = ' '; 

            for (int j = 0; j < word.length(); j++) {
                char curr = word.charAt(j);

                // 이전 문자와 다르고, 이미 사용한 문자라면 break
                if (curr != prev && used[curr - 'a']) {
                    isGroup = false;
                    break;
                }

                used[curr - 'a'] = true; 
                prev = curr; 
            }

            if (isGroup) result++;
        }

        System.out.println(result);
    }
    
}
