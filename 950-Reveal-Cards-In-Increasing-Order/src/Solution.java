import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author qybit
 * @create 2020-12-02 11:06
 */
public class Solution {

    public int[] deckRevealedIncreasing(int[] d) {
        LinkedList<Integer> ans = new LinkedList<>();
        Arrays.sort(d);
        LinkedList<Integer> q = new LinkedList<>();
        for (int x :d ) {
            q.offerLast(x);
        }
        while (!q.isEmpty()) {
            if (!ans.isEmpty()) {
                ans.offerFirst(ans.pollLast());
            }
            ans.offerFirst(q.pollLast());
        }
        int[] res = new int[d.length];
        int i  =0;
        for (Integer x : ans) {
            res[i++]  =x;
        }
        return res;
    }
}
