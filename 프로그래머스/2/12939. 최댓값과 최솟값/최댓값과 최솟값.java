import java.util.*;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] a = s.split(" ");
        
        int[] num = new int[a.length];
        for(int i = 0; i<a.length; i++){
            num[i] = Integer.parseInt(a[i]);
        }
        for(int i = 0; i<num.length; i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        

        String answer = "" + min + " " + max + "";
        return answer;
    }
}