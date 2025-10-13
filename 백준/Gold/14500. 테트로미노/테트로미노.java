
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;

                checkExceptionShape(i, j);

            }
        }
        System.out.println(max);
    }

    public static void checkExceptionShape(int si, int sj) {
        int center = map[si][sj];
        List<Integer> neighbors = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int ni = si + dx[i];
            int nj = sj + dy[i];

            if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                continue;
            }
            neighbors.add(map[ni][nj]);
        }
        if (neighbors.size() < 3) {
            return;
        }

        // 4개 중에서 최대가 되는 3개를 골라야함 (센터 + 나머지 3개)
        if (neighbors.size() == 4) {
            int total = center + neighbors.get(0) + neighbors.get(1) + neighbors.get(2);
            total = Math.max(total, center + neighbors.get(0) + neighbors.get(1) + neighbors.get(3));
            total = Math.max(total, center + neighbors.get(0) + neighbors.get(2) + neighbors.get(3));
            total = Math.max(total, center + neighbors.get(1) + neighbors.get(2) + neighbors.get(3));
            max = Math.max(max, total);
        } else { // 3개만 있을때
            int total = center + neighbors.get(0) + neighbors.get(1) + neighbors.get(2);
            max = Math.max(max, total);
        }
    }

    public static void dfs(int si, int sj, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ni = si + dx[i];
            int nj = sj + dy[i];

            if (ni < 0 || ni >= N || nj < 0 || nj >= M || visited[ni][nj]) {
                continue;
            }

            visited[ni][nj] = true;
            dfs(ni, nj, depth + 1, sum + map[ni][nj]);
            visited[ni][nj] = false;
        }
    }
}