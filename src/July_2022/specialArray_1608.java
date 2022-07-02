package July_2022;
import java.util.Arrays;

/*
    给你一个非负整数数组 nums .
    如果存在一个数 x , 使得 nums 中恰好有 x 个元素大于或者等于 x ,
    那么就称 nums 是一个 特殊数组, 而 x 是该数组的特征值 .

    注意: x 不必是 nums 的中的元素 .

    如果数组 nums 是一个特殊数组, 请返回它的特征值 x .
    否则, 返回 -1 . 可以证明的是, 如果 nums 是特殊数组, 那么其特征值 x 是唯一的 .
 */

public class specialArray_1608 {
    //二分法
    public int specialArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while(left <= right){
            int mid = left + (right - left) / 2;
            int len = nums.length - mid;
            if(nums[mid] >= len){
                //nums[mid - 1] 表示的是nums数组中第 mid 个数
                if(mid == 0 || nums[mid - 1] < len){
                    return nums.length - mid;
                }else{
                    right = mid - 1;;
                }
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
