class Solution {
    public boolean checkStraightLine(int[][] co) {
        int x1 = co[0][0];
        int y1 = co[0][1];
        int x2 = co[1][0];
        int y2 = co[1][1];
        for (int i = 0; i < co.length; i++) {
            int x = co[i][0];
            int y = co[i][1];
            if ((x-x2)*(y1-y2) != (y-y2)*(x1-x2)) return false;
        }
        return true;
    }
}