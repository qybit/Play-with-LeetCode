import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-15 10:45
 * @Since 1.0.0
 */
public class Solution {
    public int missingNumber(int[] nums) {
        return nums.length*(nums.length+1)/2 - Arrays.stream(nums).sum();
    }
}
