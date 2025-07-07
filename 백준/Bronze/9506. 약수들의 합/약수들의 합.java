import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int line = Integer.parseInt(br.readLine());
            if (line == -1) break;

            int sum = 0;
            List<Integer> result = new ArrayList<>();

            for (int i = 1; i <= Math.sqrt(line); i++) {
                if (line % i == 0) {
                    if (i != line) {
                        result.add(i);
                        sum += i;
                    }

                    int pair = line / i;
                    if (pair != i && pair != line) {
                        result.add(pair);
                        sum += pair;
                    }
                }
            }

            if (sum == line) {
                Collections.sort(result);
                System.out.print(line + " = ");
                for (int j = 0; j < result.size(); j++) {
                    System.out.print(result.get(j));
                    if (j != result.size() - 1) {
                        System.out.print(" + ");
                    }
                }
                System.out.println();
            } else {
                System.out.println(line + " is NOT perfect.");
            }
        }
    }
}