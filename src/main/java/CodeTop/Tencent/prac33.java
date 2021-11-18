package CodeTop.Tencent;

/**

 */
public class prac33 {

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode slow = dump, fast = dump;

        while (k-- > 0) fast = fast.next;
        fast = fast.next;

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }
}
