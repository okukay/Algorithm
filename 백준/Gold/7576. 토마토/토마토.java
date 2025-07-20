import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int M, N, check;
	static int[][] map;
	static int ni,nj,ci,cj;
	static int day;
	static ArrayDeque<int[]> dq = new ArrayDeque<>();

	static void bfs() {

		while (!dq.isEmpty()) {

			int[] node = dq.poll();
			ci = node[0];
			cj = node[1];
			
			for (int i = 0; i < 4; i++) {
				ni = node[0] + dx[i];
				nj = node[1] + dy[i];

				if (ni < 0 || ni >= N || nj < 0 || nj >= M)
					continue;

				if (map[ni][nj] == 0) {
					map[ni][nj] = map[ci][cj] + 1;
					dq.add(new int[] { ni, nj });
					check -= 1;
					
					if(day <= map[ni][nj]) {
						day = map[ni][nj];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String L = br.readLine();

		StringTokenizer st = new StringTokenizer(L);
		M = Integer.parseInt(st.nextToken()); // 가로 6
		N = Integer.parseInt(st.nextToken()); // 세로 4
//		int H = Integer.parseInt(st.nextToken()); //높이 
		check = 0;
		map = new int[N][M];
		day = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				// 처음에 1(익은)인걸 큐에 전부저장
				if (map[i][j] == 1) {
					dq.add(new int[] { i, j });
				}
				// 토마토 개수 (나중에 체킹 하기위함)
				if(map[i][j] == 0) {
					check += 1;
				}
			}
		}// 입력완료
		
		bfs();
		if(check == 0 && day != 0) {
			System.out.println(day-1);
		}
		else if(check == 0 && day == 0){
			System.out.println("0");
		}
		else {
			System.out.println("-1");
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	}
}
