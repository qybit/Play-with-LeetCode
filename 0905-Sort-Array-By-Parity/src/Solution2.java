/**
 * @author qybit
 * @create 2020-12-09 14:40
 * @Since 1.0.0
 */
public class Solution2 {

    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            if ((A[left] & 1) == 1 && (A[right] & 1) == 0) {
                int t = A[left];
                A[left] = A[right];
                A[right] = t;
            } else if ((A[left]&1)==0) {
                left++;
            } else if ((A[right]&1)==1){
                right--;
            }
        }
        return A;
    }
}
