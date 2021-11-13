package OutSide.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**

 */
public class t1 {

    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);  // 左闭右开
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        // 只有一个节点
        if (pStart == pEnd) return null;
        int val = preorder[pStart];
        int inIdx = 0;

        for (int i = 0; i < inEnd; i++) {
            if (inorder[i] == val) inIdx = i;
        }

        TreeNode node = new TreeNode(val);
        if (pEnd - pStart == 1) return node;

        node.left = helper(preorder, pStart + 1, pStart + 1 + inIdx - inStart, inorder, inStart, inIdx);
        // 这里中序的右子树 需要从inIdx+1开始，因为inIdx已经不考虑了
        node.right = helper(preorder, pStart + 1 +inIdx - inStart, pEnd, inorder, inIdx + 1, inEnd);
        return node;
    }


    public int[] reversePrint(ListNode head) {
        List<Integer> path = new ArrayList<>();
        // 先反转，然后再一次一次添加
        ListNode pre = null, cur = head, next;
        int len = 0;
        while (cur != null){
            len++;
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        int[] res = new int[len];
        int count = 0;
//        pre是反转后的头节点
        while (pre != null){
            res[count++] = pre.val;
            pre = pre.next;
        }
        return res;


    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j > col){

            int val = matrix[i][j];
            if (val < target) i++;
            else if (val > target) j--;
            else return true;
        }
        return false;
    }


    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n:nums){
            if (!set.add(n))return n;
        }
        return -1;
    }
}
