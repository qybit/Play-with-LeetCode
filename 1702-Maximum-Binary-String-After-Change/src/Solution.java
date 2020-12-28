import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-28 15:54
 */
public class Solution {

    public String maximumBinaryString(String s) {
        int k = 0, n = s.length();
        while (k < n && s.charAt(k) == '1') k++;
        if (k == n) return s;
        int cnt = 0;
        for (int i = k + 1; i < n; i++) if (s.charAt(i) == '0') cnt++;
        char[] res = new char[n];
        Arrays.fill(res, '1');
        res[k + cnt] = '0';
        return String.valueOf(res);
    }
}
