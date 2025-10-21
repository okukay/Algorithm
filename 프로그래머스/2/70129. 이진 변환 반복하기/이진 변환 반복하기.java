class Solution {
    public int[] solution(String s) {
        int cnt  = 0;
        int turns = 0;
        boolean flag = true;
        int len = s.length();
        String x = s;
        

       while(!x.equals("1")) {
            
             for(int i = 0; i<x.length(); i++){
                 char a = x.charAt(i);
                 if(a == '0'){
                     cnt++;
                 }
             }
           
            x = x.replace("0", "");
            
            x = Integer.toBinaryString(x.length());
            
            turns++;
        }
        int[] answer = new int[] {turns, cnt };
        
        return answer;
    }
}