
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();

        StringTokenizer st = new StringTokenizer(Line);

        N = Integer.parseInt(st.nextToken()); // 개수
        M = Integer.parseInt(st.nextToken()); // 반복횟수

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String L = br.readLine();
            st = new StringTokenizer(L);

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);

        }
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(int start) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.add(start);
        visited[start] = true;

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            for (int i : list[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    dq.add(i);
                }
            }
        }
    }
}