/**
 * @author qybit
 * @create 2020-12-01 17:14
 */
public class Solution {

    public int brokenCalc(int X, int Y) {
        // 逆向思维，从Y逼近X
        // 如果Y为偶数。一次操作 / 2 操作数+1
        // 如果Y 为奇数，先加1，然后整除  操作数+2
        int res = 0;
        while (X < Y) {
            if (Y % 2 == 0) {
                Y /= 2;
                res++;
            } else {
                Y = (Y + 1) / 2;
                res += 2;
            }
        }
        // 如果X >Y 操作数 X-Y 即可
        return res + X - Y;
    }
}
