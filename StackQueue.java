package test;

import java.util.Stack;

class Sq{
Sq(){}
int solution(String arrangement) {
    int answer = 0;
    Stack<Character> stack = new Stack<Character>();
    
    for(int i=0;i<arrangement.length();i++) {
    	if(arrangement.charAt(i)=='(') {
    		stack.push(arrangement.charAt(i));
    	} else {
            stack.pop();
            if (arrangement.charAt(i-1) == '(')
                answer+=stack.size();
            else
                answer++;
        }
    }
    return answer;
    }
}
public class StackQueue {
	public static void main(String[] args) {
		Sq ex = new Sq();
		String col = "()(((()())(())()))(())";
		int result = ex.solution(col);
		System.out.println(result);
	}
}
