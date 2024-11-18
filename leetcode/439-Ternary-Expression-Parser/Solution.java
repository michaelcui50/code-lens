import java.util.*;

class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        int i = expression.length() - 1;

        while (i >= 0) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == 'T' || c == 'F') {
                stack.push(c);
            }else if (c == '?') {
                char falsePart = stack.pop();
                char truePart = stack.pop();

                stack.push(expression.charAt(i-1) ? truePart : falsePart);
                i--;
            }
            i--;
        }
        return String.valueOf(stack.pop());
    }
}