//그리디 문제, 
// 아이디어 : 작은수 x 큰수 짝지으면 최솟값나옴
import java.util.*;
class Solution
{
    public int solution(int []A, int []B){
        Arrays.sort(A);
        Integer[] arrB = new Integer[B.length];

        for(int i = 0; i<B.length; i++){
            arrB[i] = B[i];
        }
        Arrays.sort(arrB, Collections.reverseOrder());

        int answer = 0;
        for(int i = 0; i<A.length; i++){
            answer += A[i] * arrB[i];
        }
        return answer;
    }
}