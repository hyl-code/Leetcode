package June_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
    数组中有一个数字出现的次数超过数组长度的一半, 请找出这个数字.
    你可以假设数组是非空的, 并且给定的数组总是存在多数元素.
 */
public class majorityElement_JZ39 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // HashMap
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);
            if(map.get(nums[i]) > nums.length / 2){
                return nums[i];
            }
        }
        return -1;
    }

    //摩尔投票法：把众数记为 +1, 其他数记为 -1, 把它们全部加起来, 显然和 > 0.
    public int majorityElement3(int[] nums) {
        int res = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                res = nums[i];
            }
            cnt = res == nums[i] ? cnt + 1 : cnt - 1;
        }
        return res;
    }
}
