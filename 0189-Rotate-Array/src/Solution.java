class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        swap(nums, 0, n-k-1);
        swap(nums, n-k, n-1);
        swap(nums, 0, n-1);
    }

    public void swap(int[] nums, int i, int j) {
        int l = i, r = j;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}