package April_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class mostFrequentEven_2404 {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0 && (!map.containsKey(res) || map.get(nums[i]) > map.get(res))){
                res = nums[i];
            }
        }
        return res;
    }
}
