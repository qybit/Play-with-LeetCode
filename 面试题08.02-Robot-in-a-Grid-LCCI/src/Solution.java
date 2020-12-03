import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-03 10:40
 */

public class Solution {
    int[] dx = {1, 0};
    int[] dy = {0, 1};
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        List<List<Integer>> res = new ArrayList<>();

        dfs(obstacleGrid, 0, 0, m, n, res);
        return res;
    }

    private boolean dfs(int[][] obstacleGrid, int i, int j, int m, int n, List<List<Integer>> res) {

        if (i < 0 || i >= m || j < 0 || j >= n || obstacleGrid[i][j] == 1) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            res.add(Arrays.asList(i, j));
            return true;
        }
        res.add(Arrays.asList(i, j));
        obstacleGrid[i][j] = 1;
        for (int k = 0; k < 2; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (dfs(obstacleGrid, x, y, m,n,res)) {
                return true;
            }
        }
        res.remove(res.size() -1);
        return false;
    }
}
