/**
 * @author qybit
 * @create 2021-01-01 14:04
 */
public class Solution {

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }


    public boolean dfs(TreeNode root, int val) {
        if (root != null) {
            if (root.val != val) return false;
            return dfs(root.left, root.val) && dfs(root.right, root.val);
        }
        return true;
    }
}
