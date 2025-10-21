class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int k = 1; k * (k-1)/2 < n ; k++){
            int a = (n - k * (k - 1) / 2) / k;
            
            if((n- k*(k-1) /2) % k == 0 && a > 0){
                answer++;
                }
        }
        
        return answer;
    }
}