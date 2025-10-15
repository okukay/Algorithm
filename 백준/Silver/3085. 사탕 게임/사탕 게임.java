
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char a = line.charAt(j);
                map[i][j] = a;
            }
        }
        int answer = 0;
        //오른쪽 이랑 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, check(i, j));
                    swap(i, j, i, j + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    answer = Math.max(answer, check(i, j));
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(answer);
    }

    public static void swap(int i, int j, int i2, int j2) {
        char temp = map[i][j];
        map[i][j] = map[i2][j2];
        map[i2][j2] = temp;
    }

    public static int check(int x, int y) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (map[i][j] == map[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (map[i][j] == map[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}