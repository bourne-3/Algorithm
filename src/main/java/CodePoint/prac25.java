package CodePoint;

/**
 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class prac25 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 需要使用辅助函数 （因为有两个节点）
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true; // 到底部了都还是一样的
        if (n1 == null && n2 != null) return false;
        if (n1 != null && n2 == null) return false;
        return n1.val == n2.val && recur(n1.left, n2.right) && recur(n1.right, n2.left);
    }
}
