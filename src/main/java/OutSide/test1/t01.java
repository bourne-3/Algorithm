package OutSide.test1;

import java.util.*;


/**
 num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
 例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中


 这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中
 **/

/**

 */
public class t01 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
//        ListNode n3 = new ListNode(2);
//        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
        boolean res = isPalindrome2(n1);
        System.out.println(res);
    }

    public static boolean isPalindrome2(ListNode head) {
        // 快慢指针，找到中间节点，将前面的反转
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverseList(slow.next);


        while (slow != null){
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }

        return true;
    }
    
    static ListNode reverseList(ListNode head){
        // 反转链表
        ListNode cur = head, pre = null, next = null;
        while (cur !=null){
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
        StringBuilder path = new StringBuilder();
        while (head !=  null){
            path.append(head.val);
        }
        String s = path.toString();
        // 判断s是否为回文串
        int i = 0, j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;

    }


    public static int mySqrt(int x) {
        if (x == 1) return x;
        int max = x, min = 0; // 左闭右闭上
        while (max - min > 1) {
            int middle = min + (max - min) / 2;
            if (middle > x / middle) max = middle;
            else min = middle;
        }
        return min;
    }


    private void heapSort(int[] nums){
        int size = nums.length;
        // 找到第一个非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--){
            adjust(nums, i, size);
        }

        for (int i = size - 1; i >= 1; i--){
            swap(nums, 0, i); // 最后一个节点
            adjust(nums, 0, i);  // 这里又有点迷糊
        }
    }

    private void adjust(int[] nums, int vertexIdx, int size) {
        int left = vertexIdx * 2 + 1;
        int right = vertexIdx * 2 + 2;
        int maxIdx = vertexIdx;
        if (left < size && nums[left] > nums[maxIdx]) maxIdx = left;
        if (right < size && nums[right] > nums[maxIdx]) maxIdx = right;

        if (maxIdx != vertexIdx){
            swap(nums, maxIdx, vertexIdx);
            adjust(nums, maxIdx, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] =tmp;
    }


    public static int change(int amount, int[] coins) {
        // 外层是物品， 内层是背包
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin:coins){
            for (int i = 0; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
