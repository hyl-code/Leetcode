package July_2021;

//给定一个非负整数数组 nums ,你最初位于数组的 第一个下标 .
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度.
//
//判断你是否能够到达最后一个下标.

public class canJump {
    public boolean canJump(int[] nums) {
        int n = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= n)
                n = 1;
            else
                n++;
            if(i == 0 && n > 1)
                return false;
        }
        return true;
    }
}
