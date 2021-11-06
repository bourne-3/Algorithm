package OutSide.test1;

/**

 */
public class t02 {

    public static void main(String[] args) {
        t02 t = new t02();
        int[][] nums = {{1,2,3} ,{4,5,6},{7,8,9}};
        t.spiralOrder(nums);
    }

    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = col - 1;
        int[] res = new int[row * col];
        int count = 0;
        while (true){
            for (int i = left; i <= right; i++) {
                res[count++] = matrix[top][i];
            }
            if (++top > bottom) break;

            for (int i = top; i <= bottom; i++){
                res[count++] = matrix[i][right];
            }
            if (--right < left) break;

            for (int i = right; i >= left; i--){
                res[count++] = matrix[bottom][i];
            }
            if (--bottom < top) break;

            for (int i = bottom; i >= top; i--){
                res[count++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return res;
    }
}
