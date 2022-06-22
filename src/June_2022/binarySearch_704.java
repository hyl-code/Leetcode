package June_2022;

/*
    给定一个 n 个元素有序的(升序)整型数组 nums 和一个目标值 target ,
    写一个函数搜索 nums 中的 target, 如果目标值存在返回下标, 否则返回 -1 .
 */

public class binarySearch_704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
