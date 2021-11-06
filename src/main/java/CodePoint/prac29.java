package CodePoint;

/**
 二叉树展开为链表

 给你二叉树的根结点 root ，请你将它展开为一个单链表：

 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 展开后的单链表应该与二叉树 先序遍历 顺序相同。
  
 */
public class prac29 {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) return ;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 断开左边
        root.left = null;
        // 连接在右边
        root.right = left;

        // 循环找到右边最底部
        TreeNode cur = root;
        while (cur.right != null){
            cur = cur.right;
        }

        // 连上
        cur.right = right;

    }
}
