/**
 * @author qybit
 * @create 2020-12-13 20:05
 * @Since 1.0.0
 */
public class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for (char c : n.toCharArray()) res = Math.max(res, c-'0');
        return res;
    }
}
