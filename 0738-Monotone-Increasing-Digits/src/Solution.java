/**
 * @author qybit
 * @create 2020-12-15 8:42
 * @Since 1.0.0
 */
public class Solution {

    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int len = chars.length;
        int f = len;
        for (int i = len - 1; i > 0; i--) {
            if (chars[i] < chars[i-1]) {
                f = i;
                chars[i-1]--;
            }
        }
        for (int i = f; i < len; i++) chars[i] = '9';
        return Integer.parseInt(String.valueOf(chars));
    }
}
