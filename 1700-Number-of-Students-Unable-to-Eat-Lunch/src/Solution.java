import java.util.LinkedList;

/**
 * @author qybit
 * @create 2020-12-28 10:25
 */
public class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int n : sandwiches) stack.addFirst(n);
        LinkedList<Integer> q = new LinkedList<>();
        for (int x : students) q.addLast(x);
        int f = 0;
        while (true) {
            if (!q.peekFirst().equals(stack.peekLast())) {
                q.addLast(q.pollFirst());
                f++;
            } else {
                f = 0;
                q.pollFirst();
                stack.pollLast();
                if (q.isEmpty() && stack.isEmpty()) return 0;
            }
            if (f == q.size()) break;
        }
        return q.size();
    }
}
