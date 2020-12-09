/**
 * @author qybit
 * @create 2020-12-09 14:33
 * @Since 1.0.0
 */
public class Solution1 {

    public int[] sortArrayByParity(int[] arr) {
        int[] res = new int[arr.length];
        int left = 0, right = arr.length - 1;
        for (int j : arr) {
            if ((j & 1) == 0) {
                res[left++] = j;
            } else {
                res[right--] = j;
            }
        }
        return res;
    }
}
