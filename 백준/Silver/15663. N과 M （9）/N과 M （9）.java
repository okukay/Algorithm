
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] input, output;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String L = br.readLine();

        StringTokenizer st = new StringTokenizer(L);

        N = Integer.parseInt(st.nextToken()); // 범위
        M = Integer.parseInt(st.nextToken()); // 뽑을 개수

        visited = new boolean[N];
        output = new int[M];
        input = new int[N];
        String Line = br.readLine();
        st = new StringTokenizer(Line);

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        // System.out.println(Arrays.toString(input));
        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;

        for (int i = 0; i < input.length; i++) {
            if (prev == input[i]) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                dfs(depth + 1);
                visited[i] = false;

                prev = input[i];
            }

        }
    }

}