/**
 * @author qybit
 * @create 2020-11-30 14:27
 */
public class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        int idx = 0;
        ListNode cur = dummy;
        while (idx < a) {
            idx++;
            cur = cur.next;
        }
        // System.out.println(cur.val);
        ListNode c1 = cur;
        while (idx <= b) {
            idx++;
            cur = cur.next;
        }
        // System.out.println(cur.val);
        ListNode c2 = cur.next;
        ListNode c3 = list2;
        while (c3.next != null) {
            c3 = c3.next;
        }
        c3.next = c2;
        c1.next = list2;
        return list1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
