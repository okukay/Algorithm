
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // System.out.println(A + " " + B);
            map[A].add(B);
            map[B].add(A);
        }

        bfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int si) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        visited[si] = true;
        dq.add(si);

        while (!dq.isEmpty()) {
            int now = dq.poll();

            for (int next : map[now]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                dq.add(next);
                parent[next] = now;
            }
        }
    }
}