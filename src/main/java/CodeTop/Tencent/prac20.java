package CodeTop.Tencent;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**

 */
public class prac20 {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> de = new LinkedList<>();
        de.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!de.isEmpty()){
            int size = de.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = de.pop();
                if (node.left != null) de.offer(node.left);
                if (node.right != null) de.offer(node.right);
            }
            res.add(path.get(path.size() - 1));
        }
        return res;
    }
}
