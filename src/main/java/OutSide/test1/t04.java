package OutSide.test1;

/**

 */
public class t04 {

    public static void main(String[] args) {

    }


    void QuickSort(int[] nums, int i, int j){
        if (i < j){
            int p = parition(nums, i, j);
            QuickSort(nums, i, p - 1);
            QuickSort(nums, p + 1, j);
        }
    }

    private int parition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j){
            while (i < j && nums[j] >= pivot) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }


    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }


    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int col;
    int row;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                maxArea = Math.max(dfs(i, j, grid), maxArea);
            }
        }
        return maxArea;
    }

    int dfs(int i, int j, int[][] grid){
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) return 0;
        int tmpArea = 0;
        for (int[] d:directions){
            tmpArea += dfs(i + d[0], j + d[1], grid);
        }
        return tmpArea;
    }
}
