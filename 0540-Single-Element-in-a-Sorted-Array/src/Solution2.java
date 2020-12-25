/**
 * @author qybit
 * @create 2020-12-25 14:57
 */
public class Solution2 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 右半部分为偶数
            boolean halfAreEven = (right - mid) % 2 == 0;
            if (nums[mid - 1] == nums[mid]) {
                if (halfAreEven) {
                    right = mid - 2;
                } else left = mid + 1;
            } else if (nums[mid + 1] == nums[mid]) {
                if (halfAreEven) {
                    left = mid + 2;
                } else right = mid - 1;
            } else return nums[mid];
        }
        return nums[left];
    }
}
