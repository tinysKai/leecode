package recursive;

/**
 * 描述: 判断数独里面的给定数字是否是正确的
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 * https://leetcode.com/problems/sudoku-solver/#/description
 *
 *
 * 思路 :
 *    遍历数独依次填数
 *    使用递归的方式来依次填数,若不正确则将其数还原
 * 2018-11-16
 */
public class SolveSudo {
    public static final char POINT = '.';

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //针对点进行填数
                if (board[i][j] == POINT){
                    for (char c = '1';c <= '9';c++){
                        if (isValid(board,i,j,c)){
                            //校验通过说明目前这个数字符合规则
                            board[i][j] = c; //填数
                            //填完一个数后接着往下递归尝试填接下来的数字
                            if (solve(board))
                                return true;
                            else
                                //校验不通过说明上一个填数不符合,回退
                                board[i][j] = '.';
                         }
                    }
                //在某个点进行全部数字尝试都不行则证明这个数独不能成功
                return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
       for (int i = 0;i < 9; i++){
           if (board[i][col] != POINT && board[i][col] == c) return  false; //check row
           if (board[row][i] != POINT && board[row][i] == c) return  false; //check col

           //check 3 * 3 block
           if (board[3 * (row/3) + i/3][3 * (col / 3) + i % 3]  != POINT
                   && board[3 * (row/3) + i/3][3 * (col / 3) + i % 3]  == c) return false;

       }
       return true;
    }
}
