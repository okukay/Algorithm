
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<int[]> union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;
        while (true) {
            boolean move = false;
            visited = new boolean[N][N]; //방문초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        union = new ArrayList<>();
                        bfs(i, j);
                        if (union.size() > 1) {
                            movePeople();
                            move = true;
                        }
                    }
                }
            }
            if (!move) {
                break;
            }
            days++;
        }
        System.out.println(days);

    }

    public static void movePeople() {
        int sum = 0;
        for (int[] u : union) {
            int x = u[0];
            int y = u[1];
            sum += map[x][y];
        }
        int result = sum / union.size();
        for (int[] u : union) {
            int x = u[0];
            int y = u[1];
            map[x][y] = result;
        }
    }

    public static void bfs(int si, int sj) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visited[si][sj] = true;
        dq.add(new int[]{si, sj});
        union.add(new int[]{si, sj});

        while (!dq.isEmpty()) {
            int node[] = dq.poll();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int ni = x + dx[i];
                int nj = y + dy[i];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                    continue;
                }
                if (visited[ni][nj] == true) {
                    continue;
                }
                int diff = Math.abs(map[x][y] - map[ni][nj]);
                if (diff >= L && diff <= R) {
                    dq.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    union.add(new int[]{ni, nj});
                }

            }
        }
    }
}