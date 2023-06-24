package June_2023;

/*
    给你一个下标从 0 开始的一维整数数组 original 和两个整数 m 和 n.
    你需要使用 original 中所有元素创建一个 m 行 n 列的二维数组.
    original 中下标从 0 到 n - 1 （都包含）的元素构成二维数组的第一行, 下标从 n 到 2 * n - 1（都包含）的元素构成二维数组的第二行, 依此类推.
    请你根据上述过程返回一个 m x n 的二维数组. 如果无法构成这样的二维数组，请你返回一个空的二维数组.
 */
public class construct2DArray_2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length){
            return new int[][]{};
        }
        int[][] res = new int[m][n];
        int j = 0, k = 0;
        for(int i = 0; i < original.length; i++){
            res[j][k++] = original[i];
            if(k == n){
                k = 0;
                j++;
            }
        }
        return res;
    }
}
