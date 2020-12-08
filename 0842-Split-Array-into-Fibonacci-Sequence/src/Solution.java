import java.util.ArrayList;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-08 8:36
 * @Since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.splitIntoFibonacci("123456579"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S, 0, res);
        return res;
    }

    private boolean dfs(String s, int index, List<Integer> res) {
        if (index == s.length()) return res.size() > 2;
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if ((i > index + 1 && sub.charAt(0) == '0') || Long.parseLong(sub) > Integer.MAX_VALUE) break;
            int n = res.size();
            int num = Integer.parseInt(sub);
            int one = n >= 2 ? res.get(n - 2) : -1;
            int two = n >= 2 ? res.get(n - 1) : -1;
            res.add(num);
            if ((one == -1 || two == -1 || one + two == num) && dfs(s, i, res)) {
                return true;
            }
            res.remove(res.size() - 1);
        }
        return false;
    }
}
