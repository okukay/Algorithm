class Solution {
    boolean solution(String s) {
        int len = s.length();
        int score = 0;
        boolean answer = true;
        
        for(int i = 0; i<len; i++){
           
            if(s.charAt(i) == '('){
               score += 1;             
                if(score < 0){
                    return false;
                }
            }
            else if(s.charAt(i) == ')'){
                score -= 1;
                 if(score < 0){
                    return false;
                }
            }
        }

        if(score == 0){
            answer = true;
        }
        else{
            answer = false;
        }
        return answer;
    }
}