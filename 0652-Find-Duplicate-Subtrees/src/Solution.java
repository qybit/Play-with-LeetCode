import java.util.*;

/**
 * @author qybit
 * @create 2020-12-19 17:41
 * @Since 1.0.0
 */
public class Solution {

    List<TreeNode> res=  new ArrayList<>();
    Map<String, Integer> hash =  new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root) {
        if (root == null) return "#";
        String r = root.val + "#" + dfs(root.left) + "#" + dfs(root.right);
        if (hash.containsKey(r) && hash.get(r) == 1) res.add(root);
        hash.put(r, hash.getOrDefault(r, 0) + 1);
        return r;
    }

}
