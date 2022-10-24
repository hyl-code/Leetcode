package October_2022;

/*
    给定一个数组 nums, 将其划分为两个连续子数组 left 和 right, 使得:
    left 中的每个元素都小于或等于 right 中的每个元素.
    left 和 right 都是非空的.
    left 的长度要尽可能小.
    在完成这样的分组后返回 left 的长度.
    用例可以保证存在这样的划分方法.
 */
public class partitionDisjoint_915 {
    public int partitionDisjoint(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 0;
        //当前最大值
        int max = nums[0];
        //左数组最大值
        int leftMax = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            if(nums[i] < leftMax){
                leftMax = max;
                index = i;
            }
        }
        return index + 1;
    }
}
