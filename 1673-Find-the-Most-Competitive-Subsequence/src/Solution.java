import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-11-30 15:48
 */
public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        Deque<Integer> stack = new ArrayDeque<>();
        int a = nums.length - k;
        for (int num : nums) {
            while (!stack.isEmpty() && a > 0 && stack.peekLast() > num) {
                stack.pollLast();
                a--;
            }
            stack.offerLast(num);
        }
        while (stack.size() > k) {
            stack.pollLast();
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pollLast();
        }
        return res;
    }
}
