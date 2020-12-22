import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-12-22 20:34
 */
public class Solution {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] f = new int[n];
        f[0] = nums[0];
        q.addLast(0);
        for (int i = 1; i < n; i++) {
            while (q.peekFirst() < i - k) q.pollFirst();
            f[i] = f[q.peekFirst()] + nums[i];
            while (!q.isEmpty() && f[q.peekLast()] <= f[i]) q.pollLast();
            q.addLast(i);
        }
        return f[n-1];
    }
}
