import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-12-14 8:42
 * @Since 1.0.0
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int el : pushed){
            stack.addLast(el);
            while (!stack.isEmpty() && stack.peekLast() == popped[j]) {
                stack.pollLast();
                j++;
            }
        }
        return j == popped.length;
    }
}
