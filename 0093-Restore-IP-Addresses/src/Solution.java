import java.util.ArrayList;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-08 9:01
 * @Since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        Solution s= new Solution();
        s.restoreIpAddresses("0000");
    }

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new ArrayList<String>());
        return res;
    }

    private void dfs(String s, int index, List<String> list) {
        if (list.size() > 4) return;
        if (index == s.length() && list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String ss : list) {
                sb.append(ss).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            int n = sub.length();
            if ((n > 1 && sub.charAt(0) == '0') || Integer.parseInt(sub) > 255) break;
            list.add(sub);
            dfs(s, i, list);
            list.remove(list.size()-1);
        }
    }
}
