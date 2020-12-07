import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-12-07 10:23
 * @Since 1.0.0
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {8, 5, 1, 7, 10, 12};
        s.bstFromPreorder(arr);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode res = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        int pre = root.val;
        for (int i = 1; i < preorder.length; i++) {
            if (pre > preorder[i]) {
                root.left = new TreeNode(preorder[i]);
                stack.addLast(root.left);
                root = root.left;
            } else {
                while (!stack.isEmpty() && stack.peekLast().val < preorder[i]) root = stack.pollLast();
                root.right = new TreeNode(preorder[i]);
                stack.addLast(root.right);
                root = root.right;
            }

            pre = preorder[i];
        }
        return res;
    }
}
