/**
 * @author qybit
 * @create 2020-12-02 16:41
 */
public class Solution {

    TreeNode pre = new TreeNode(-1);

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dummy = pre;
        dfs(root);
        return dummy.right;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        pre.right = root;
        root.left = null;
        pre = pre.right;
        dfs(root.right);
    }
}
