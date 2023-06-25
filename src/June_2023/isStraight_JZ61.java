package June_2023;

import java.util.Arrays;
/*
    从若干副扑克牌中随机抽 5 张牌, 判断是不是一个顺子, 即这5张牌是不是连续的.
    2～10为数字本身, A为1, J为11, Q为12, K为13, 而大、小王为 0, 可以看成任意数字. A 不能视为 14.
 */
public class isStraight_JZ61 {
    public boolean isStraight(int[] nums) {
        int r = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                r++;
            }else if(i < nums.length - 1){
                if(nums[i] == nums[i + 1]){
                    return false;
                }else if(nums[i + 1] != nums[i] + 1){
                    r -= nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return r >= 0;
    }
}
