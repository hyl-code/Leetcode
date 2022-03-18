package March_2022;

/*
    请你判断一个 9 x 9 的数独是否有效 . 只需要 根据以下规则, 验证已经填入的数字是否有效即可 .
    1.数字 1-9 在每一行只能出现一次 .
    2.数字 1-9 在每一列只能出现一次 .
    3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次 .

    注意:
    一个有效的数独 (部分已被填充) 不一定是可解的 .
    只需要根据以上规则, 验证已经填入的数字是否有效即可 .
    空白格用 '.' 表示 .
 */

public class isValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        //记录某行 某个数字是否被放置
        boolean[][] row = new boolean[9][9];
        //记录某行 某个数字是否被放置
        boolean[][] col = new boolean[9][9];
        //记录某3 × 3宫格中 某个数字是否被放置
        boolean[][] block = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    //为3 × 3宫格做标记
                    int blockIndex = i / 3 * 3 + j /3;
                    if(row[i][num] || col[j][num] || block[blockIndex][num]){
                        return false;
                    }else{
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
