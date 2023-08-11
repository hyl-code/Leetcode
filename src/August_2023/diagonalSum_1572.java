package August_2023;

/*
    给你一个正方形矩阵 mat, 请你返回矩阵对角线元素的和.
    请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和.
 */
public class diagonalSum_1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += mat[i][i] + mat[i][n - 1 - i];
            if(i == n - 1 - i){
                sum -= mat[i][i];
            }
        }
        return sum;
    }
}
