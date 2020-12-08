import java.util.ArrayList;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-08 10:34
 * @Since 1.0.0
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int l = 1, r = 1, sum = 0; r < target; ) {
            sum += r++;
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target) {
                int[] arr = new int[r - l];
                int j = 0;
                for (int i = l; i < r; i++) {
                    arr[j++] = i;
                }
                list.add(arr);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
