import java.util.LinkedList;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-22 10:07
 * @Since 1.0.0
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.offerLast(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (sz-- > 0) {
                TreeNode node = q.pollFirst();
                if (depth % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }

                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
            }
            res.add(list);
            depth++;
        }
        return res;
    }
}
