import java.util.*;
import java.util.Arrays;

class Solution {
    static boolean[] visited;
    static int N;
    static int[] num;
    static int K;
    static int[][] Dungeons;
    static int value;
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        K = k;
        value = k;
        Dungeons = dungeons;
        N = dungeons.length;
        num = new int[N];
        visited = new boolean[N];
        
        int answer = -1;
        per(0);
        return max;
    }
    
    //순열
    public static void per(int cnt){
        if(cnt == N){
            int duns = 0;
            K = value;
            // System.out.println(Arrays.toString(num));
            for(int i = 0; i<num.length; i++){
              int n = num[i];
              int a = Dungeons[n][0];
                if(K >= a){
                    duns++;
                    K = K - Dungeons[n][1];
                }
            }
            max = Math.max(duns, max);
            return;
        }
        for(int i = 0; i<N; i++){
            if(visited[i])continue;
            visited[i] = true;       //수 사용처리
            num[cnt] = i;            //수선택
            per(cnt+1);              //다음수 뽑기
            visited[i] = false;      // 원복
        }
    }
}