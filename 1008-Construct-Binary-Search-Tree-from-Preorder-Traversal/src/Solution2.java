/**
 * @author qybit
 * @create 2020-12-07 10:38
 * @Since 1.0.0
 */
public class Solution2 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = addNode(root, preorder[i]);
        }
        return root;
    }

    public TreeNode addNode(TreeNode node, int num) {
        if (node == null) {
            return new TreeNode(num);
        }
        if (node.val > num) {
            node.left = addNode(node.left, num);
        } else {
            node.right = addNode(node.right, num);
        }
        return node;
    }
}
