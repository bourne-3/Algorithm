package CodeTop.Normal;

/**
    codeTop 每天一道
 */
public class prac1 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        // 反转链表 三个指针
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
