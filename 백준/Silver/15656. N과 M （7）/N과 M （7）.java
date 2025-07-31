
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

        visited = new boolean[N + 1];
        input = new int[N + 1];
        output = new int[M];

        String Line = br.readLine();
        st = new StringTokenizer(Line);

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

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
        for (int i = 1; i <= N; i++) {
            output[depth] = input[i];
            dfs(depth + 1);
        }
    }

}