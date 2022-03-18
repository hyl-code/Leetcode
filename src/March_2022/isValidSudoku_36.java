package March_2022;

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
