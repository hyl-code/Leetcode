package May_2024;

import java.util.List;
/*
    给你一个下标从 0 开始的整数数组 nums 和一个整数 k.
    请你用整数形式返回 nums 中的特定元素之和，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位.
    整数的二进制表示中的 1 就是这个整数的置位.
    例如，21 的二进制表示为 10101 ，其中有 3 个置位.
 */
public class sumIndicesWithKSetBits_2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0 ; i < nums.size(); i++) {
            if (bitCount(i) == k) {
                res += nums.get(i);
            }
        }
        return res;
    }

    public int bitCount(int x) {
        int cnt = 0;
        while (x != 0) {
            cnt += (x % 2);
            x /= 2;
        }
        return cnt;
    }
}
