import java.util.LinkedList;

/**
 * @author qybit
 * @create 2020-12-02 15:59
 */
public class Solution {


    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int cnt = 0;
            while (sz-- > 0) {
                TreeNode node = q.pollFirst();
                if (node != null) {
                    if (node.val == x || node.val == y) {
                        cnt++;
                    }
                    if (node.left != null) {
                        if (node.right != null && (node.left.val == x && node.right.val == y || node.left.val == y
                                && node.right.val == x)) {
                            return false;
                        }
                        q.offerLast(node.left);
                    }
                    if (node.right != null) {
                        q.offerLast(node.right);
                    }
                }
            }
            if (cnt == 1) {
                return false;
            } else if (cnt == 2) {
                return true;
            }
        }
        return true;
    }

}

