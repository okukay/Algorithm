import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {


    static final int MAX = 100_001;
    static boolean[] visited = new boolean[MAX];
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        bfs(N, K);

    }
    public static void bfs(int start, int target){

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {start, 0});
        visited[start] = true;

        while(!dq.isEmpty()){
            int node[] = dq.poll();
            int pos = node[0];
            int time = node[1];

            if(pos == target){
                System.out.println(time);
                return;
            }

            for(int next : new int[] {pos -1, pos+1, pos*2}){
            
                if(next < 0 || next >= MAX || visited[next])continue;

                visited[next] = true;
                dq.add(new int[]{next , time + 1});
            }
        }
    }
}