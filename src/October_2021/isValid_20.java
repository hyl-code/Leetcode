package October_2021;

import java.util.Stack;

/*
    给定一个只包括 '(',')','{','}','[',']' 的字符串 s ,判断字符串是否有效 .

    有效字符串需满足 :

    1.左括号必须用相同类型的右括号闭合.
    2.左括号必须以正确的顺序闭合.
 */

public class isValid_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }
}

