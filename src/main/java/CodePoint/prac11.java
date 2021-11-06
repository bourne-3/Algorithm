package CodePoint;

/**
 矩阵中的路径

 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 同一个单元格内的字母不允许被重复使用。

 */
public class prac11 {

    int[][] directions = {{0, 1}, {0, -1},{1, 0}, {-1, 0}};
    int row;
    int col;

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        prac11 t = new prac11();
        boolean res = t.exist(board, word);
        System.out.println(res);
    }

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[][] hasVisted = new boolean[row][col];
        char[] chs = word.toCharArray();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (dfs(board, chs, i, j, hasVisted, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] words, int r, int c, boolean[][] hasVisted, int len){

        if (words.length == len) return true;
        if (r < 0 || r >= row || c < 0 || c >= col || hasVisted[r][c] || words[len] != board[r][c]) return false;

        hasVisted[r][c] = true;

        for (int[] d:directions){
            if (dfs(board, words, r + d[0], c + d[1], hasVisted, len + 1)) return true;
        }

        hasVisted[r][c] = false;
        return false;
    }
}
