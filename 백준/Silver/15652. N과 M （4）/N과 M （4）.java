
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static boolean[] visited;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String L = br.readLine();
        StringTokenizer st = new StringTokenizer(L);

        N = Integer.parseInt(st.nextToken()); // 숫자 범위
        M = Integer.parseInt(st.nextToken()); // 뽑을 개수

        visited = new boolean[N + 1];
        output = new int[M];

        dfs(0, 1);
        System.out.print(sb);

    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;

        }
        for (int i = start; i <= N; i++) {
            output[depth] = i;
            dfs(depth + 1, i);
        }

    }
}