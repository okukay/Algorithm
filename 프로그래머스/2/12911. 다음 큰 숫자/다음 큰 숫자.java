class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String count = Integer.toBinaryString(n);
        String cnt = count.replace("0", "");
        //1의 개수
        
        int i = 1;
        while(true){
            int nextNum = n+i;
            String nextCount = Integer.toBinaryString(nextNum);
            String nextCnt = nextCount.replace("0", "");
            
            if(cnt.length() == nextCnt.length()){
                answer = nextNum;  
                break;
            }
            i++;
            
        }
        
        return answer;
    }
}