package OutSide.test1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**

 */
public class t4 {

    public static void main(String[] args) {
//        removeDuplicates("abbaca");
//        removeDuplicates("pbbcggttciiippooaais", 3);
        mySqrt(4);
    }


    public static int mySqrt(int x) {
        int min = 0, max = x;
        while (max - min > 1){
            int mid = min + (max - min) / 2;
            if (mid < x / mid) min = mid + 1;
            else max = mid - 1;
        }
        return min;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> de = new LinkedList<>();
        de.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!de.isEmpty()){
            int size = de.size();
            List<Integer> path = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = de.poll();
                if (node.left != null) de.offer(node.left);
                if (node.right != null) de.offer(node.right);
            }
            res.add(path.get(path.size() - 1));
        }
        return res;
    }


    public static String removeDuplicates(String s, int k) {
        Deque<Character> strStack = new LinkedList<>();
        Deque<Integer> times = new LinkedList<>();

        for (char c:s.toCharArray()){
            if (strStack.isEmpty() || strStack.peek() != c){
                strStack.push(c);
                times.push(1);
            }else if (strStack.peek() == c){
                Integer val = times.pop();
                times.push(val + 1);
            }

            if (!times.isEmpty() && times.peek() == k){
                strStack.pop();
                times.pop();
            }
        }

        StringBuffer path = new StringBuffer();
        while (!strStack.isEmpty()){
            char c = strStack.pop();
            int val = times.pop();
            for (int i = 0; i < val; i++) {
                path.append(c);
            }
        }

        return path.reverse().toString();
    }


    public static String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c:s.toCharArray()){
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder path = new StringBuilder();
        for (char c:stack){
            path.append(c);
        }
        return path.reverse().toString();
    }


    public int findRepeatNumber(int[] nums) {
        // 0～n-1 的范围内
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int nIdx = nums[i];
            nums[(nIdx) % size] += size;
        }

        for (int i = 0; i < size; i++) {
            if (nums[i] > 2 * size - 1) return i;
        }
        return -1;
    }


    public List<Integer> findDuplicates(int[] nums) {
        // 多个重复 找出所有重复的  之前那个是找出任意一个
        int size = nums.length;
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int nIdx = nums[i];
            nums[(nIdx - 1) % size] += size;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > size * 2) path.add(i + 1);
        }
        return path;
    }


}
