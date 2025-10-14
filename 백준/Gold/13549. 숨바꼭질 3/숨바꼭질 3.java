
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int MAX = 100_000;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);  // -1 대신 큰값
        dist[N] = 0;

        bfs();

        System.out.println(dist[K]);
    }

    public static void bfs() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(N);

        while (!dq.isEmpty()) {
            int X = dq.poll();

            // 순간이동 (0초)
            int tele = X * 2;
            if (tele <= MAX && dist[X] < dist[tele]) {
                dist[tele] = dist[X];
                dq.addFirst(tele);
            }

            // 걷기 (+1초)
            int[] moves = {X - 1, X + 1};
            for (int mv : moves) {
                if (mv >= 0 && mv <= MAX && dist[X] + 1 < dist[mv]) {
                    dist[mv] = dist[X] + 1;
                    dq.addLast(mv);
                }
            }
        }
    }
}