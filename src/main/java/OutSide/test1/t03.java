package OutSide.test1;

/**

 */
public class t03 {

    public static void main(String[] args) {
//        maxProduct(new int[]{-2, 3, -4});
        maxProduct(new int[]{2, 3, -2, 4});
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        int len1 = 0, len2 = 0;
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }

        cur1 = headA;
        cur2 = headB;

        if (len1 < len2){
            int lenTmp = len1;
            len1 = len2;
            len2 = lenTmp;

            ListNode nodeTmp = cur1;
            cur1 = cur2;
            cur2 = nodeTmp;
        }

        int diff = len1 - len2;
        while (diff > 0){
            cur1 = cur1.next;
            diff--;
        }

        while (cur1 != null){
            if (cur1 == cur2) return cur1;
        }
        return null;

    }

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, maxVal = 1, minVal = 1;
        for (int n : nums) {
            if (n < 0) {
                // 当n比负数的时候，最大值就变成了最小值
                int tmp = maxVal;
                maxVal = minVal;
                minVal = tmp;
            }

            maxVal = Math.max(maxVal * n, maxVal);
            minVal = Math.min(minVal * n, minVal);

            res = Math.max(res, maxVal);
        }
        return res;
    }

    public ListNode sortList(ListNode head) {
        // 递归结束条件
        if (head == null || head.next == null) return head;

        ListNode middle = findMid(head);
        ListNode nextStrt = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextStrt);

        return mergeTwoList(left, right);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return dump.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        // 发现这个判断的条件在链表很好用
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
