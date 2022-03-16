package March_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给你两个整数数组 nums1 和 nums2, 请你以数组形式返回两数组的交集 .
    返回结果中每个元素出现的次数, 应与元素在两个数组中都出现的次数一致 (如果出现次数不一致, 则考虑取较小值) .
    可以不考虑输出结果的顺序 .
 */

public class intersect_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for(int num : nums1){
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for(int num : nums2){
            if(list1.contains(num)){
                list2.add(num);
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[list2.size()];
        int i = 0;
        for(int num : list2){
            res[i++] = num;
        }
        return res;
    }
}
