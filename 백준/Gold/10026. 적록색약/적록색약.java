import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static char[][] map;
    static boolean[][] visited,blindnessVisited;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static int N;
    static char color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N]; 
        blindnessVisited =  new boolean[N][N]; 
        int cnt = 0;
        int blindnessCnt = 0;

        for(int i = 0; i<N; i++){
            String L = br.readLine();
            for(int j = 0; j<N; j++){
                map[i][j] = L.charAt(j);
            }
        }
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!visited[i][j]){
                    color = map[i][j];
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!blindnessVisited[i][j]){
                    color = map[i][j];
                    blindnessbfs(i,j);
                    blindnessCnt++;
                }
            }
        }
        System.out.println(cnt + " " + blindnessCnt);
      
        
    }


    public static void bfs(int si, int sj){
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        visited[si][sj] = true;
        dq.add(new int[] {si, sj});

        while(!dq.isEmpty()){
            int[] node = dq.poll();

            for(int i =0; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];

                if(ni< 0 || ni >= N || nj < 0 || nj >= N)continue;
                if(visited[ni][nj])continue;

                if(map[ni][nj] == color){
                    visited[ni][nj] = true;
                    dq.add(new int[] {ni, nj});
                }
            }
        }
    }
    
    public static void blindnessbfs(int si, int sj){
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        blindnessVisited[si][sj] = true;
        dq.add(new int[] { si,sj});

        while(!dq.isEmpty()){
            int[] node = dq.poll();

             for(int i =0; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];

                if(ni< 0 || ni >= N || nj < 0 || nj >= N)continue;
                if(blindnessVisited[ni][nj])continue;

                if(color == 'R' || color == 'G'){
                    if(map[ni][nj] == 'R' || map[ni][nj] == 'G'){
                        blindnessVisited[ni][nj] = true;
                        dq.add(new int[] {ni, nj});
                    }
                }
                else if(color == 'B' && map[ni][nj] == 'B') {
                blindnessVisited[ni][nj] = true;
                dq.add(new int[] {ni, nj});
            }
        }
     }
    }
}