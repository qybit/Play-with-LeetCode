/**
 * @author qybit
 * @create 2020-12-23 8:45
 */
public class Solution {

    public int firstUniqChar(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (f[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
