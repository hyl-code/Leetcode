package July_2021;

//统计一个数字在排序数组中出现的次数.

public class Search {
    //二分法
    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] >= target)
                right = mid;
            if(nums[mid] < target){
                left = mid + 1;
            }
        }

        while(left <= nums.length - 1 && nums[left++] == target){
            count++;
        }
        return count;
    }
}
