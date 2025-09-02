
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();
        StringTokenizer st = new StringTokenizer(Line);

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] map = new int[K];

        int max = 0;

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            map[i] = num;
            if (num > max) {
                max = num;
            }
        }

        long start = 1;
        long end = max;
        long mid = (start + end) / 2;
        long answer = 0;

        while (start <= end) {
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += map[i] / mid;
            }

            if (count < N) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if (count >= N) {
                answer = mid;
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
        System.out.println(answer);
    }
}