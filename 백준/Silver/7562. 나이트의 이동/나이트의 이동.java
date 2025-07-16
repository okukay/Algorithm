import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int tarX,tarY,N;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t< T; t++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            String location = br.readLine();
            StringTokenizer st = new StringTokenizer(location);
            int locX = Integer.parseInt(st.nextToken());
            int locY = Integer.parseInt(st.nextToken());

            String target = br.readLine();
            st = new StringTokenizer(target);
            tarX = Integer.parseInt(st.nextToken());
            tarY = Integer.parseInt(st.nextToken());
            
            bfs(locX, locY);
        }
    }
    public static void bfs(int si , int sj){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visited[si][sj] = true;
        dq.add(new int[]{si,sj,0});
        
        while(!dq.isEmpty()){
            
            int node[] = dq.poll();
            int x = node[0];
            int y = node[1];
            int dist = node[2];

            if(x == tarX && y == tarY){
                System.out.println(dist);
                return;
            }
            for(int i = 0; i<8; i++){
                int ni = x + dx[i];
                int nj = y + dy[i];

                if(ni < 0 || ni>= N || nj < 0 || nj>= N || visited[ni][nj])continue;

                visited[ni][nj] = true;
                dq.add(new int[] {ni,nj,dist+1});
                

            }
        }
    }
}