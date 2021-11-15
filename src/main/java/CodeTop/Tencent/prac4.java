package CodeTop.Tencent;

/**

 */
public class prac4 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        // 反转链表
        ListNode cur = head, pre = null, next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
}
