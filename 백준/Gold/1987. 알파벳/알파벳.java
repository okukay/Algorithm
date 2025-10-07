
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int max = 0;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int R, C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();
        StringTokenizer st = new StringTokenizer(Line);

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[26];
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String L = br.readLine();
            for (int j = 0; j < L.length(); j++) {

                char ch = L.charAt(j);
                map[i][j] = ch;
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int si, int sj, int cnt) {
        max = Math.max(max, cnt);
        visited[map[si][sj] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int ni = si + dx[i];
            int nj = sj + dy[i];

            if (ni < 0 || ni >= R || nj < 0 || nj >= C) {
                continue;
            }
            if (visited[map[ni][nj] - 'A'] == true) {
                continue;
            }

            dfs(ni, nj, cnt + 1);
        }
        visited[map[si][sj] - 'A'] = false;
    }
}