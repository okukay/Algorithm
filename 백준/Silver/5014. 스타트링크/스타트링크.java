import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {

    static int F,S,G,U,D,cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String L = br.readLine();

        StringTokenizer st = new StringTokenizer(L);

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        cnt = 0;
        visited = new boolean[F+1];

        bfs(S,G);

    }
    public static void bfs(int S, int G){

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(S);

        while(!dq.isEmpty()){
            int size = dq.size();

            for(int i = 0; i<size; i++){
            int cur = dq.poll();

            if(cur == G){
                System.out.println(cnt);
                return; 
            }
            
            for(int n : new int[]{cur+U , cur-D}){
                
                if(n > F || n <= 0 || visited[n]) continue;
                visited[n] = true;
                dq.add(n);
            }
        }
        cnt++;
        }
        System.out.println("use the stairs");
    }
}