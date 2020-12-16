/**
 * @author qybit
 * @create 2020-12-16 14:59
 * @Since 1.0.0
 */
public class Solution {


    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) return -1;
        if (root.val > val) return root.val;

        int l = dfs(root.left, val);
        int r = dfs(root.right, val);
        if (l >= 0 && r >= 0) {
            return Math.min(l, r);
        }
        return Math.max(l, r);
    }

}
