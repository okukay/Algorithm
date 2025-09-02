
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]> blanks;
    static int[][] map;
    static int N, M;
    static ArrayDeque<int[]> dq;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();
        StringTokenizer st = new StringTokenizer(Line);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dq = new ArrayDeque<>();

        map = new int[N][M];
        blanks = new ArrayList<>();
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    dq.add(new int[]{i, j});
                }
            }
        }

        makeWall(0, 0);
        System.out.println(result);
    }

    static void makeWall(int count, int start) {
        if (count == 3) {

            bfs();
            return;
        }
        for (int i = start; i < blanks.size(); i++) {
            int pos[] = blanks.get(i);
            int x = pos[0];
            int y = pos[1];

            if (map[x][y] == 0) {
                map[x][y] = 1;
                makeWall(count + 1, i + 1);
                map[x][y] = 0;
            }
        }
    }

    static void bfs() {

        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j]; // 직접 복사
            }
        }

        int count = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>(dq);

        while (!queue.isEmpty()) {
            int node[] = queue.poll();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int ni = x + dx[i];
                int nj = y + dy[i];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                    continue;
                }
                if (tempMap[ni][nj] == 0) {
                    queue.add(new int[]{ni, nj});
                    tempMap[ni][nj] = 2;
                }

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.max(result, count);
    }
}