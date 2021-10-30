package CodePoint;



/**
 重建二叉树
     输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class prac2 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inoreder) {
        return recur(preorder, 0, preorder.length, inoreder, 0, inoreder.length);
    }

    private TreeNode recur(int[] preorder, int pStart, int pEnd, int[] inoreder, int inStart, int inEnd) {

        if (pStart == pEnd) return null;


        int val = preorder[pStart];

        int idx = 0;
        for (int i = 0; i < inEnd; i++) {
            if (inoreder[i] == val){
                idx = i;
            }
        }

        TreeNode node = new TreeNode(val);
        if (pStart - pEnd == 1) return node;

        node.left = recur(preorder, pStart + 1, pStart + 1 + idx - inStart, inoreder, inStart, idx);  // inorder instart  idx
        node.right = recur(preorder, pStart + 1 + idx - inStart, pEnd, inoreder, idx + 1, inEnd);
        return node;
    }
}
