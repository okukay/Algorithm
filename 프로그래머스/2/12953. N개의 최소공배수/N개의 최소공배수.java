class Solution {
    public int solution(int[] arr) {
        int gcdResult = arr[0];
        int lcmResult = arr[0];

        for(int i = 1; i<arr.length; i++){
            gcdResult = gcd(gcdResult, arr[i]);
            lcmResult = lcm(lcmResult, arr[i]);
        }
        
        return lcmResult;
    }

    public static int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }

    public static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
}