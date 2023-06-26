package June_2023;

/*
    给你一个正整数 n, 找出满足下述条件的中枢整数 x ：
        1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和.

    返回中枢整数 x. 如果不存在中枢整数, 则返回 -1. 题目保证对于给定的输入, 至多存在一个中枢整数.
 */
public class pivotInteger_2485 {
    public int pivotInteger(int n) {
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + i;
        }
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(preSum[n] - preSum[mid - 1] == preSum[mid]){
                return mid;
            }else if(preSum[n] - preSum[mid - 1] > preSum[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
