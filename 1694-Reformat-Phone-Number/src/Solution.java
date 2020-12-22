/**
 * @author qybit
 * @create 2020-12-22 20:31
 */
public class Solution {

    public String reformatNumber(String number) {
        String text = number.replace("-", "").replace(" ", "");
        int n = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            if (n - i > 4) {
                sb.append(text.substring(i, i+3)).append("-");
                i += 3;
            } else {
                int k = n - i;
                if (k == 2) sb.append(text.charAt(i)).append(text.charAt(i+1));
                else if (k == 3) sb.append(text.charAt(i)).append(text.charAt(i+1)).append(text.charAt(i+2));
                else sb.append(text.charAt(i)).append(text.charAt(i+1)).append("-").append(text.charAt(i+2)).append(text.charAt(i+3));
                break;
            }
        }
        return sb.toString();
    }
}
