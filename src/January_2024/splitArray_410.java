package January_2024;

import java.util.Arrays;
/*
    给定一个非负整数数组 nums 和一个整数 k, 你需要将这个数组分成 k 个非空的连续子数组.
    设计一个算法使得这 k 个子数组各自和的最大值最小.
 */
public class splitArray_410 {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[n + 1][k + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for(int i = 0; i < n; i++){
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= Math.min(i, k); j++){
                for(int m = 0; m < i; m++){
                    f[i][j] = Math.min(f[i][j], Math.max(f[m][j - 1], sub[i] - sub[m]));
                }
            }
        }
        return f[n][k];
    }
}
