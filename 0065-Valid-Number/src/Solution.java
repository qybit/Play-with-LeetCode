/**
 * @author qybit
 * @create 2020-12-31 15:56
 */
public class Solution {

    public boolean isNumber(String s) {
        if (s==null || s.length() == 0) return false;
        s = s.trim();
        if (s.length() == 0) return false;
        int n = s.length();
        boolean eFlag = false;
        boolean dotFlag = false;
        boolean numFlag = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ((c == '+' || c == '-') && (i == 0 || s.charAt(i-1) == 'e')) continue;
            else if (c == 'e' && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;
            } else if (c == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            } else if (Character.isDigit(c)) numFlag= true;
            else return false;
        }
        return numFlag;
    }
}
