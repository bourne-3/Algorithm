package OutSide.test1;

import java.util.*;

/**

 */
public class t2 {

    public static void main(String[] args) {
        majorityElement(new int[]{3, 2, 3});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        // 这个是特殊情况

        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }

        // 这是一般情况，使用三目运算符是为了防止溢出
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }


    public static int majorityElement(int[] nums) {
        // 摩尔投票法
        int vote = 0, z = 0;
        for (int n:nums){
            if (vote == 0) z = n;
            vote += z == n ? 1 : -1;
        }
        return z;
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                res[0] = i;
                res[1] = map.get(diff);
                break;
            }

            map.put(nums[i], i);
        }
        return res;
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> de = new LinkedList<>();
        res.add(root.val);
        de.offer(root);
        while (!de.isEmpty()){
            int size = de.size();
            List<TreeNode> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = de.poll();
                path.add(node);
                if (node.left != null) de.offer(node.left);
                if (node.right != null) de.offer(node.right);
            }
            res.add(path.get(path.size() - 1).val);

        }
        return res;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recur(preorder, 0, preorder.length, inorder, 0, inorder.length);  // 左闭右开
    }

    private TreeNode recur(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        // 空的
        if (pStart == pEnd) return null;

        int val = preorder[pStart];
        int inIdx = 0;
        for (int i = 0; i < inEnd; i++) {
            if (inorder[i] == val) inIdx = i;
        }

        TreeNode node = new TreeNode(val);

        if (pEnd - pStart == 1) return node;
        node.left = recur(preorder, pStart + 1, pStart + 1 + inIdx - inStart, inorder, inStart, inIdx);
        node.right = recur(preorder, pStart + 1 + inIdx - inStart, pEnd, inorder,inIdx + 1, inEnd);
        return node;
    }
}
