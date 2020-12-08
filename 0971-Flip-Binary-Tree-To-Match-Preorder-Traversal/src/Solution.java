import java.lang.reflect.Array;
import java.util.*;

/**
 * @author qybit
 * @create 2020-12-01 9:02
 */
public class Solution {

    List<Integer> res = new ArrayList<>();
    boolean f = false;
    int idx = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, voyage);
        if (f) {
            return Collections.singletonList(-1);
        }
        return res;
    }

    private void dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return;
        }
        if (root.val != voyage[idx++]) {
            f = true;
            return;
        }
        if (idx < voyage.length && root.left != null && root.left.val != voyage[idx]) {
            res.add(root.val);
            dfs(root.right, voyage);
            dfs(root.left, voyage);
        } else {
            dfs(root.left, voyage);
            dfs(root.right, voyage);
        }

    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }