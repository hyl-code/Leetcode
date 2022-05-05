package May_2022;

/*
    给你一个整数数组 nums 和一个整数 k , 请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目 .
 */

public class numSubarrayProductLessThanK_713 {
    //滑动窗口  入门题？
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int prod = 1, i = 0;
        for(int j = 0; j < nums.length; j++){
            prod *= nums[j];
            while(i <= j && prod >= k){
                prod /= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    //二分法查找
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(k == 0)
            return 0;
        double[] logPrefix = new double[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }
        double logk = Math.log(k);
        int res = 0;
        for(int j = 0; j < nums.length; j++){
            int l = 0;
            int r = j + 1;
            int index = j + 1;
            double val = logPrefix[j + 1] - logk + 1e-10;
            while(l <= r){
                int mid = (l + r) / 2;
                if(logPrefix[mid] > val){
                    index = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            res += j + 1 - index;
        }
        return res;
    }
}
