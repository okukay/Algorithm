import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static int N,M,cnt,painting,max;
                
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Line = br.readLine();
        StringTokenizer st = new StringTokenizer(Line);

        N = Integer.parseInt(st.nextToken()); //6
        M = Integer.parseInt(st.nextToken()); //5
        max = 0;
        
        cnt = 0;

        map = new int[N][M];    

        for(int i = 0; i<N; i++){
            String L = br.readLine();
            st = new StringTokenizer(L);
            for(int j = 0; j<M; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] == 1){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    public static void bfs(int si , int sj){

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        painting = 1; 

        map[si][sj] = 0;
        dq.add(new int[] {si,sj});

        while(!dq.isEmpty()){
        int node[] = dq.poll();

        for(int i = 0; i<4; i++){
            int ni = node[0] + dx[i];
            int nj = node[1] + dy[i];

            if(ni < 0 || ni >= N || nj < 0 || nj >= M){
                continue;
            }
            
            if(map[ni][nj] == 1){
                map[ni][nj] = 0;
                dq.add(new int[] {ni,nj});
                painting++;

            }
        }               
    }
       max = Math.max(max, painting);
    }
}