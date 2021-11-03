package CodePoint;

/**
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。


 */
public class prac26 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        spiralOrder(matrix);
    }

    public static void spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        int cur = 0;
        while (true){
            for (int i = left; i <= right; i++){  // 从左到右，注意要取等于号
                res[cur++] = matrix[top][i];
            }
            if (++top > bottom) break;  // 把该行去掉。这里有趣的一点是下一次开始就从top开始了，下面的也一样是如此

            for (int i = top; i <= bottom; i++){  // 从上到下
                res[cur++] = matrix[i][right];
            }
            if (--right < left) break;

            for (int i = right; i >= left; i--){  // 从右到左
                res[cur++] = matrix[bottom][i];
            }
            if (--bottom < top) break;

            for (int i = bottom; i >= top; i--){  // 从下到上
                res[cur++] = matrix[i][left];
            }
            if (++left > right) break;
        }

        //输出
        for (int i : res) {

            System.out.print(i + " ");
        }
    }
}
