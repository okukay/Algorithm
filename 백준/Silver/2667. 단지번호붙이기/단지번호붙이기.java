
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt, house;

	static void bfs(int si, int sj) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		map[si][sj] = 0;
		dq.add(new int[] { si, sj });

		while (!dq.isEmpty()) {

			int node[] = dq.poll();

			for (int i = 0; i < 4; i++) {
				int ni = node[0] + dx[i];
				int nj = node[1] + dy[i];

				if ( 0 > ni || ni >= N || 0 > nj || nj >= N) {
					continue;
				}
				if (map[ni][nj] == 1) {
					map[ni][nj] = 0;
					dq.add(new int[] { ni, nj });
					house++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 결과 저장할 배열
		ArrayList<Integer> arr = new ArrayList<>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine(); // 한 줄 입력받기
			for (int j = 0; j < N; j++) {
				// 각 문자를 정수로 변환하여 map 배열에 저장
				map[i][j] = line.charAt(j) - '0';
			}
		} // 입력완료
		
		//단지 개수
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					//한 단지당 집의개수
					house = 1;
					bfs(i, j);
					arr.add(house);
					cnt++;
					
				}
			}
		}
		System.out.println(cnt);
		
		Collections.sort(arr);
		
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
