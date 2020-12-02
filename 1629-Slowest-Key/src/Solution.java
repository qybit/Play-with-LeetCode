import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qybit
 * @create 2020-12-02 16:51
 */
public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int mx = releaseTimes[0];
        char c = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int dif = releaseTimes[i] - releaseTimes[i-1];
            if (dif > mx) {
                c = keysPressed.charAt(i);
                mx = dif;
            } else if (dif == mx && c < keysPressed.charAt(i)) {
                c = keysPressed.charAt(i);
            }
        }
        return c;
    }

    /*
     * 草 看错题了
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                map.put(keysPressed.charAt(i), releaseTimes[i]);
            }
            if (i > 0) {
                map.put(keysPressed.charAt(i), releaseTimes[i]-releaseTimes[i-1]);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (Integer.compare(o1.getValue(), o2.getValue()) == 0) {
                return Character.compare(o1.getKey(), o2.getKey());
            }
            return Integer.compare(o1.getValue(), o2.getValue());
        });
        char res=' ';
        int mx = 0;
        for (Map.Entry<Character, Integer> entry : list) {
            if (mx < entry.getValue()) {
                res = entry.getKey();
                mx = entry.getValue();
            }
        }
        return res;
    }

     */
}
