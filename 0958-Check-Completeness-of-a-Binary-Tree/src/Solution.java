import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author qybit
 * @create 2020-12-02 10:06
 */
public class Solution {

    public boolean isCompleteTree(TreeNode root) {
        //BFS遇到空节点时，退出循环。检查右子树是否为空，如果为空，说明不完全。否则说明二叉树是完全的。
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        TreeNode cur = root;
        while ((cur = q.pollFirst()) != null) {
            q.offerLast(cur.left);
            q.offerLast(cur.right);
        }
        while (!q.isEmpty()) {
            if (q.pollLast() != null) {
                return false;
            }
        }
        return true;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}