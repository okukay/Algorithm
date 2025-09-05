
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new int[]{to, cost});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        //우선순위 큐(PQ): {현재 비용, 정점} // 넣으면 오름차순 정렬됌
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int node[] = pq.poll();
            int cost = node[0];
            int end = node[1];

            // 우선순위가 아닌 옛날꺼 스킵용도임
            if (cost != dist[end]) {
                continue;
            }
            // 오름차순되기 때문에 가장 먼저 찾는게 가장 최솟값일거임
            if (end == target) {
                break;
            }

            for (int[] edge : adj[end]) {
                int v = edge[0]; //목적지 정점
                int w = edge[1]; // cost

                // 가중치 dist배열과 vs cost(여기까지온 기존)+cost(v까지 가기위한)
                if (dist[v] > cost + w) {
                    dist[v] = cost + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
        System.out.println(dist[target]);
    }
}