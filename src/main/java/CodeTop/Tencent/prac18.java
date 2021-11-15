package CodeTop.Tencent;

/**

 */
public class prac18 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pEnd == pStart) return null;
        int val = preorder[pStart];
        int inIdx = 0;
        for (int i = 0; i < inEnd; i++) {
            if (val == inorder[i]) inIdx = i;
        }

        TreeNode node = new TreeNode(val);
        if (pEnd - pStart == 1) return node;

        node.left = helper(preorder, pStart + 1, pStart + 1 + inIdx - inStart, inorder, inStart, inIdx);
        node.right = helper(preorder, pStart + 1 + inIdx - inStart, pEnd, inorder, inIdx + 1, inEnd);

        return node;
    }
}
