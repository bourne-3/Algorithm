package OutSide.test1;

import java.util.*;

/**
 这个题属于技巧题 首先仔细看输入的给定的数组值 该值的区间为 1 ≤ a[i] ≤ n
 * 这其实是这道题解题的关键点，好好利用这个信息。 某些元素出现了两次，
 * 而一些其他的元素只出现了1次，我们可以利用这些元素在出现次数上面的不一样做文章。
 *
 * 仔细观察发现1 ≤ a[i] ≤ n 这个条件，正好和我们数组的下标差1，我们可以按照数值
 * 来遍历数组，那么在数组中具有相同值的元素，会被经过两次，那么我们只要想出一种方式
 * 在这个遍历结束后可以区分，哪些元素被经过了多次即可，由于数组元素具有1 ≤ a[i] ≤ n
 * 这样的范围，那其实我们当每次经过一个元素时，给他加上n，当遍历结束时，我们再次遍历数组
 * 那些数值超过2n的元素索引+1，对应的就是我们的出现了两次的元素。
 *
 */
public class t1 {

    public static void main(String[] args) {
        String res = removeDuplicates("abbaca");
        System.out.println(res);
        System.out.println(findDuplicates3(new int[]{4,3,2,7,8,2,3,1}));
    }
    public static List<Integer> findDuplicates3(int[] nums) {
        // 4,3,2,7,8,2,3,1
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            nums[(val - 1) % size] += size;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * size) res.add(i + 1);
        }

        return res;
    }


    public static List<Integer> findDuplicates(int[] nums) {
        // 4,3,2,7,8,2,3,1
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n:nums){
            if (map.containsKey(n)){
                map.put(n, map.get(n) + 1);
                continue;
            }
            map.put(n, 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int n:map.keySet()){
            if (map.get(n) == 2){
                res.add(n);
            }
        }
        return res;
    }


    public static String removeDuplicates(String s) {
        // 用栈？
        Deque<Character> de = new LinkedList<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];

            if (!de.isEmpty() && de.peek() == c) {
                de.pop();
                continue;
            }
            de.push(c);
        }
        StringBuilder tmp = new StringBuilder();
        for (char c:de){
            tmp.append(c);
        }
        String res = tmp.reverse().toString();
        return res;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = col - 1;
        List<Integer> path = new ArrayList<>();
        while (true){
            for (int i = left; i <= right; i++) path.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) path.add(matrix[i][right]);
            if (--right < left) break;

            for (int i = right; i >= left; i--) path.add(matrix[bottom][i]);
            if (--bottom < top) break;

            for (int i = bottom; i >= top; i--) path.add(matrix[i][left]);
            if (++left > right) break;
        }
        return path;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        int len1 = 0, len2 = 0;
        while (cur1 !=  null){
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 !=  null){
            len2++;
            cur2 = cur2.next;
        }
        cur1 = headA;
        cur2 = headB;

        if (len1 < len2){
            int tmpLen = len1;
            len1 = len2;
            len2 = tmpLen;

            ListNode tmpNode = cur1;
            cur1 = cur2;
            cur2 = tmpNode;
        }

        int diff = len1 - len2;
        while (diff > 0){
            cur1 = cur1.next;
            diff--;
        }
        while (cur1 !=  null){
            if (cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> de = new LinkedList<>();
        TreeNode cur = root;
        while (!de.isEmpty() || cur != null) {
            if (cur != null) {
                de.push(cur);
                cur = cur.left;
            } else {
                cur = de.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> de = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        de.offer(root);
        while (!de.isEmpty()) {
            int size = de.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = de.poll();
                path.add(node.val);
                if (node.left != null) de.offer(node.left);
                if (node.right != null) de.offer(node.right);
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }


    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else return mid;
        }
        return -1;
    }
}
