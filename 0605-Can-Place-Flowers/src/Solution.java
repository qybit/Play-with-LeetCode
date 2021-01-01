/**
 * @author qybit
 * @create 2021-01-01 13:55
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else count = 0;
            if (count == 3) {
                n--;
                count = 1;
            }
        }
        if (count == 2) n--;
        return n <= 0;
    }
}
