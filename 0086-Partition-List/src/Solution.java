/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(-1);
        ListNode high = new ListNode(-1);
        ListNode lc = low, hc = high;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lc.next = cur;
                lc = lc.next;
            } else {
                hc.next = cur;
                hc = hc.next;
            }
            cur = cur.next;
        }
        hc.next = null;
        lc.next = high.next;
        return low.next;
    }
}