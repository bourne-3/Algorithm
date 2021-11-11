package OutSide.test1;

import java.util.*;

/**

 */
public class t02 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                // 有环

                // fast回到开头
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 完全背包问题
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public int singleNumber(int[] nums) {
        int z = 0;
        for (int n : nums) {
            z ^= n;  // 找出那两个数字
        }

        int m = 1;
        // 找出1的位置  右边到左边 m <<= 1;
        while ((z & m) == 0) m <<= 1;

        // 分组的思维
        int t1 = 0, t2 = 0;
        for (int n : nums) {
            if ((n & m) == 1) t1 ^= n;
            else t2 ^= n;
        }


    }


    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 0;
        for (int n : nums) {
            if (set.remove(n)) {
                int curLongest = 1;
                int curNUm = n;
                while (set.remove(curNUm - 1)) curNUm--;  // 向左边查找
                // 统计左边的长度
                curLongest += (n - curNUm);

                // 回到远点
                curNUm = n;
                while (set.remove(curNUm + 1)) curNUm++;  // 向右查找
                // 统计右边长度
                curLongest += (curNUm - n);

                // 每次都来计算最长的长度
                res = Math.max(res, curLongest);
            }
        }
        return res;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {

        int val = preorder[pStart];
        // 找到在中序中的位置
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) idx = i;
        }

        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, pStart + 1, pStart + 1 + idx - inStart, inorder, inStart, idx);
        node.right = helper(preorder, pStart + 1 + idx - inStart, pEnd, inorder, idx, inEnd);
        if (pEnd - pStart == 1) return node;
        if (pEnd - pStart == 0) return null;
        return node;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }
}
