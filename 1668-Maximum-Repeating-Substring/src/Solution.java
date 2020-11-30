/**
 * @author qybit
 * @create 2020-11-30 10:54
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxRepeating("ababc", "ab"));
    }

    public int maxRepeating(String sequence, String word) {
        int k = 0;
        StringBuilder s = new StringBuilder(word);
        while (sequence.contains(s.toString())) {
            k++;
            s.append(word);
        }
        return k;
    }
}
