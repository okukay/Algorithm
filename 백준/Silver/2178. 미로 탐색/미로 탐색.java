import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static int N, M, cnt;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        N = Integer.parseInt(st.nextToken()); //4
        M = Integer.parseInt(st.nextToken()); //6
        map = new int[N][M];
        cnt = 0;

        for(int i = 0; i<N; i++){
            String L = br.readLine();
            for(int j = 0; j<M; j++){
                map[i][j] = L.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(map[N - 1][M - 1]);
        
    }

    public static void bfs(int si , int sj){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {si,sj});
        

        while(!dq.isEmpty()){
            int node[] = dq.poll();

            for(int i =0; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];

                if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                
                if(map[ni][nj] == 1){
                    map[ni][nj] = map[node[0]][node[1]] +1;
                    dq.add(new int[] {ni, nj});
                }
            }
        }
    }
}