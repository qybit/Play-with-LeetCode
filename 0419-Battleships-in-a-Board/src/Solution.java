/**
 * @author qybit
 * @create 2020-12-17 15:57
 * @Since 1.0.0
 */
public class Solution {

    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    boolean isOK = true;

                    if (i > 0) {
                        if (board[i - 1][j] == 'X') {
                            isOK = false;
                        }
                    }

                    if (j > 0) {
                        if (board[i][j - 1] == 'X') {
                            isOK = false;
                        }
                    }
                    if (isOK) res++;
                }
            }
        }
        return res;
    }
}
