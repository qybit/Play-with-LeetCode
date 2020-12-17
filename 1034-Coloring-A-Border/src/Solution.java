/**
 * @author qybit
 * @create 2020-12-17 9:22
 * @Since 1.0.0
 */
public class Solution {


    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0, grid[r0][c0], color, vis);
        return grid;
    }

    private int dfs(int[][] grid, int x, int y, int preColor, int color, boolean[][] vis) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || (!vis[x][y] && grid[x][y] != preColor))
            return 0;
        if (vis[x][y]) return 1;
        vis[x][y] = true;
        int res = dfs(grid, x + 1, y, preColor, color, vis) +
                dfs(grid, x - 1, y, preColor, color, vis) +
                dfs(grid, x, y + 1, preColor, color, vis) +
                dfs(grid, x, y - 1, preColor, color, vis);
        if (res < 4)
            grid[x][y] = color;
        return 1;
    }
}
