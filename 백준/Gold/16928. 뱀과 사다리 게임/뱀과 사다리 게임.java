
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] cheat;
    static int move;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheat = new int[101];
        visited = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cheat[a] = b;
        }
        bfs();
        System.out.println(cnt);
    }

    public static void bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{1, 0}); //{칸번호, 주사위횟수}

        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int pos = now[0];
            cnt = now[1];

            //100을 넘었거나 100이면 도달
            if (pos >= 100 || pos == 100) {
                return;
            }

            for (int i = 1; i <= 6; i++) {
                move = pos + i;
                if (move > 100) {
                    continue;
                }
                if (visited[move]) {
                    continue;
                }

                if (cheat[move] != 0) {
                    move = cheat[move];
                }

                visited[move] = true;
                dq.add(new int[]{move, cnt + 1});
            }
        }
    }
}