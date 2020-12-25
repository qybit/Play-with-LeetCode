import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-25 9:29
 */
public class Solution {

    public int minMutation(String start, String end, String[] b) {
        if (b.length == 0) return -1;
        char[] required = {'A', 'G', 'C', 'T'};
        Set<String> bank = new HashSet<>(Arrays.asList(b));
        if (!bank.contains(end)) return -1;
        Set<String> has = new HashSet<>();
        LinkedList<String> q = new LinkedList<>();
        q.addLast(start);
        has.add(start);
        int res = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                String s = q.pollFirst();
                if (s != null) {
                    char[] array = s.toCharArray();
                    for (int i = 0; i < array.length; i++) {
                        char c = array[i];
                        for (char k : required) {
                            array[i] = k;
                            String g = String.valueOf(array);
                            if (g.equals(end)) return res;
                            if (has.contains(g)) {
                                continue;
                            }
                            if (bank.contains(g)) {
                                q.add(g);
                            }
                            has.add(g);
                        }
                        array[i] = c;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
