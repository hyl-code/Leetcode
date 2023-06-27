package June_2023;

/*
    给你一个整数数组, 返回它的某个非空子数组（连续元素）在执行一次可选的删除操作后, 所能得到的最大元素总和.
    换句话说, 你可以从原数组中选出一个子数组, 并可以决定要不要从中删除一个元素（只能删一次哦）,
    （删除后）子数组中至少应当有一个元素, 然后该子数组（剩下）的元素总和是所有子数组之中最大的.
    注意, 删除一个元素后, 子数组 不能为空.
 */
public class maximumSum_1186 {
    //动态规划
    public int maximumSum(int[] arr) {
        int[][] dp = new int[arr.length][2];
        int res = arr[0];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        for(int i = 1; i < arr.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            res = Math.max(Math.max(dp[i][0], dp[i][1]), res);
        }
        return res;
    }
}
