/**
 * @author qybit
 * @create 2020-12-30 9:28
 */
public class Solution {

    public int maxVowels(String s, int k) {
        int left = 0, right = 0;
        int count = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o') count++;
            if (right - left >= k) {
                res = Math.max(res, count);
                char lc = s.charAt(left++);
                if (lc == 'a' || lc == 'e' || lc == 'i' || lc == 'u' || lc == 'o') count--;
            }
        }
        return res;
    }
}
