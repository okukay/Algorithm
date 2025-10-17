import java.util.*;
import java.util.ArrayDeque;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int N,M;
    static int[][] map;
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        
        map = maps;
        visited = new boolean[N][M];
        int answer = bfs(0,0);

        return answer;
    }
    
    public static int bfs(int si, int sj){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {si,sj});
        visited[si][sj] = true;
        
        while(!dq.isEmpty()){
            int[] node = dq.poll();
            int x = node[0];
            int y = node[1];
            
            if(x == N-1 && y == M-1){
                return map[x][y];
            }
            
            for(int i = 0; i< 4; i++){
                int ni = x + dx[i];
                int nj = y + dy[i];
                
                if(ni< 0 || ni>=N || nj<0 || nj>= M || visited[ni][nj] ||map[ni][nj]==0)continue;
                visited[ni][nj] = true;
                dq.add(new int[] {ni,nj});
                map[ni][nj] = map[x][y] + 1;
                
            }
        }
        return -1; 
    }
}