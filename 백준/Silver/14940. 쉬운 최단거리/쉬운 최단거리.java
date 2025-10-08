
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] map;
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();
        StringTokenizer st = new StringTokenizer(Line);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String L = br.readLine();
            st = new StringTokenizer(L);
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;

                if (a == 2) {
                    x = i;
                    y = j;

                }
            }
        }

        map[x][y] = 0;
        bfs(x, y);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void bfs(int si, int sj) {
        // System.out.println("실행");
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visited[si][sj] = true;
        dq.add(new int[]{si, sj});

        while (!dq.isEmpty()) {

            int node[] = dq.poll();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int ni = x + dx[i];
                int nj = y + dy[i];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                    continue;
                }
                if (map[ni][nj] != 1) {
                    continue;
                }
                if (visited[ni][nj] == true) {
                    continue;
                }

                dq.add(new int[]{ni, nj});
                visited[ni][nj] = true;
                map[ni][nj] = map[x][y] + 1;
            }
        }
    }
}