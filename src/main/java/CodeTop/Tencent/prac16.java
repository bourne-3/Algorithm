package CodeTop.Tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,2,3],[4,5,6],[7,8,9]
 */
public class prac16 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrder(nums);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if (--right < left) break;

            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if (--bottom < top) break;

            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}
