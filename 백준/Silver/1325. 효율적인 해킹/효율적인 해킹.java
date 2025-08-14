
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] map;
    static int N, M;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[B].add(A); // 역방향 저장
        }

        int[] hackCount = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1]; // 매 BFS마다 새로
            int cnt = bfs(i, visited);
            hackCount[i] = cnt;
            max = Math.max(max, cnt);
        }

        for (int i = 1; i <= N; i++) {
            if (hackCount[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static int bfs(int start, boolean[] visited) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start] = true;
        int cnt = 1; // 자기 자신 포함

        while (!dq.isEmpty()) {
            int node = dq.poll();
            for (int next : map[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dq.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }

}