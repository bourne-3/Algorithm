package CodeTop.Tencent;

/**

 */
public class prac15 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 求差值
        int len1 = 0, len2 = 0;
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != null) {
            cur1 = cur1.next;
            len1++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            len2++;
        }
        cur1 = headA;
        cur2 = headB;
        if (len1 < len2) {
            int tmpLen = len1;
            len1 = len2;
            len2 = tmpLen;

            ListNode tmpNode = cur1;
            cur1 = cur2;
            cur2 = tmpNode;
        }

        int diff = len1 - len2;
        while (diff > 0) {
            cur1 = cur1.next;
            diff--;
        }


        // 再一起走
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
