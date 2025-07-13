
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int V, N;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        V = Integer.parseInt(st.nextToken()); // 시작 노드

        map = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(map[i]);
        }
        
        
        visited = new boolean[N + 1];
        
        System.out.print(V + " ");
        dfs(V);
        System.out.println();    
        bfs(V);  
    }
    private static void bfs(int start) {

        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int i : map[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs(int start) {
    	visited[V] = true;
        for (int cur : map[start]) {
            if (!visited[cur]) {
                visited[cur] = true;
                System.out.print(cur + " ");
                dfs(cur);
            }
        }
    }
}