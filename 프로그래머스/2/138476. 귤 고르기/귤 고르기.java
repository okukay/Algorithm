import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;



class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<tangerine.length; i++){
            int t = tangerine[i];
            map.put(t, map.getOrDefault(t,0)+1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        int answer = 0;
        int total = 0;
        
        for(int c : counts){
            total += c;
            answer++;
            if(total >= k)break;
        }

        return answer;
    }
}