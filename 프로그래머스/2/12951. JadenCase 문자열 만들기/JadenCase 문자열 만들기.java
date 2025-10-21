import java.util.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ",-1); 
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // System.out.println(word);
            
            if(word.length() == 0){
                answer.append(" ");
                continue;
            }
            char first = word.charAt(0);
            // System.out.println(first);
            char First = Character.toUpperCase(first);
            // System.out.println(First);
            String last = word.substring(1);
            String Last = last.toLowerCase();
            // System.out.println(last);
            
            String result = First + Last;
            // System.out.println(result);
            

            if(i != 0){
                answer.append(" ");
            }
            answer.append(result);
        }  
        return answer.toString();
    }
}


        

        
