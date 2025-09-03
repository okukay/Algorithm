
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numberlist = new int[N];
        int[] count = new int[N];

        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            numberlist[i] = n;
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);

        }

        Arrays.sort(numberlist);
        int idx = 0;
        if (N == 1) {
            idx = 0;
        } else {
            idx = N / 2;
        }

        //산술평균
        long mean = Math.round(sum / N);

        //중앙값
        int mid = numberlist[idx];

        //최빈값
        int cnt = 1;
        int maxCnt = 0;
        ArrayList<Integer> mode = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            if (numberlist[i] == numberlist[i - 1]) {
                cnt++;
            } else if (numberlist[i] != numberlist[i - 1]) {
                if (maxCnt == cnt) {
                    mode.add(numberlist[i - 1]);
                    maxCnt = cnt;
                } else if (maxCnt < cnt) {
                    mode.clear();
                    mode.add(numberlist[i - 1]);
                    maxCnt = cnt;
                }
                cnt = 1;
            }

        }
        //마지막 값
        if (maxCnt == cnt) {
            mode.add(numberlist[N - 1]);
        } else if (maxCnt < cnt) {
            mode.clear();
            mode.add(numberlist[N - 1]);
            maxCnt = cnt;
        }
        int resultMode = 0;
        if (mode.size() >= 2) {
            resultMode = mode.get(1);
        } else {
            resultMode = mode.get(0);
        }

        int sub = (max - min);

        System.out.println(mean);
        System.out.println(mid);
        System.out.println(resultMode);
        System.out.println(sub);
    }

}