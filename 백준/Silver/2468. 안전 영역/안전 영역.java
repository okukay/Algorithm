
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	// 비의 양이 정해졌을때 물에 잠기지 않는 영역 개수 구하기

	private static void bfs(int si, int sj) {
		// deque 생성
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		// 방문체크
		visited[si][sj] = true;
		// 큐에 넣기
		dq.add(new int[] { si, sj });

		while (!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int ni = node[0] + dx[i];
				int nj = node[1] + dy[i];

				if (0 > ni || ni >= N || 0 > nj || nj >= N)
					continue;
				if (visited[ni][nj])
					continue;
				
				// 4가 잠기는 높이임(바꿔줘야함)
				visited[ni][nj] = true;
				dq.add(new int[] { ni, nj });
				}
			}
		}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max_value = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				// map에서 젤 높은 지역( 1~ vlaue 까지만 돌면됨, 그후로는 다 잠김)
				if (max_value < a) {
					max_value = a;
				}
			}
		}
		// 입력완료

		int result = 0;
		for(int i = 0; i<max_value; i++) {
			visited = new boolean[N][N]; // 침수높이에 따라 한번씩 bfs돌테니까 한번씩 초기화
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					//물높이보다 낮으면 침수 == true == 방문안함
					if(map[j][k] <= i) {
						visited[j][k] = true;
					}
				}
			}
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					//침수 되지 않았으면 bfs호출
					if(visited[j][k] == false) {
						bfs(j,k);
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
			
		}
		System.out.println(result);
	}

}
