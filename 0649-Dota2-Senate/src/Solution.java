import java.util.LinkedList;

/**
 * @author qybit
 * @create 2020-12-11 9:28
 * @Since 1.0.0
 */
public class Solution {

    public String predictPartyVictory(String senate) {
        LinkedList<Integer> radiant = new LinkedList<>();
        LinkedList<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c=='R') {
                radiant.offerLast(i);
            } else {
                dire.offerLast(i);
            }
        }
        int n = senate.length();
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.pollFirst();
            int d = dire.pollFirst();
            if (r < d) {
                // 叛变了
                radiant.offerLast(r + n);
            } else {
                dire.offerLast(d + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
