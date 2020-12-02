import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-12-02 8:44
 */
public class Solution {

    public static void main(String[] args) {
        int[] a1 = {3, 4, 6, 5};
        int[] a2 = {9, 1, 2, 5, 8, 3};
        System.out.println(Arrays.toString(new Solution().maxNumber(a1, a2, 5))); // [9, 8, 6, 5, 3]
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        // 如果数组二的长度>=k 则数组1从0开始取数，数组2进行补数
        int start = Math.max(0, k - n), end = Math.min(k, m);
        int[] maxSubsequence = new int[k];
        for (int i = start; i <= end; i++) {
            int[] sequence1 = getMaxSequence(nums1, i);
            int[] sequence2 = getMaxSequence(nums2, k - i);
            int[] curSequence = merge(sequence1, 0, sequence2, 0);
            if (compare(curSequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curSequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }

    /**
     * 获得 k 个最大的子序列
     * 栈底 -> 栈顶 递减
     *
     * @param nums arr
     * @param k    数量
     * @return 数组
     */
    private int[] getMaxSequence(int[] nums, int k) {
        int[] res = new int[k];
        Deque<Integer> stack = new ArrayDeque<>();
        int remain = nums.length - k;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peekLast() < num && remain > 0) {
                stack.pollLast();
                remain--;
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

    private int[] merge(int[] sequence1, int index1, int[] sequence2, int index2) {
        if (sequence1.length == 0) {
            return sequence2;
        }
        if (sequence2.length == 0) {
            return sequence1;
        }
        int n = sequence1.length + sequence2.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (compare(sequence1, index1, sequence2, index2) > 0) {
                res[i] = sequence1[index1++];
            } else {
                res[i] = sequence2[index2++];
            }
        }
        return res;
    }

    private int compare(int[] sequence1, int index1, int[] sequence2, int index2) {
        int x = sequence1.length, y = sequence2.length;
        while (index1 < x && index2 < y) {
            int diff = sequence1[index1] - sequence2[index2];
            if (diff != 0) {
                return diff;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }
}
