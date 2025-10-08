
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static List<int[]> chickens;
    static List<int[]> house;
    static int[] selected;
    static int minCityDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chickens = new ArrayList<>();
        selected = new int[M];

        for (int i = 0; i < N; i++) {
            String Line = br.readLine();
            st = new StringTokenizer(Line);
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    house.add(new int[]{i, j});
                }
                if (a == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        comb(0, 0);
        System.out.println(minCityDist);
    }

    public static void comb(int start, int cnt) {
        if (cnt == M) {
            int sum = 0;
            for (int h[] : house) {
                int minDist = Integer.MAX_VALUE;
                for (int idx : selected) {
                    int[] c = chickens.get(idx);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minDist = Math.min(minDist, dist);
                }
                sum += minDist;
            }
            minCityDist = Math.min(minCityDist, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[cnt] = i;
            comb(i + 1, cnt + 1);

        }
    }
}