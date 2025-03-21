import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (ch == ')') {
                    return false;
                } else {
                    stack.addLast(ch);
                }
            } else {
                if (ch == ')' && stack.peekLast() == '(') {
                    stack.removeLast();
                } else {
                    stack.addLast(ch);
                }
            }
        }

        return stack.isEmpty();
    }
}
