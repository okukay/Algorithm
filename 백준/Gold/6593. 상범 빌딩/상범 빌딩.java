
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static ArrayDeque<int[]> dq;
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int L, R, C;
    static List<int[]> end;
    static char[][][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String Line = br.readLine();
            StringTokenizer st = new StringTokenizer(Line);

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            end = new ArrayList<>();
            map = new char[L][R][C];
            dq = new ArrayDeque<>();
            visited = new int[L][R][C];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String build = br.readLine();
                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = build.charAt(c);
                        if (map[l][r][c] == 'S') {
                            dq.add(new int[]{l, r, c});
                            visited[l][r][c] = 0;
                        }
                        if (map[l][r][c] == 'E') {
                            end.add(new int[]{l, r, c});
                        }
                    }
                }
                br.readLine(); // 층 사이 빈 줄
            }
            bfs();
        }

    }

    public static void bfs() {
        int pos[] = end.get(0);
        while (!dq.isEmpty()) {
            int node[] = dq.poll();
            int z = node[0];
            int x = node[1];
            int y = node[2];

            if (z == pos[0] && x == pos[1] && y == pos[2]) {
                System.out.println("Escaped in " + visited[z][x][y] + " minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int ni = node[0] + dz[i];
                int nj = node[1] + dx[i];
                int nk = node[2] + dy[i];

                if (ni < 0 || ni >= L || nj < 0 || nj >= R || nk < 0 || nk >= C) {
                    continue;
                }
                if (visited[ni][nj][nk] != 0 || map[ni][nj][nk] == '#') {
                    continue;
                }

                visited[ni][nj][nk] = visited[z][x][y] + 1;
                dq.add(new int[]{ni, nj, nk});

            }
        }
        System.out.println("Trapped!");
    }
}