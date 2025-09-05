
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
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점
        int E = Integer.parseInt(st.nextToken());  //간선

        int K = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new int[]{to, cost});
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        // {목적지,가중치}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int end = node[0];
            int cost = node[1];

            if (cost != dist[end]) {
                continue;
            }

            for (int[] edge : adj[end]) {
                int v = edge[0]; // 목적지
                int w = edge[1]; // 가중치

                if (dist[v] > cost + w) {
                    dist[v] = cost + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}