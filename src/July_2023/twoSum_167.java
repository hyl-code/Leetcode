package July_2023;

import java.util.HashMap;
import java.util.Map;
/*
    给你一个下标从 1 开始的整数数组 numbers, 该数组已按非递减顺序排列, 请你从数组中找出满足相加之和等于目标数 target 的两个数.
    如果设这两个数分别是 numbers[index1] 和 numbers[index2], 则 1 <= index1 < index2 <= numbers.length.
    以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2.
    你可以假设每个输入只对应唯一的答案, 而且你不可以重复使用相同的元素.
    你所设计的解决方案必须只使用常量级的额外空间.
 */
public class twoSum_167 {
    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{ left + 1, right + 1 };
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] numbers, int target) {
        for(int i = 0, j = numbers.length - 1; i < j; ){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{ i + 1, j + 1 };
            }else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{};
    }

    // HashMap：有序、无序都可
    public int[] twoSum3(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i + 1);
        }
        for(int i = 0; i < numbers.length - 1; i++){
            if(map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i + 1){
                return new int[]{ i + 1, map.get(target - numbers[i])};
            }
        }
        return new int[]{};
    }
}
