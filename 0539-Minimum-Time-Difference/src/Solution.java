import java.util.Arrays;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-02 10:33
 */
public class Solution {

    public int findMinDifference(List<String> timePoints) {
        // 转化成分钟数，要注意首尾的时差
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] time = timePoints.get(i).split(":");
            arr[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            res = Math.min(res, arr[i] - arr[i - 1]);
        }
        return Math.min(res, arr[0] + 1440 - arr[arr.length - 1]);
    }
}
