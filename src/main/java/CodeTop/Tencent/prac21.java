package CodeTop.Tencent;

/**
    回文链表   从第三页开始
 */
public class prac21 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        prac21 t = new prac21();
        boolean flag= t.isPalindrome(n1);
        System.out.println(flag);

    }

    public boolean isPalindrome(ListNode head) {
        // 找到链表的中点 然后反转后面的
        ListNode fast = head.next, slow = head;;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverse(slow.next);

        ListNode tmp = slow.next;
        while (head != null && tmp != null){
            if (head.val != tmp.val) return false;
            head = head.next;
            tmp = tmp.next;
        }
        return true;

    }
    ListNode reverse(ListNode head){
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
