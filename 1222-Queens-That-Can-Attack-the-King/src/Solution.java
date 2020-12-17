import java.util.*;

/**
 * @author qybit
 * @create 2020-12-17 10:23
 * @Since 1.0.0
 */
public class Solution {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int x = king[0], y = king[1];
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int[] q : queens)
            set.add(q[0] + "" + q[1]);
        // 向下
        for (int j = x; j < 8; j++) {
            if (set.contains(j + "" + y)) {
                res.add(Arrays.asList(j, y));
                break;
            }
        }
        // 向上
        for (int i = x; i >= 0; i--) {
            if (set.contains(i + "" + y)) {
                res.add(Arrays.asList(i, y));
                break;
            }
        }
        // 左
        for (int i = y; i >= 0; i--) {
            if (set.contains(x + "" + i)) {
                res.add(Arrays.asList(x, i));
                break;
            }
        }
        // 右
        for (int i = y; i < 8; i++) {
            if (set.contains(x + "" + i)) {
                res.add(Arrays.asList(x, i));
                break;
            }
        }
        // 斜着
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (set.contains(i + "" + j)) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
        for (int i = x, j = y; i >= 0 && j < 8; i--, j++) {
            if (set.contains(i + "" + j)) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
        for (int i = x, j = y; i < 8 && j >= 0; i++, j--) {
            if (set.contains(i + "" + j)) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
        for (int i = x, j = y; i < 8 && j < 8; i++, j++) {
            if (set.contains(i + "" + j)) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
        return res;
    }
}
