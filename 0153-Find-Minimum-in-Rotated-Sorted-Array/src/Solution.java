/**
 * @author qybit
 * @create 2020-12-16 11:08
 * @Since 1.0.0
 */
public class Solution {

    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.min(nums[0], nums[1]);
        int left = 0, right = nums.length;
        if (nums[0] < nums[right-1]) return nums[0];
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
