package July_2023;

import java.util.Arrays;
/*
    给你一个下标从 0 开始的二维整数数组 nums. 一开始你的分数为 0.
    你需要执行以下操作直到矩阵变为空：
        1.矩阵中每一行选取最大的一个数, 并删除它. 如果一行中有多个最大的数, 选择任意一个并删除.
        2.在步骤 1 删除的所有数字中找到最大的一个数字, 将它添加到你的分数中.
    请你返回最后的分数.
 */
public class matrixSum_2679 {
    public int matrixSum(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        int res = 0;
        for(int[] arr : nums){
            Arrays.sort(arr);
        }
        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = 0; j < m; j++){
                max = Math.max(nums[j][i], max);
            }
            res += max;
        }
        return res;
    }
}
