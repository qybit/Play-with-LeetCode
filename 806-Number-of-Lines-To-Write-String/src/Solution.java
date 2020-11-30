/**
 * @author qybit
 * @create 2020-11-30 17:00
 */
public class Solution {

    public int[] numberOfLines(int[] widths, String S) {
        // 100个单位一行，每个字母的占位符，有widths数组给出
        // 计算占用多少个完整的行，如果不够就另起一行
        int total = 0, row = 1;
        for (char c : S.toCharArray()) {
            total += widths[c - 'a'];
            if (total == 100) {
                row++;
                total = 0;
            } else if (total > 100) {
                row++;
                total = widths[c - 'a'];
            }
        }
        return new int[]{row, total};
    }
}
