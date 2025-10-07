
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Line = br.readLine();

        StringTokenizer st = new StringTokenizer(Line);

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = bfs(a, b);
        System.out.println(result);
    }

    public static int bfs(long start, long target) {

        ArrayDeque<long[]> dq = new ArrayDeque<>();
        dq.add(new long[]{start, 1});

        while (!dq.isEmpty()) {
            long[] node = dq.poll();
            long num = node[0];
            long cnt = node[1];

            if (num == target) {
                return (int) cnt;
            }

            long nextStart = num * 2;
            long nextStart2 = num * 10 + 1;

            if (nextStart <= target) {
                dq.add(new long[]{nextStart, cnt + 1});
            }
            if (nextStart2 <= target) {
                dq.add(new long[]{nextStart2, cnt + 1});
            }
        }
        return -1;
    }
}