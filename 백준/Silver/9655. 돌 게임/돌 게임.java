
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] game = new boolean[1001];

        // 상근승 = true;
        // 창영승 = false
        game[1] = true;
        if (N >= 2) {
            game[2] = false;
        }
        if (N >= 3) {
            game[3] = true;
        }

        for (int i = 4; i <= N; i++) {
            if (!game[i - 1] || !game[i - 3]) {
                game[i] = true;
            } else {
                game[i] = false;
            }
        }
        System.out.println(game[N] ? "SK" : "CY");

    }
}