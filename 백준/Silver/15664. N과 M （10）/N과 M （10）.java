
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] input, output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String L = br.readLine();

        StringTokenizer st = new StringTokenizer(L);

        N = Integer.parseInt(st.nextToken()); // 범위
        M = Integer.parseInt(st.nextToken()); // 뽑을 개수

        input = new int[N];
        output = new int[M];
        visited = new boolean[N];

        String Line = br.readLine();
        st = new StringTokenizer(Line);
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0, 0);
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
        int temp = 0;

        for (int i = start; i < N; i++) {
            if (temp == input[i]) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
                temp = input[i];
            }
        }
    }
}