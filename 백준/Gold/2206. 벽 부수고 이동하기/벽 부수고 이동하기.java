
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M;
    static int[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String L = br.readLine();
        StringTokenizer st = new StringTokenizer(L);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String Line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Line.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        int a = visited[N - 1][M - 1][0];
        int b = visited[N - 1][M - 1][1];

        if (a == 0 && b == 0) {
            System.out.println("-1");
        } else if (a == 0) {
            System.out.println(b);
        } else if (b == 0) {
            System.out.println(a);
        } else {
            System.out.println(Math.min(a, b));
        }
    }

    public static void bfs(int si, int sj) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        dq.add(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!dq.isEmpty()) {
            int[] node = dq.poll();

            int x = node[0], y = node[1], broken = node[2];

            // 최종목적지에 도달하지 못하면 -> 0
            for (int i = 0; i < 4; i++) {
                int ni = x + dx[i];
                int nj = y + dy[i];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                    continue;
                }

                if (map[ni][nj] == 0 && visited[ni][nj][broken] == 0) {
                    visited[ni][nj][broken] = visited[x][y][broken] + 1;
                    dq.add(new int[]{ni, nj, broken});

                }
                if (map[ni][nj] == 1 && broken == 0 && visited[ni][nj][1] == 0) {
                    visited[ni][nj][1] = visited[x][y][0] + 1;
                    dq.add(new int[]{ni, nj, 1});
                }
            }

        }

    }
}