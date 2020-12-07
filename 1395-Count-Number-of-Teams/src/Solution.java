/**
 * @author qybit
 * @create 2020-12-07 14:48
 * @Since 1.0.0
 */
public class Solution {

    public int numTeams(int[] rating) {
        int res= 0 ;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i+1; j < rating.length; j++) {
                for (int k = j+1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]
                    || rating[i] > rating[j] && rating[j] > rating[k]) res++;
                }
            }
        }
        return res;
    }
}
