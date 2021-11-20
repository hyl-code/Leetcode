package November_2021;

/*
    给定一个 n × n 的二维矩阵 matrix 表示一个图像 . 请你将图像顺时针旋转 90 度 .
    你必须在原地旋转图像, 这意味着你需要直接修改输入的二维矩阵 . 请不要使用另一个矩阵来旋转图像 .
 */

public class rotate_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++){
            int begin = i, end = n - i - 1;
            for(int j = 0; j < end - begin; j++){
                int temp = matrix[begin][begin + j];
                matrix[begin][begin + j] = matrix[end - j][begin];
                matrix[end - j][begin] = matrix[end][end - j];
                matrix[end][end - j] = matrix[begin + j][end];
                matrix[begin + j][end] = temp;
            }
        }
    }
}
