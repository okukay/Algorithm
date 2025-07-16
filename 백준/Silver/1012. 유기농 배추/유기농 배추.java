import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int m, n, k;
	static int[][] visit;
	static int[][] arr;
	static int cnt;
	static int[] di = { 0, -1, 0, 1 };
	static int[] dj = { 1, 0, -1, 0 };

	static void dfs(int si, int sj) {
		visit[si][sj] = 1;

		for (int i = 0; i < 4; i++) {
			int ci = si + di[i];
			int cj = sj + dj[i];
			if (ci >= 0 && ci < n && cj >= 0 && cj < m) {
				if (arr[ci][cj] == 1 && visit[ci][cj] == 0) {
					dfs(ci, cj);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        // 각 테스트 케이스 처리
        for (int testCase = 0; testCase < t; testCase++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
			
			m = Integer.parseInt(st.nextToken()); // 가로 길이
			n = Integer.parseInt(st.nextToken()); // 세로 길이
			k = Integer.parseInt(st.nextToken()); // 배추의 위치 개수

			arr = new int[n][m];
			visit = new int[n][m];
			cnt = 0;

			// 배추 심어진 위치 입력
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[b][a] = 1; // (a, b) 위치에 배추 심기
			}

			// 디버깅용으로 arr 배열 출력
//			System.out.println(Arrays.deepToString(arr));

			// arr 배열을 순회하면서 DFS 수행
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1 && visit[i][j] == 0) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
}