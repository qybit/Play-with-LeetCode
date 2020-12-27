/**
 * @author qybit
 * @create 2020-12-27 11:16
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        return isPossible(s, t) && isPossible(t, s);
    }

    // s -> t
    public boolean isPossible(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (f[c1] != 0 && f[c1] != c2 - '0') return false;
            f[c1] = c2 - '0';
        }
        return true;
    }
}
