package November_2022;
import java.util.Arrays;

/*
    给你一个数组 nums. nums 的源数组中, 所有元素与 nums 相同, 但按非递减顺序排列.
    如果 nums 能够由源数组轮转若干位置(包括 0 个位置)得到, 则返回 true; 否则, 返回 false.
    源数组中可能存在重复项.
    注意: 我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B,
    当它们满足 A[i] == B[(i+x) % A.length], 其中 '%' 为取余运算.
 */
public class check_1752 {
    public boolean check(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for(int i = 0; i < nums.length; i++){
            if(cycle(nums, arr, i)){
                return true;
            }
        }
        return false;
    }

    public boolean cycle(int[] nums, int[] arr, int k){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != arr[(i + k) % nums.length]){
                return false;
            }
        }
        return true;
    }
}
