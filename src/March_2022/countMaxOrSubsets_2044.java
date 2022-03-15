package March_2022;

/*
    给你一个整数数组 nums, 请你找出 nums 子集 按位或 可能得到的 最大值, 并返回按位或能得到最大值的 不同非空子集的数目 .
    如果数组 a 可以由数组 b 删除一些元素 (或不删除) 得到, 则认为数组 a 是数组 b 的一个 子集 .
    如果选中的元素下标位置不一样, 则认为两个子集 不同 .
    对数组 a 执行 按位或, 结果等于 a[0] OR a[1] OR ... OR a[a.length - 1] (下标从 0 开始) .
 */

public class countMaxOrSubsets_2044 {
    public int countMaxOrSubsets(int[] nums) {
        int n = 1 << nums.length;
        int max = 0, res = 0;

        for(int num : nums){
            max |= num;
        }
        for(int mask = 0; mask < n; mask++){
            int temp = 0;
            for(int i = 0; i < nums.length; i++){
                if(((mask >> i) & 1) == 1){
                    temp |= nums[i];
                }
            }
            if(temp == max){
                res++;
            }
        }
        return res;
    }
}
