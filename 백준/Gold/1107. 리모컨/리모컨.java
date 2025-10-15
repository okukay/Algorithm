
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static List<Integer> map;
    static int minPress;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            map.add(i);
        }
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int a = Integer.parseInt(st.nextToken());

                map.remove(Integer.valueOf(a));
            }
        }

        //100에서 +-로만 목표채널에 도착했을때
        minPress = Math.abs(N - 100);

        for (int i = 0; i <= 6; i++) {
            dfs(0, i, "");
        }
        System.out.println(minPress);

    }

    public static void dfs(int depth, int len, String num) {
        if (depth == len) {
            if (num.isEmpty()) {
                return;
            }
            int channel = Integer.parseInt(num);
            int press = len + Math.abs(N - channel);
            minPress = Math.min(minPress, press);
            return;
        }

        for (int i = 0; i < map.size(); i++) {
            int btn = map.get(i);
            dfs(depth + 1, len, num + btn);
        }
    }
}