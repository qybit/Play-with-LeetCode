import java.util.HashSet;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-13 13:03
 * @Since 1.0.0
 */
public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> h = new HashSet<>();
        for (char c : allowed.toCharArray()) h.add(c);
        int res = 0;
        for (String word : words) {
            boolean f= true;
            for (char c : word.toCharArray()) {
                if (!h.contains(c)) {
                    f = false;
                    break;
                }
            }
            if (f) res++;
        }
        return res;
    }
}
