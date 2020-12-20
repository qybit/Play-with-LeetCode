import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-12-20 14:02
 * @Since 1.0.0
 */
public class Solution {

    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c =  s.charAt(i);
            if (stack.contains(c)) continue;
            while (!stack.isEmpty() && stack.peekLast() > c && s.indexOf(stack.peekLast(), i) != -1) {
                stack.pollLast();
            }
            stack.addLast(c);
        }
        StringBuilder sb  = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}
