import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;



class Solution {
    public int solution(int[] priorities, int location) {
       
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i = 0; i<priorities.length; i++){
            dq.add(new int[] {i,priorities[i]});
        }
        int answer = 0;

        while(!dq.isEmpty()){
            int[] node = dq.poll();
            int x = node[0];
            int y = node[1];
            
            boolean higher = false;
                for(int[] q : dq){
                    if( y < q[1]){
                        higher = true;
                        break;
                    }
                }
            if(higher){
                dq.add(new int[] {x,y});
            }
            else{
                 answer++;
                if(x == location){
                            return answer;
                        }
                }
            }
        return answer;
    }
}