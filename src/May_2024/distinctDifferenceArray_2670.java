package May_2024;

import java.util.HashSet;
/*
    给你一个下标从 0 开始的数组 nums，数组长度为 n.
    nums 的不同元素数目差数组可以用一个长度为 n 的数组 diff 表示，其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目
        减去后缀 nums[i + 1, ..., n - 1] 中不同元素的数目.
    返回 nums 的不同元素数目差数组.
    注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）.
    特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组.
 */
public class distinctDifferenceArray_2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] sufDiff = new int[n + 1];
        HashSet<Integer> set = new HashSet<>();
        sufDiff[0] = 0;
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            sufDiff[i] = set.size();
        }
        set.clear();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
            res[i] = set.size() - sufDiff[i + 1];
        }
        return res;
    }
}
