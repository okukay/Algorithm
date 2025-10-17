import java.util.*;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int cnt = 0; cnt< commands.length; cnt++){
            
            List<Integer> list = new ArrayList<>();
                
            int i = commands[cnt][0];
            int j = commands[cnt][1];
            int k = commands[cnt][2];
            
            for(int num = i-1; num<j; num++){
                int number = array[num];
                list.add(number);
            }
            list.sort(null);
            int result = list.get(k-1);
            answer[cnt] = result;
        }
        
        
        return answer;
        }
    }
