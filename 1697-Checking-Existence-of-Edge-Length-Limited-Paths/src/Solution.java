import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int[] fm;

    public int findHead(int node) {
        int fa = fm[node];
        if (fa != node) fa = findHead(fa);
        fm[node] = fa;
        return fa;
    }

    public void union(int a, int b) {
        fm[findHead(b)] = fm[findHead(a)];
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        fm = new int[n];
        for (int i = 0; i < n; i++) fm[i] = i;
        boolean[] ret = new boolean[queries.length];
        int index = 0;
        Integer[] h = new Integer[queries.length];
        for (int i = 0; i < h.length; i++) h[i] = i;
        Arrays.sort(h, Comparator.comparingInt(o -> queries[o][2]));
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
        for (Integer i : h) {
            while (index < edgeList.length && edgeList[index][2] < queries[i][2]) {
                union(edgeList[index][0], edgeList[index][1]);
                index++;
            }
            ret[i] = findHead(queries[i][0]) == findHead(queries[i][1]);
        }
        return ret;
    }
}