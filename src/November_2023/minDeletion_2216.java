package November_2023;

/*
    给你一个下标从 0 开始的整数数组 nums, 如果满足下述条件, 则认为数组 nums 是一个美丽数组：
        nums.length 为偶数
        对所有满足 i % 2 == 0 的下标 i, nums[i] != nums[i + 1] 均成立
    注意, 空数组同样认为是美丽数组.
    你可以从 nums 中删除任意数量的元素.
    当你删除一个元素时, 被删除元素右侧的所有元素将会向左移动一个单位以填补空缺, 而左侧的元素将会保持不变.
    返回使 nums 变为美丽数组所需删除的最少元素数目.
 */
public class minDeletion_2216 {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int res = 0;
        boolean check = true;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i + 1] && check){
                res++;
            }else{
                check = !check;
            }
        }
        if((n - res) % 2 != 0){
            res++;
        }
        return res;
    }
}
