
/**
 * @author qybit
 * @create 2020-12-07 14:54
 * @Since 1.0.0
 */
public class Solution {

    int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if ((root.val & 1) == 0) {
            add(root);
        }
        dfs(root.left);
        dfs(root.right);
    }

    private void add(TreeNode node) {
        if (node.left != null) {
            if (node.left.left != null) {
                res += node.left.left.val;
            }
            if (node.left.right != null) {
                res += node.left.right.val;
            }
        }

        if (node.right != null) {
            if (node.right.left != null) {
                res += node.right.left.val;
            }
            if (node.right.right != null) {
                res += node.right.right.val;
            }
        }
    }
}
