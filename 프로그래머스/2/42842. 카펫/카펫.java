import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        for(int i = 1; i*i <= yellow; i++){
            if(yellow % i == 0){
                dq.add(new int[] {i,(yellow/i)});
            }
        }
        System.out.println(Arrays.deepToString(dq.toArray()));
        System.out.println(dq.size());

        while(!dq.isEmpty()){
            int[] node = dq.poll();
            int a = node[0];
            int b = node[1];
            System.out.println(a + " " + b);
            if((a+b) * 2 + 4 == brown ){
                System.out.println("이게 답일 수 있음");
                System.out.println(b+2 + " " + (a+2));
                answer[0] = b+2;
                answer[1] = a+2;
            }
        }
        
        return answer;
    }
}