import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] fireTime, jihunTime;
    static ArrayDeque<int[]> firedq;
    static ArrayDeque<int[]> jihundq;
    static int C,R;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String L = br.readLine();

        StringTokenizer st = new StringTokenizer(L);

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];


        fireTime = new int[R][C];
        jihunTime = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fireTime[i][j] = -1;
                jihunTime[i][j] = -1;
            }
        }
        firedq = new ArrayDeque<>();
        jihundq = new ArrayDeque<>();
     
        for(int i = 0; i<R; i++){
            String Line = br.readLine();
            for(int j = 0; j<C; j++){
                 char input = Line.charAt(j);
                 map[i][j] = input;
                 if(input == 'F'){
                    firedq.add(new int[] {i,j});
                    fireTime[i][j] = 0;
                 }
                 if(input == 'J'){
                    jihundq.add(new int[] {i,j});
                    jihunTime[i][j] = 0;
                 }
            }
        }
        firebfs();
        jihunbfs();
    }


    public static void firebfs(){

            while(!firedq.isEmpty()){

            int node[] = firedq.poll();

            for(int i = 0; i<4; i++){
                int ni = node[0] + dx[i];
                int nj = node[1] + dy[i];

                if(ni< 0 || ni>= R || nj < 0 || nj >= C) continue;
                if(map[ni][nj] == '#' || fireTime[ni][nj] != -1)continue;

                fireTime[ni][nj] = fireTime[node[0]][node[1]] + 1;
                firedq.add(new int[]{ni,nj});
            }
        }
    }
    
    public static void jihunbfs(){

        while(!jihundq.isEmpty()){
            int node[] = jihundq.poll();
            int x = node[0];
            int y = node[1];

            if(x == 0 || x == R-1|| y == 0 || y == C-1){
                System.out.println(jihunTime[x][y]+1);
                return;
            }
            for(int i = 0; i<4; i++){
                int ni = x +dx[i];
                int nj = y +dy[i];

                if(ni < 0 || ni>= R || nj <0 || nj >= C)continue;
                if(map[ni][nj] == '#' || jihunTime[ni][nj] != -1)continue;
                if(fireTime[ni][nj] != -1 && fireTime[ni][nj] <= jihunTime[x][y] +1)continue;

                jihundq.add(new int[] {ni,nj});
                jihunTime[ni][nj] = jihunTime[x][y] +1;

            }
        }
        System.out.println("IMPOSSIBLE ");
    }
}