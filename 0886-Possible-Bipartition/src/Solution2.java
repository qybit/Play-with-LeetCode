import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qybit
 * @create 2020-12-04 10:23
 */
public class Solution2 {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] colors;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        colors = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int index, int color) {
        colors[index] = color;
        for (Integer ne : graph.get(index)) {
            if (colors[ne] == color) return false;
            if (colors[ne] == 0 && !dfs(ne, -color)) return false;
        }
        return true;
    }
}
