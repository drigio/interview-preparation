
/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order.
 * 
 * LeetCode :- https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;

public class ValidParantheses {
    public static boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        if (s.length() == 1)
            return false;

        char[] str = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        char pop;
        for (char ch : str) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                pop = stack.pop();
                if (ch == ')' && pop != '(' || ch == '}' && pop != '{' || ch == ']' && pop != '[') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String args[]) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }
}
