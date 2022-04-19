package April_2022;
import java.util.HashMap;

/*
    给定一个大小为 n 的数组, 找到其中的多数元素 .
    多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素 .
    你可以假设数组是非空的, 并且给定的数组总是存在多数元素 .
 */

public class majorityElement_169 {
    //Hash表
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : nums){
            if(map.get(num) > nums.length / 2){
                res = num;
            }
        }
        return res;
    }

    //摩尔投票法
    public int majorityElement2(int[] nums) {
        int res = 0;
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            if(num == 0){
                res = nums[i];
                num++;
            }else{
                if(res == nums[i]){
                    num++;
                }else{
                    num--;
                }
            }
        }
        return res;
    }
}
