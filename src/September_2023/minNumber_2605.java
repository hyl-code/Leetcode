package September_2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
    给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2, 每个数组中的元素互不相同.
    请你返回最小的数字, 两个数组都至少包含这个数字的某个数位.
 */
public class minNumber_2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int min1 = 10, min2 = 10;
        for(int num : nums1){
            set.add(num);
            min1 = Math.min(min1, num);
        }
        Arrays.sort(nums2);
        for(int num : nums2){
            if(set.contains(num)){
                return num;
            }
            min2 = Math.min(min2, num);
        }
        return Math.min(min1, min2) * 10 + Math.max(min1, min2);
    }
}
