import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-13 20:19
 * @Since 1.0.0
 */
public class Solution {

    public int maxHeight(int[][] cuboids) {
        for (int[] x : cuboids) {
            Arrays.sort(x);
        }
        Arrays.sort(cuboids, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        }));
        for (int[] ints : cuboids) {
            System.out.println(Arrays.toString(ints));
        }
        int n = cuboids.length;
        int[] f = new int[n];
        int res = 0 ;
        for (int i = 0; i < n; i++) {
            f[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] >= cuboids[i][0] && cuboids[j][1] >= cuboids[i][1]
                && cuboids[j][2] >= cuboids[i][2]) {
                    f[i] = Math.max(f[i], f[j] + cuboids[i][2]);
                }
            }
            res = Math.max(f[i], res);
        }
        return res;
    }
}
