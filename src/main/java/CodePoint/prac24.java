package CodePoint;

/**
 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class prac24 {

    public static void main(String[] args) {

    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
