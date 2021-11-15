package CodeTop.Tencent;

import java.util.*;

/**

 */
public class prac14 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> de = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return  res;
        de.offer(root);
        while (!de.isEmpty()){
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
}
