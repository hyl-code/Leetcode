package June_2023;

import java.util.Deque;
import java.util.LinkedList;
/*
    在 n * m 大小的棋盘中, 有黑白两种棋子, 黑棋记作字母 "X", 白棋记作字母 "O", 空余位置记作 "." 。
    当落下的棋子与其他相同颜色的棋子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子, 则可以翻转这些棋子的颜色.

    「力扣挑战赛」黑白翻转棋项目中, 将提供给选手一个未形成可翻转棋子的棋盘残局, 其状态记作 chessboard .
    若下一步可放置一枚黑棋, 请问选手最多能翻转多少枚白棋.
    注意：
        若翻转白棋成黑棋后, 棋盘上仍存在可以翻转的白棋, 将可以继续翻转白棋.
        输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置.
 */
public class flipChess_LCP41 {
    int[][] directions = {{-1, 0}, {-1, 1},{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public int flipChess(String[] chessboard) {
        char[][] board = new char[chessboard.length][chessboard[0].length()];
        int res = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = chessboard[i].charAt(j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    res = Math.max(res, curRes(board, new int[]{i, j}));
                }
            }
        }
        return res;
    }

    private int curRes(char[][] board, int[] insert){
        Deque<int[]> record = new LinkedList<>();
        char[][] copy = new char[board.length][board[0].length];
        int res = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                copy[i][j] = board[i][j];
            }
        }
        record.offer(new int[]{insert[0], insert[1]});
        copy[insert[0]][insert[1]] = 'X';
        while(!record.isEmpty()){
            int[] cur = record.remove();
            for(int i = 0; i < directions.length; i++){
                if(isValid(cur, directions[i], copy)){
                    int x = cur[0], y = cur[1];
                    int dx = directions[i][0], dy = directions[i][1];
                    x += dx;
                    y += dy;
                    while(copy[x][y] == 'O'){
                        res++;
                        copy[x][y] = 'X';
                        record.offer(new int[]{x, y});
                        x += dx;
                        y += dy;
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(int[] point, int[] direction, char[][] board){
        int x = point[0], y = point[1];
        int px = direction[0], py = direction[1];
        x += px;
        y += py;
        while(x >= 0 && x < board.length && y >= 0 && y < board[0].length){
            if(board[x][y] == '.'){
                return false;
            }else if(board[x][y] == 'X'){
                return true;
            }
            x += px;
            y += py;
        }
        return false;
    }
}
