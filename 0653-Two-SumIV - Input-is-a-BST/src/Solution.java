import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-19 19:13
 * @Since 1.0.0
 */
public class Solution {

    Set<Integer> set = new HashSet<>();
    boolean f = false;
    public boolean findTarget(TreeNode root, int k) {
        dfs(root, k);
        return f;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;
        if (set.contains(k-root.val)) {
            f = true;
            return;
        }
        set.add(root.val);
        dfs(root.left, k);
        dfs(root.right, k);
    }
}
