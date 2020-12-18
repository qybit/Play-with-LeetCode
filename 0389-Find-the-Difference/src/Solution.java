/**
 * @author qybit
 * @create 2020-12-18 8:48
 * @Since 1.0.0
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int [] f = new int[26];
        for (char c:  s.toCharArray()) f[c-'a']++;
        for (char c : t.toCharArray())
        {
            f[c-'a']--;
            if (f[c-'a'] < 0) return c;
        }
        return ' ';
    }
}
