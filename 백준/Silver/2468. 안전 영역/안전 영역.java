import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int max_height,N,result;
    static int[][] map;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        max_height = 0;
        result = 0;
        

        for(int i = 0; i<N; i++){
            String L = br.readLine();
            StringTokenizer st = new StringTokenizer(L);
            for(int j = 0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if(max_height <n){
                    max_height = n;
                }
            }
        }

        
        for(int rain = 0; rain<max_height; rain++){
            int count = 0;
            visited = new boolean[N][N];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(!visited[i][j] && map[i][j] > rain){
                        bfs(i,j, rain);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
        
    }
    public static void bfs(int si, int sj, int rain){
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        visited[si][sj] = true;
        dq.add(new int[] {si,sj});
        
        while(!dq.isEmpty()){

            int node[] = dq.poll();

            for(int i = 0; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];

                if(ni< 0 || ni>= N || nj< 0 || nj>= N)continue;

                if(map[ni][nj] > rain && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    dq.add(new int[] {ni,nj});
                }
            }
        }
    }
}