import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> used = new HashSet<>();
        
        used.add(words[0]);
        char last = words[0].charAt(words[0].length() - 1);
        
        for(int i = 1; i<words.length; i++){
            String current = words[i];
            char first = current.charAt(0);
            
            if(last != first  || used.contains(current)){
                int person = (i % n) +1;
                int turn = (i / n) + 1;
                answer[0] = person;
                answer[1] = turn;
                break;
            }
            used.add(current);
            last = current.charAt(current.length() - 1);
        }
        return answer;
    }
}