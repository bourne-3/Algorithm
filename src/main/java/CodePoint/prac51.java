package CodePoint;

/**
 二叉树的深度
 */
public class prac51 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        return Math.max(l, r) + 1;
    }
}
