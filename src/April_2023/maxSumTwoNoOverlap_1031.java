package April_2023;

/*
    给你一个整数数组 nums 和两个整数 firstLen 和 secondLen, 请你找出并返回两个非重叠子数组中元素的最大和,
    长度分别为 firstLen 和 secondLen.
    长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后, 但二者必须是不重叠的.
    子数组是数组的一个连续部分.
 */
public class maxSumTwoNoOverlap_1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] s = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            s[i + 1] = s[i] + nums[i];
        }
        int res = 0, maxSumA = 0, maxSumB = 0;
        for(int i = firstLen + secondLen; i <= nums.length; i++){
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - secondLen - firstLen]);
            maxSumB = Math.max(maxSumB, s[i - firstLen] - s[i - firstLen - secondLen]);
            //左 a 右 b 跟 左 b 右 a 作比较
            res = Math.max(res, Math.max(maxSumA + s[i] - s[i - secondLen],maxSumB + s[i] - s[i - firstLen]));
        }
        return res;
    }

    //滑动窗口
    public int maxSumTwoNoOverlap2(int[] nums, int firstLen, int secondLen) {
        //左 a 右 b 跟 左 b 右 a 作比较
        return Math.max(maxSum(nums, firstLen, secondLen), maxSum(nums, secondLen, firstLen));
    }

    public int maxSum(int[] nums, int firstLen, int secondLen){
        int suml = 0;
        for(int i = 0; i < firstLen; i++){
            suml += nums[i];
        }
        int maxSumL = suml;
        int sumr = 0;
        for(int i = firstLen; i < firstLen + secondLen; i++){
            sumr += nums[i];
        }
        int res = maxSumL + sumr;
        for(int i = firstLen + secondLen, j = firstLen; i < nums.length; i++, j++){
            suml += nums[j] - nums[j - firstLen];
            maxSumL = Math.max(maxSumL, suml);
            sumr += nums[i] - nums[i - secondLen];
            res = Math.max(res, maxSumL + sumr);
        }
        return res;
    }
}
