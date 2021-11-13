package CodePoint;



/**
 重建二叉树
     输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class prac2 {

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
}
