class Solution {
    public int solution(int a, int b) {
        
        
        String a1 = String.valueOf(a);
        String b1 = String.valueOf(b);
        int answer = 0;
        int result1 = Integer.parseInt(a1+b1);
        int result2 = Integer.parseInt(b1+a1);
        
        if(result1 > result2){
            answer =  result1;     
        }
        else{
            answer = result2;
        }
        return answer;
    }
}