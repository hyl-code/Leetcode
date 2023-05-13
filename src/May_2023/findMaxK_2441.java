package May_2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findMaxK_2441 {
    //排序
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(nums[i] == nums[j] * (-1)){
                    return Math.abs(nums[i]);
                }
            }
        }
        return -1;
    }

    public int findMaxK2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = -1;
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            if(set.contains(-num)){
                res = Math.max(num, res);
            }
        }
        return res;
    }

    // 排序 + 双指针
    public int findMaxK3(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1, j = 0; i > j; i--){
            while(i > j && nums[i] < -nums[j]){
                j++;
            }
            if(nums[i] == -nums[j]){
                return nums[i];
            }
        }
        return -1;
    }
}
