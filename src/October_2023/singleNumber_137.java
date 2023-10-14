package October_2023;

import java.util.HashMap;
import java.util.Map;
/*
    给你一个整数数组 nums, 除某个元素仅出现一次外, 其余每个元素都恰出现三次. 请你找出并返回那个只出现了一次的元素.
    你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题.
 */
public class singleNumber_137 {
    // HashMap 记数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int cnt = entry.getValue();
            if(cnt == 1){
                res = num;
                break;
            }
        }
        return res;
    }
}
