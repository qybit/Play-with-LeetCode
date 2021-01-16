/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        double pre = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            if (pre >= root.val) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }

}