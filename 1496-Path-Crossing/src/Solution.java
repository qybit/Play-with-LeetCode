import java.util.HashSet;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-06 16:59
 * @Since 1.0.0
 */
public class Solution {

    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> set =new HashSet<>();
        set.add("00");
        for (char c: path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c== 'W'){
                x--;
            }
            String t = String.valueOf(x) + String.valueOf(y);
            if (set.contains(t)) {
                return true;
            }
            set.add(t);
        }
        return false;
    }
}
