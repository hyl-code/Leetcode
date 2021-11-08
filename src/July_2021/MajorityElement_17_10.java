package July_2021;

//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
// 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。

import java.util.Arrays;

public class MajorityElement_17_10 {
    public int majorityElement(int[] nums) {
        int a;
        int left = 0, right = 1;

        if(nums.length == 1){
            return nums[0];
        }

        Arrays.sort(nums);
        while(right < nums.length){
            if(nums[left] != nums[right]){
                left++;
                right++;
            }else
                right++;
            if((right - left) > nums.length / 2)
                return nums[left];
        }
        return -1;
    }
}
