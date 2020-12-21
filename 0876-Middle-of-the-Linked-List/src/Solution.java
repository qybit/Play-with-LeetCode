/**
 * @author qybit
 * @create 2020-12-21 9:25
 * @Since 1.0.0
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
