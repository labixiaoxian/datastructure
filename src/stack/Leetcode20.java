package stack;

import java.util.Stack;

/**
 * @author 小贤
 * @PackageName:stack
 * @ClassName:Leetcode20
 * @Description:
 * @data 2020/12/25 20:35
 */
public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChart = stack.pop();
                if (c == ')' && topChart != '(') {
                    return false;
                } else if (c == ']' && topChart != '[') {
                    return false;
                } else if (c == '}' && topChart != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

}
