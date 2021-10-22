package October_2021;

/*
    给定一个大小为 n 的整数数组, 找出其中所有出现超过 [ n/3 ] 次的元素.
 */

import java.util.*;

public class majorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //key代表数组中的值, value代表该数在数组中出现的次数.
        Arrays.sort(nums);
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        for(int num : map.keySet()){
            if(map.get(num) > nums.length / 3)
                list.add(num);
        }
        return list;
    }
}
