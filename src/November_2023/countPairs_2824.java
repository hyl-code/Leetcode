package November_2023;

import java.util.Collections;
import java.util.List;
/*
    给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target,
    请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目.
 */
public class countPairs_2824 {
    // 双指针
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int j = nums.size() - 1;
            while (j > i && nums.get(i) + nums.get(j) >= target) {
                j--;
            }
            res += j - i;
        }
        return res;
    }

    // 遍历
    public int countPairs2(List<Integer> nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    res++;
                }
            }
        }
        return res;
    }

    // 排序 + 二分查找
    public int countPairs3(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.size(); i++) {
            int k = binarySearch(nums, 0, i - 1, target - nums.get(i));
            res += k;
        }
        return res;
    }

    public int binarySearch(List<Integer> nums, int left, int right, int target) {
        int res = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }
}
