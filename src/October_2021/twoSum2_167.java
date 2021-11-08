package October_2021;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个已按照 非递减顺序排列的整数数组 numbers, 请你从数组中找出两个数满足相加之和等于目标数 target .
    函数应该以长度为 2 的整数数组的形式返回这两个数的下标值 .
    numbers 的下标 从 1 开始计数, 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length .
    你可以假设每个输入只对应唯一的答案, 而且你不可以重复使用相同的元素 .
 */

public class twoSum2_167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i]))
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}
