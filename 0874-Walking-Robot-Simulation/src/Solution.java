import java.util.HashSet;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-25 9:49
 */
public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int curDir = 0, x = 0, y = 0;
        int tx, ty;
        int res = 0;
        for (int command : commands) {
            if (command > 0) {
                for (int i = 0; i < command; i++) {
                    tx = x + dx[curDir];
                    ty = y + dy[curDir];
                    if (set.contains(tx + "," + ty)) break;
                    x = tx;
                    y = ty;
                    res = Math.max(res, x * x + y * y);
                }
            } else {
                curDir = command == -1 ? (curDir + 1) % 4 : (curDir + 3) % 4;
            }
        }
        return res;
    }
}
