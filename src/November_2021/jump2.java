package November_2021;

/*
    给你一个非负整数数组 nums , 你最初位于数组的第一个位置 .
    数组中的每个元素代表你在该位置可以跳跃的最大长度 .
    你的目标是使用最少的跳跃次数到达数组的最后一个位置 .
    假设你总是可以到达数组的最后一个位置 .
 */

public class jump2 {
    public int jump1(int[] nums) {
        int res = 0;
        int n = nums.length - 1;
        while(n > 0){
            for(int i = 0; i < n; i++){
                if(n - nums[i] <= i){
                    n = i;
                    res++;
                }
            }
        }
        return res;
    }

    public int jump2(int[] nums) {
        int res = 0;
        int max = 0, end = 0;
        for(int i = 0; i < nums.length - 1; i++){
            max = Math.max(max, i + nums[i]);
            if(i == end){
                end = max;
                res++;
            }
        }
        return res;
    }
}
