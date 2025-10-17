import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {

        map = new ArrayList[n+1];
        
        for(int i = 0; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            map[wire[0]].add(wire[1]);
            map[wire[1]].add(wire[0]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int[] wire : wires){
            int x = wire[0];
            int y = wire[1];
            
            map[x].remove(Integer.valueOf(y));
            map[y].remove(Integer.valueOf(x));
            
            visited = new boolean[n + 1];
            int cnt = bfs(x);
            
            int diff = Math.abs((n- cnt) - cnt);
            minDiff = Math.min(diff, minDiff);
            
            map[x].add(y);
            map[y].add(x);
        }
        
        return minDiff;
        
    }
    public static int bfs(int si){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(si);
        visited[si] = true;
        int count = 1;
        
        
        while(!dq.isEmpty()){
            int node = dq.poll();
            
            
            for(int next : map[node]){
                if(visited[next])continue;
                visited[next] = true;
                dq.add(next);
                count++;
            }
        }
        return count;
    }
}