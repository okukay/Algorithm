import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static ArrayDeque<int[]> firedq,sgdq;
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,-1,1};
    static int w,h;
    static char[][] map;
    static int[][] fireTime, sgTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int t =0; t < T; t++){

            String L = br.readLine();
            StringTokenizer st = new StringTokenizer(L);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            fireTime = new int[h][w];
            sgTime = new int[h][w];

            firedq = new ArrayDeque<>();
            sgdq = new ArrayDeque<>();


            // map 초기화
            for(int i = 0 ; i<h; i++){
                String Line = br.readLine();
                for(int j = 0; j<w; j++){
                    map[i][j] = Line.charAt(j);
                }
            }

            //방문배열 초기화
            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    fireTime[i][j] = -1;
                    sgTime[i][j] = -1;
                }
            }

            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(map[i][j] == '*'){
                        firedq.add(new int[] {i,j});
                        fireTime[i][j] = 0;
                    }
                }
            }
            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(map[i][j] == '@'){
                        sgdq.add(new int[] {i,j});
                        sgTime[i][j] = 0;
                    }
                }
            }
            firebfs();
            sgbfs();
        }
     
    }

    public static void firebfs(){
        while(!firedq.isEmpty()){
            int node[] = firedq.poll();
            int x = node[0];
            int y = node[1];

            for(int i = 0; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];

                if(ni< 0 || ni >= h || nj < 0 || nj >= w)continue;
                if(map[ni][nj] == '#' || fireTime[ni][nj] != -1)continue;

                firedq.add(new int[]{ni,nj});
                fireTime[ni][nj] = fireTime[x][y] + 1;
            }
        }
    }

    public static void sgbfs(){
        while(!sgdq.isEmpty()){

            int node[] = sgdq.poll();
            int x = node[0];
            int y = node[1];

            if(x == 0 || x == h-1 || y == 0 || y == w-1){
                System.out.println(sgTime[x][y] + 1);
                return;
            }

            for(int i = 0; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];

                if(ni< 0 || ni >= h || nj < 0 || nj >= w)continue;
                if(map[ni][nj] == '#' || sgTime[ni][nj] != -1)continue;
                if(fireTime[ni][nj] != -1 && fireTime[ni][nj] <= sgTime[x][y] + 1)continue;

                sgdq.add(new int[]{ni,nj});
                sgTime[ni][nj] = sgTime[x][y] + 1;
            }
        }
         System.out.println("IMPOSSIBLE ");
    }
}
