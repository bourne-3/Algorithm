package OutSide.test1;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**

 */
public class t02 {

    public static void main(String[] args) {
        multiply("12", "11");
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];
        while (fast != slow){
            // 慢指针走一步
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 找出交叉点 有环，但一定是入口
        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }


    public ListNode swapPairs(ListNode head) {
        // 两两交换链表中的节点
        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode tmp, pre = dump;

        while (pre.next != null && pre.next.next != null){
            tmp = head.next.next;
            // 三步
            pre.next = head.next;
            pre.next.next = head;
            head.next = tmp;

            // 移动指针
            pre = head;
            head = tmp;
        }
        return dump.next;
    }


    public static String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if (n1 < 0 || n2 < 0) return "";
        int[] mul = new int[n1 + n2 + 2];
        for (int i = n1; i >= 0; i--){
            for (int j = n2; j >= 0; j--){
                // 从后面到前面
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // [i + j,  i + j + 1]  // 放到这个位置上
                // 如果这个位置上有数字就累加，因此用+=
                bitmul += mul[i + j + 1];

                // 放到数组中，上面还没放到数组中
                mul[i + j] += bitmul / 10;
                // 注意这里是=
                mul[i + j + 1] = bitmul % 10;
            }
        }
        // 去掉0开头
        StringBuilder path = new StringBuilder();
        int i = 0;
        while (i < mul.length - 1 && mul[i] == 0) i++;
        for (; i < mul.length; i++){
            path.append(mul[i]);
        }
        return path.toString();
    }
}
