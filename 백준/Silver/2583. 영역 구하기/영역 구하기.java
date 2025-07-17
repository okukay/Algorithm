import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static int[][] map;
    static int[] dx = {1,-1, 0 ,0};
    static int[] dy = {0,0,-1,1};
    static int N,M,K,count,cnt;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String L = br.readLine();
        StringTokenizer st = new StringTokenizer(L);

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;
        result = new ArrayList<>();
        
        map = new int[M][N];

        for(int k = 0; k<K; k++){
            String Line = br.readLine();
            st = new StringTokenizer(Line);

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1; 
                }
            }
        }

        for(int i = 0 ; i<M; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 0){
                    count = 1;
                    bfs(i,j);
                    result.add(count);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(result);
        for(int i = 0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
        
    }
    public static void bfs(int si, int sj){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        map[si][sj] = 1;
        dq.add(new int[] { si,sj});

        while(!dq.isEmpty()){

            int node[] = dq.poll();

            for(int i = 0 ; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];
                
                if(ni< 0 || ni >= M || nj < 0 || nj >= N)continue;

                if(map[ni][nj] == 0){
                map[ni][nj] = 1;
                dq.add(new int[] {ni,nj});
                count++;
                }
            }
        }
    }
}