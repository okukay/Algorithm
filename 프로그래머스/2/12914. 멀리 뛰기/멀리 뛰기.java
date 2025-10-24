import java.util.*;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2; 
        long[] list = new long[n+1];
        list[0] = 0;
        list[1] = 1;
        list[2] = 2;
        
        for(int i = 3; i<=n; i++){
            list[i] = (list[i-1] + list[i-2])%1234567;
        }
        System.out.println(Arrays.toString(list));
        long answer = list[n];
        return answer;
    }
}