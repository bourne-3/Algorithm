package OutSide.test1;

/**

 */
public class t08 {



    int row, col;
    boolean[][] visited;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C' ,'E'},{'S', 'F', 'C' ,'S'},{'A', 'D', 'E' ,'E'}};
        String words = "ABCCED";
        t08 t = new t08();
        t.exist(board, words);
    }

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        char[] chs = word.toCharArray();
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, board, chs, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, char[] chs, int len) {
        // 符合条件
        if (len == chs.length) return true;

        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || chs[len] != board[i][j]) return false;
        visited[i][j] = true;
        for (int[] d:directions){
            if (dfs(i + d[0], j + d[1], board, chs, len + 1)) return true;
        }

        visited[i][j] =false;

        return false;
    }
}
