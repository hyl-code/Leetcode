package March_2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class arithmeticTriplets_2367 {
    // HashSet
    public int arithmeticTriplets2(int[] nums, int diff) {
        Set<Integer> set = new HashSet<Integer>();
        int res = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            if(set.contains(num + diff) && set.contains(num + diff * 2)){
                res++;
            }
        }
        return res;
    }

    // HashMap
    public int arithmeticTriplets(int[] nums, int diff) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            map.put(i, i + diff);
        }
        for (int i : nums) {
            int num = map.get(i);
            if (map.containsKey(num)) {
                num = map.get(num);
                if (map.containsKey(num)) {
                    res++;
                }
            }
        }
        return res;
    }
}
