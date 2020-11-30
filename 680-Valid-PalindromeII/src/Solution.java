/**
 * @author qybit
 * @create 2020-11-30 17:03
 */
public class Solution {

    public boolean validPalindrome(String s) {
        // 假删除，遇到第一个不相等的字符，左右各退一个，进行验证
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return isValid(s, i + 1, n - 1 - i) || isValid(s, i, n - 2 - i);
            }
        }
        return true;
    }

    private boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
