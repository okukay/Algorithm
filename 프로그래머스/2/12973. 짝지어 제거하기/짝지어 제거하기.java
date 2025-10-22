import java.util.*;
import java.util.Stack;



class Solution
{
    public int solution(String s){
    Stack<Character> stack = new Stack<>();
        int answer;
        for(int i = 0; i<s.length(); i++){
            char a = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == a){
                stack.pop();
            }
            else{
                stack.push(a);
            }
        }
        if(stack.isEmpty() == true){
            answer = 1;
        }
        else{
            answer = 0;
        }
        return answer;
    }
}


        