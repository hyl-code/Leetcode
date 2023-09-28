package September_2023;

/*
    整数数组的一个排列就是将其所有成员以序列或线性顺序排列.
    例如, arr = [1,2,3], 以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1].
    整数数组的下一个排列是指其整数的下一个字典序更大的排列.
    更正式地, 如果数组的所有排列根据其字典顺序从小到大排列在一个容器中, 那么数组的下一个排列就是在这个有序容器中排在它后面的那个排列.
    如果不存在下一个更大的排列, 那么这个数组必须重排为字典序最小的排列（即, 其元素按升序排列）.
    例如, arr = [1,2,3] 的下一个排列是 [1,3,2].
    类似地, arr = [2,3,1] 的下一个排列是 [3,1,2].
    而 arr = [3,2,1] 的下一个排列是 [1,2,3], 因为 [3,2,1] 不存在一个字典序更大的排列.
    给你一个整数数组 nums, 找出 nums 的下一个排列.
    必须原地修改, 只允许使用额外常数空间.
 */
public class nextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start){
        int left = start, right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
