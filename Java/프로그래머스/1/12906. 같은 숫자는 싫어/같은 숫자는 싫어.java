import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();

        for (int a : arr) {
            if (stack.isEmpty()) {
                stack.addLast(a);
                continue;
            }
            if (stack.peekLast() == a) {
                continue;
            }
            stack.addLast(a);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
