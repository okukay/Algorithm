
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<int[]>[] graph;  // [목적지, 가중치] 쌍을 저장할 리스트
    static int[] distance;
    static int V, E, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String L = br.readLine();
        StringTokenizer st = new StringTokenizer(L);

        V = Integer.parseInt(st.nextToken()); // 정점의 개수 5
        E = Integer.parseInt(st.nextToken()); // 간선의 개수 (5+1)

        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String Line = br.readLine();
            st = new StringTokenizer(Line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[]{v, w});
        }


        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        // 다익스트라 실행
        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

    }

    public static void dijkstra(int start) {
        // PriorityQueue<int[]> : [거리, 정점번호] 로 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        distance[start] = 0;
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] node = pq.poll(); //(0,1)
            int dist = node[0]; // 0 
            int now = node[1];  // 1

            if (distance[now] < dist) {
                continue;
            }

            // 인접노드 계산
            for (int[] next : graph[now]) {
                int nextNode = next[0];    // 이동할 수 있는 정점
                int cost = dist + next[1]; // 그전거리 + 이동거리

                if (cost < distance[nextNode]) {
                    distance[nextNode] = cost;
                    pq.add(new int[]{cost, nextNode});
                }
            }
        }
    }
}