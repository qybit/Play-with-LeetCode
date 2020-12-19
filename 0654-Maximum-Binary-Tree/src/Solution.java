import java.util.PriorityQueue;

/**
 * @author qybit
 * @create 2020-12-19 19:25
 * @Since 1.0.0
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        int bound = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[bound]);
        root.left = buildTree(nums, l, bound - 1);
        root.right = buildTree(nums, bound + 1, r);
        return root;
    }

    private int findMax(int[] nums, int l, int r) {
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[idx] <= nums[i]) {
                idx = i;
            }
        }
        return idx;
    }
}
