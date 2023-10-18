package October_2023;

import java.util.HashMap;
import java.util.Map;
/*
    给你一个由不同正整数组成的数组 nums, 请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量.
    其中 a、b、c 和 d 都是 nums 中的元素, 且 a != b != c != d.
 */
public class tupleSameProduct_1726 {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // map 记乘积的数
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int mul = nums[i] * nums[j];
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        }
        int res = 0;
        for(int value : map.values()){
            res += value * (value - 1) * 4;
        }
        return res;
    }
}
