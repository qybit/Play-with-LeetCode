import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-12-09 15:11
 * @Since 1.0.0
 */
public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        int num = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            num = 0;
            while (sz-- > 0) {
                TreeNode node = q.pollFirst();
                num += node.val;
                if (node.left != null) q.offerLast(node.left);
                if (node.right != null) q.offerLast(node.right);
            }
        }
        return num;
    }
}
