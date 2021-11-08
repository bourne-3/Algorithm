package CodePoint;

/**
 两个链表的第一个公共节点

 */
public class prac47 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        int len1 = 0, len2 = 0;
        while (cur1 != null){
            len1 += 1;
            cur1 = cur2.next;
        }
        while (cur2 != null){
            len2 += 1;
            cur2 = cur2.next;
        }

        cur1 = headA;
        cur2 = headB;

        // 让cur1保持是最大的
        if (len2 > len1){
            int tmpLen = len1;
            len1 = len2;
            len2 = tmpLen;

            ListNode tmpNode = cur1;
            cur1 = cur2;
            cur2 = cur1;
        }

        int diff = len1 - len2;
        while (diff > 0){
            diff--;
            cur1 = cur1.next;
        }

        while (cur1 != null && cur2 != null){
            if (cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
