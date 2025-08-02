
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M = 6;
    static boolean[] visited;
    static int[] input, output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String L = br.readLine();
            StringTokenizer st = new StringTokenizer(L);

            N = Integer.parseInt(st.nextToken());
            input = new int[N];
            visited = new boolean[N];

            output = new int[6];

            if (N == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }
}