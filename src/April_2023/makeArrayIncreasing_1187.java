package April_2023;

import java.util.Arrays;
import java.util.TreeSet;

/*
    给你两个整数数组 arr1 和 arr2, 返回使 arr1 严格递增所需要的最小「操作」数 (可能为 0).
    每一步「操作」中, 你可以分别从 arr1 和 arr2 中各选出一个索引, 分别为 i 和 j,
    0 <= i < arr1.length 和 0 <= j < arr2.length, 然后进行赋值运算 arr1[i] = arr2[j].
    如果无法让 arr1 严格递增, 请返回 -1.
 */
public class makeArrayIncreasing_1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        if(n == 1){
            return 0;
        }
        // TreeSet 元素不能重复, 具有排序功能.
        TreeSet<Integer> ts = new TreeSet<>();
        if(arr2 != null){
            for(int i = 0; i < arr2.length; i++){
                ts.add(arr2[i]);
            }
        }
        //dp[i][j]表示: 将数组 arr1 的前 j 个元素通过 i 次替换后变为严格递增序列
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = Integer.MIN_VALUE;
        for(int j = 1; j < n + 1; j++){
            for(int i = 0; i <= j; i++){
                //当 arr[j - 1] > dp[i][j - 1] 时, 即前 j 个元素已经严格递增
                if(arr1[j - 1] > dp[i][j - 1]){
                    dp[i][j] = arr1[j - 1];
                }
                //在数组 arr2 中找到第一个比 dp[i-1][j] 大的数
                if(i > 0 && ts.higher(dp[i - 1][j - 1]) != null){
                    dp[i][j] = Math.min(dp[i][j], ts.higher(dp[i - 1][j - 1]));
                }
                if(j == n && dp[i][j] != Integer.MAX_VALUE){
                    return i;
                }
            }
        }
        return -1;
    }
}
