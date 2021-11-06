package CodePoint;

/**
 链表中倒数第k个节点
 */
public class prac27 {

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        while (k > 0){
            cur = cur.next;
            k--;
        }
        while (cur != null){
            head = head.next;
            cur = cur.next;
        }
        return head;
    }
}
