import java.util.ArrayList;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-02 17:11
 */
public class Solution {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode ans = new TreeNode(-1);
        TreeNode cur = ans;
        for (Integer x : list) {
            cur.right = new TreeNode(x);
            cur = cur.right;
        }
        return ans.right;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
