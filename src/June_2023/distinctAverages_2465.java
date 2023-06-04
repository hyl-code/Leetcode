package June_2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    给你一个下标从 0 开始长度为偶数的整数数组 nums.
    只要 nums 不是空数组, 你就重复执行以下步骤：
        找到 nums 中的最小值, 并删除它.
        找到 nums 中的最大值, 并删除它.
        计算删除两数的平均值.

    两数 a 和 b 的平均值为 (a + b) / 2.
    比方说, 2 和 3 的平均值是 (2 + 3) / 2 = 2.5.
    返回上述过程能得到的不同平均值的数目.
    注意, 如果最小值或者最大值有重复元素，可以删除任意一个.
 */
public class distinctAverages_2465 {
    public int distinctAverages(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n / 2; i++){
            int sum = nums[i] + nums[n - i - 1];
            if(!set.contains(sum)){
                set.add(sum);
            }
        }
        return set.size();
    }
}
