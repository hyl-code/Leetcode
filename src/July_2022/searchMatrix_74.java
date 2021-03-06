package July_2022;

public class searchMatrix_74 {
    //从右上角或左下角开始遍历
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > target){
                col--;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
}
