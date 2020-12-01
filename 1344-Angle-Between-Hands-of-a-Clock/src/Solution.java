/**
 * @author qybit
 * @create 2020-12-01 16:08
 */
public class Solution {

    public double angleClock(int hour, int minutes) {
        double c = Math.abs(minutes*6 - (hour%12*30+minutes/2.0));
        return Math.min(c, 360-c);
    }
}
