/**
 * @author qybit
 * @create 2020-12-18 15:27
 * @Since 1.0.0
 */
public class Solution {

    int res = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            around(s, i, i);
            around(s, i, i + 1);
        }
        return res;
    }

    public void around(String s, int i, int j) {
        int left = i, right = j;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }
    }
}
