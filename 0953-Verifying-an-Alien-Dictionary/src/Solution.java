/**
 * @author qybit
 * @create 2020-12-15 9:58
 * @Since 1.0.0
 */
public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        int[] f = new int[26];
        for (int i = 0; i < order.length(); i++) {
            f[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!isOk(words[i - 1], words[i], f)) return false;
        }
        return true;
    }

    private boolean isOk(String s1, String s2, int[] hash) {
        int i = 0, j = 0;
        int m = s1.length(), n = s2.length();
        while (i < m || j < n) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                return hash[c1 - 'a'] < hash[c2 - 'a'];

            }
            if (i == m && j < n) return true;
            if (j == n && i < m) return false;
        }
        return true;
    }
}
