package OutSide.test1;

/**

 */
public class t05 {

    public static void main(String[] args) {
        String res = addStrings("10000", "21");
        System.out.println(res);
    }

    public static String addStrings(String num1, String num2) {
        // 两个字符串相加
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        StringBuilder path = new StringBuilder();
        while (m >= 0 || n >= 0){
            int c1 = m >= 0 ? num1.charAt(m--) - '0' : 0;
            int c2 = n >= 0 ? num2.charAt(n--) - '0' : 0;
            int tmp = c1 + c2 + carry;
            carry = tmp / 10;

            path.append(tmp % 10);
        }
        // 收尾carray
        if (carry != 0) path.append(carry);

        return path.reverse().toString();
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 合并两个有序链表
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // 收尾
        cur.next = l1 != null ? l1:l2;

        return dump.next;
    }
}
