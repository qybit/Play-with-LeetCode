import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-07 9:10
 * @Since 1.0.0
 */
public class Solution {

    public int matrixScore(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        for (int i = 0; i < m; i++) {
            if (arr[i][0] != 1) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] ^= 1;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            int t = 0;
            for (int i = 0; i < m; i++) {
                if (arr[i][j] == 1) t++;
            }
            if (t < (m + 1 >> 1)) {
                for (int i = 0; i < m; i++) {
                    arr[i][j] ^= 1;
                }
            }
        }
        for (int[] ar : arr) System.out.println(Arrays.toString(ar));
        long res = 0;
        // 计算结果
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            res += Integer.parseInt(sb.toString(), 2);
        }
        return (int) res;
    }
}
