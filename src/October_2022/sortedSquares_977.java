package October_2022;

import java.util.Arrays;

public class sortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}
